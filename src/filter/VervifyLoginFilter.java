package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(
        filterName = "VervifyFilter" ,
        urlPatterns = {"/*"},
        initParams = {
                @WebInitParam(name = "loginStrings",value = "login.jsp;/servlet/LoginServlet;register.jsp;/servlet/RegisterServlet;/servlet/LogoutServlet;index.jsp"),
                @WebInitParam(name = "filterStrings",value = ".servlet*;.jsp"),
                @WebInitParam(name = "disableFilter",value = "N")
        }
)
public class VervifyLoginFilter implements Filter {
    private FilterConfig filterConfig =null;

    @Override
    public void init (FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy ( ) {
        this.filterConfig=null;
    }

    @Override
    public void doFilter (ServletRequest request, ServletResponse response, FilterChain Chain) throws IOException, ServletException {
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse)response);
        String loginStrings = filterConfig.getInitParameter("loginStrings");
        String filterStrings = filterConfig.getInitParameter("filterStrings");
        String disableFilter = filterConfig.getInitParameter("disableFilter");
        if("Y".equals(disableFilter)){
            Chain.doFilter(request,response);
            return;
        }
        HttpServletRequest hrequest = ((HttpServletRequest)request);
        String uri  =hrequest.getRequestURI();
        //System.out.println(uri);
        String [] loginArray = loginStrings.split(";");
        String [] filterArray = filterStrings.split(";");
        if(isMachter(loginArray,uri)){
            Chain.doFilter(request,response);
            return;
        }

        if (isMachter(filterArray,uri)){
            String status=(String)hrequest.getSession().getAttribute("status");
           // System.out.println("Filter分派去login.jsp");
            if("true".equals(status)){
                Chain.doFilter(request,response);
                return;
            }else {
                wrapper.sendRedirect("/login.jsp");
                return;
            }
        }else {
            Chain.doFilter(request,response);
        }

    }

    private boolean isMachter(String[] s, String uri){
        for(String str:s) {
            Pattern p = Pattern.compile(str);
            Matcher matcher = p.matcher(uri);
            if(matcher.find()){
                return true;
            }
        }
        return false;
    }
}
