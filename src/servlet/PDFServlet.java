package servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "PDFServlet" ,urlPatterns = "/PDFServlet")
public class PDFServlet extends HttpServlet{
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/pdf");
        String basePath = request.getServletContext().getRealPath("/");
        System.out.println("path:  "+basePath);
        File PDF = null;
        byte []buffer = new byte[1024*1024];
        FileInputStream input = null;
        ServletOutputStream outputStream = response.getOutputStream();
        try {
            PDF = new File(basePath+"/PDF/第七章.pdf");
            input = new FileInputStream(PDF);
            response.setContentLength((int)PDF.length());
            int readByte=-1;
            while ((readByte = input.read(buffer,0,1024*1024))!=-1){
                outputStream.write(buffer,0,1024*1024);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (outputStream != null) {
                outputStream.close();
            }
            if (input!=null){
                input.close();
            }
        }
    }


    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
