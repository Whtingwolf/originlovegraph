package servlet;


import com.sun.deploy.net.HttpResponse;
import entiy.User;
import util.DBHelper;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@WebServlet(
        name = "RegisterServlet",
        urlPatterns = "/servlet/register_servlet",
        asyncSupported = true
)

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
//        检验是否有空参数
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        if ("".equals(request.getParameter("phonenumber")) || "".equals(request.getParameter("username")) || "".equals(request.getParameter("password")) || !request.getParameter("password").equals(request.getParameter("confirmpassword"))) {
            session.setAttribute("status","false");
            response.sendRedirect("/register.jsp");
        } else {
            User newUser = new User();
            newUser.setUsername(request.getParameter("username"));
            newUser.setPassword(request.getParameter("password"));
            newUser.setNumberphone(request.getParameter("phonenumber"));
            System.out.println("开启异步");
            AsyncContext ctx = request.startAsync(request,response);
            System.out.println("获取异步");
            new Thread(new Asyncexcutor(newUser,ctx)).start();
            System.out.println("执行异步");
            response.sendRedirect("/test.jsp");
        }
    }

    public boolean doregister (User user) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
          /*  conn = DBHelper.getConnection();
            String sql = "select username from users";
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                if (rs.getString("username").equals(user.getUsername())) {
                    System.out.println("已经存在该用户名");
                    return false;
                }
            }
            sql = "insert into users VALUES ('" + user.getUsername() + "','" + user.getPassword() + "','" + user.getNumberphone() + "');";
            statement = conn.prepareStatement(sql);
            statement.executeUpdate();*/
            return true;
        } catch (Exception e) {
            System.out.println("注册失败");
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
    class Asyncexcutor implements Runnable{
        AsyncContext asyncContext= null;
        User user = null;
        public Asyncexcutor(){}
        public Asyncexcutor(User user,AsyncContext asyncContext){
            this.user = user;
            this.asyncContext = asyncContext;
        }
        @Override
        public void run ( ) {
            if(user!=null) {
                if (doregister(user)) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    HttpSession session = ((HttpServletRequest)asyncContext.getRequest()).getSession();
                    //设置session表示登录成功
                    session.setAttribute("username", user.getUsername());
                    session.setAttribute("status", "true");
                }
                asyncContext.complete();
            }
        }
    }

}
