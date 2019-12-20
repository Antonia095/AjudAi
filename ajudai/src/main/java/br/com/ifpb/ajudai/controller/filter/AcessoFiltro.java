package br.com.ifpb.ajudai.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/pages/usuario/*")
public class AcessoFiltro implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if(req.getSession().getAttribute("usuario")!=null){
            filterChain.doFilter(req,resp);
        }else{
            resp.sendRedirect("../../index.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
