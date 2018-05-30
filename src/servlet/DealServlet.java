package servlet;

import dao.DealDisplay;
import entiy.Deal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(
        name = "DealServlet",
        urlPatterns = "/servlet/DealServlet"
)
public class DealServlet extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DealDisplay dealDisplay = new DealDisplay();
        int id = Integer.parseInt(request.getParameter("id"));
        if(session.getAttribute("usename")==null||"".equals(session.getAttribute("username"))){
            response.sendRedirect("/login.jsp");
        }else {
            if(dealDisplay.finishDeals(session.getAttribute("username").toString(),id)){
                response.sendRedirect("/index.jsp");
            }else {
                response.sendRedirect("/Deal.jsp?dodeal=false");
            }
        }
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }



}
