package br.com.ifpb.ajudai.controller.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class TelaInicioFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServlet = (HttpServletRequest) servletRequest;
        if(httpServlet.getSession().getAttribute("usuario")!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
