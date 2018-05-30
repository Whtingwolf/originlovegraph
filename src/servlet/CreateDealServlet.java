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
        name = "CreateDealServlet",
        urlPatterns = "/servlet/CreateDealServlet"
)
public class CreateDealServlet extends HttpServlet {

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset = utf-8");
        request.setCharacterEncoding("utf-8");
        Deal deal = new Deal();
        HttpSession session = request.getSession();
        DealDisplay dealDisplay = new DealDisplay();
        String typename = request.getParameter("typename");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String username = (String)session.getAttribute("username");
        if (typename != null && !typename.equals("")) {
            deal.setTypename(typename);
        }
        if (price != null && !price.equals("")) {
            deal.setPrice(Integer.parseInt(price));
        }
        if (description != null && !description.equals("")) {
            deal.setDescription(description);
        }
        if (username != null&&!username.equals("")) {
            deal.setOriginator((String) session.getAttribute("username"));
        }
        int[] pictures;
        String[] selected = request.getParameterValues("ck");
        if (selected != null && selected.length > 0) {
            pictures = new int[selected.length];
            for (int i = 0; i < selected.length; i++) {
                pictures[i] = Integer.parseInt(selected[i]);
            }
            deal.setPicutres(pictures);
            if (dealDisplay.createDeal(deal)) {
                response.sendRedirect("/index.jsp");
            } else {
                response.sendRedirect("/createDeal.jsp");
            }

        } else {
            response.sendRedirect("/createDeal.jsp");
        }

    }
}
