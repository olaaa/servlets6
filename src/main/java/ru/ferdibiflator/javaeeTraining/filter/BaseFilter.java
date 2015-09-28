package ru.ferdibiflator.javaeeTraining.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class BaseFilter implements Filter{
    FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(">> BaseFilter - init");
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        doFilter((HttpServletRequest) request, (HttpServletResponse) response, chain);
    }

    public abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain )throws IOException, ServletException;

    public void destroy() {
        System.out.println(">> BaseFilter - DESTROY");
    }
}
