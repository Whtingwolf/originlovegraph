package servlet;

import dao.LoginDao;
import entiy.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "LoginServlet" ,urlPatterns = "/servlet/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String path = request.getContextPath();
        HttpSession session = request.getSession();
        LoginDao login_instance = LoginDao.getInstance();
        User user = new User();
        user.setUsername((String) request.getParameter("username"));
        user.setPassword((String) request.getParameter("password"));
        request.setAttribute("test",user);
        if (login_instance.userlogin(user)) {
            session.setAttribute("status", "true");
            session.setAttribute("username", request.getParameter("username"));
            response.sendRedirect("/index.jsp");
        } else {
            session.setAttribute("status","false");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }
}
