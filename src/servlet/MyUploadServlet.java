package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@WebServlet(name = "MyUploadServlet", urlPatterns = "/MyUploadServlet")
@MultipartConfig(location = "d:\\")
public class MyUploadServlet extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset =utf-8");
        String path = request.getServletContext().getRealPath("/") + "fileStore";
        for (Part p : request.getParts()) {
            String fileName = getFileName(p);
            System.out.println(fileName);
            if (!"".equals(fileName)) {
                File file = new File(path + "\\" + fileName);
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                }
                System.out.println(path + "\\" + fileName);
                p.write(path + "\\" + fileName);
            }
        }
    }

    private String getFileName (Part part) {
        String contenDesc = part.getHeader("content-disposition");
        String fileName = "";
        Pattern pattern = Pattern.compile("filename=\".+\"");
        Matcher matcher = pattern.matcher(contenDesc);
        System.out.println(contenDesc);
        if (matcher.find()) {
            fileName = matcher.group();
            //这样获取fileName不直观，可读性差
            fileName = fileName.substring(10, fileName.length() - 1);
            //这样好点
          /*  System.out.println("剪切前:"+fileName);
            fileName = StringUtils.substringBetween(fileName,"filename=\"","\"");
            System.out.println("剪切后:"+fileName);*/
        }
        return fileName;
    }
}
