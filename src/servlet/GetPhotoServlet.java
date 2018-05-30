package servlet;

import dao.DealDisplay;
import dao.Photosdao;
import entiy.Deal;
import entiy.Photos;
import entiy.Photos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(
        name = "GetPhotoServlet",
        urlPatterns = "/servlet/GetPhotoServlet"
)
public class GetPhotoServlet extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset = utf-8");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        Photosdao photosdao = new Photosdao();
        String requestType = request.getParameter("requestType");
        if ("showDeal".equals(requestType)) {
            DealDisplay dealDisplay = new DealDisplay();
            ArrayList <Deal> list = dealDisplay.getDealsNotFinished();
            Map<String,ArrayList> photoMap = new HashMap<String,ArrayList>();
            if (list == null & list.size() <= 0) {
                System.out.println("list为空");
            }
            if (list != null & list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    Deal deal = list.get(i);
                    ArrayList <Photos> PhotoList = new ArrayList <>();
                    for (int k = 0; k < deal.getPicutres().length; k++) {
                        Photos picture = photosdao.getPhotoById(deal.getPicutres()[k]);
                        PhotoList.add(picture);
                    }
                    photoMap.put("Photos"+(i+1),PhotoList);
                }
                session.setAttribute("dealList",list);
                session.setAttribute("photosMap",photoMap);
                response.sendRedirect("/Deal.jsp");
                return;
            }
        }
        /*if (session.getAttribute("status") == null || "".equals(session.getAttribute("status"))) {
            response.sendRedirect("/login.jsp");
            return;
        }*/
        if ("myPhoto".equals(requestType)) {
            ArrayList <Photos> list = photosdao.getPhotosByName(username);
            session.setAttribute("photolist", list);
            response.sendRedirect("/myphoto.jsp");
            return;
        }
        if ("createDeal".equals(requestType)) {
            ArrayList <Photos> list = photosdao.getPhotosByName(username);
            session.setAttribute("photolist", list);
            response.sendRedirect("/createDeal.jsp");
            return;
        }
        if("detail".equals(requestType)){
            Photos photos = photosdao.getPhotoById(Integer.parseInt(request.getParameter("id")));
            ArrayList<Photos> list = new ArrayList <Photos>();
            list.add(photos);
            session.setAttribute("photolist",list);
            response.sendRedirect("/detail.jsp");
            return;
        }
        if("mydeal".equals(requestType)){
            DealDisplay dealDisplay = new DealDisplay();
            ArrayList<Deal> list = dealDisplay.getDealsByUser(username);
            Map<String,ArrayList> photoMap = new HashMap <String ,ArrayList>();
            if(list==null&list.size()<=0){
                System.out.println("list为空");
            }
            for(int i=0;i<list.size();i++){
                int []photos = list.get(i).getPicutres();
                ArrayList<Photos> photoList = new ArrayList <Photos>();
                for(int j=0;j<photos.length;j++){
                    Photos photos1 = photosdao.getPhotoById(photos[j]);
                    photoList.add(photos1);
                }
                photoMap.put("numbers"+i,photoList);
            }
            session.setAttribute("DealList",list);
            session.setAttribute("photoMap",photoMap);
            response.sendRedirect("/myDeals.jsp");
            return;
        }
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
