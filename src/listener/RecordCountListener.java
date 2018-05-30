package listener;


import dao.Counter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class RecordCountListener implements ServletContextListener {
    Counter c_file = null;

    public RecordCountListener ( ) {
        c_file = new Counter();
    }

    String path = "";

    @Override
    public void contextInitialized (ServletContextEvent sce) {
        path = sce.getServletContext().getInitParameter("CounterFilePath");
        String counts = c_file.readFile(path);
        if ("文件为空".equals(counts)) {
            counts = "0";
        }
        sce.getServletContext().setAttribute("RecordCount", counts);
    }

    @Override
    public void contextDestroyed (ServletContextEvent sce) {
        path = sce.getServletContext().getInitParameter("CounterFilePath");
        String counts = (String) sce.getServletContext().getAttribute("RecordCount");
        if (counts == null) {
            return;
        }
        c_file.writeFile(path, counts);
    }
}
