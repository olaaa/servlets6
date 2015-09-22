package ru.ferdibiflator.springDemoApplication.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class InfoFilter extends BaseFilter{
    public InfoFilter() {
        System.out.println(">> InfoFilter - new");
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(">> InfoFilter - METHOD: " + request.getMethod() + "; URI: " + request.getRequestURI());

        Enumeration<String> initParamNames = filterConfig.getServletContext().getInitParameterNames();
        if(initParamNames.hasMoreElements()) {
            System.out.println(">> InfoFilter - have the init parameters:");
            while(initParamNames.hasMoreElements()) {
                System.out.println("\t" + initParamNames.nextElement());
            }
        }

        chain.doFilter(request, response);
    }
}
