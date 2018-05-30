package listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener()
public class CountSessionListener implements HttpSessionListener {
    @Override
    public synchronized void sessionCreated (HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        int historyCount = 0;
        String count = (String) servletContext.getAttribute("RecordCount");
        historyCount = Integer.parseInt(count);
        historyCount++;
        count = String.valueOf(historyCount);
        servletContext.setAttribute("RecordCount", count);
        int online;
        String s_online = (String) servletContext.getAttribute("OnlineCount");
        if (s_online == null) {
            online = 0;
        } else {
            online = Integer.parseInt(s_online);
        }
        online++;
        servletContext.setAttribute("OnlineCount", online);
    }

    @Override
    public synchronized void sessionDestroyed (HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        int online = Integer.parseInt((String) servletContext.getAttribute("OnlineCount"));
        online--;
        servletContext.setAttribute("OnlineCount", online);
    }
}
