package web;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
     if(Checkingcookie.check(servletRequest)){
         filterChain.doFilter(servletRequest, servletResponse);
     }
     else {
         ((HttpServletResponse)servletResponse).sendRedirect("/login/*");
     }
    }

    @Override
    public void destroy() {

    }
}
