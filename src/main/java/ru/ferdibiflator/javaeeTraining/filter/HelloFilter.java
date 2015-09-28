package ru.ferdibiflator.javaeeTraining.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloFilter extends BaseFilter {
    public HelloFilter() {
        System.out.println(">> HelloFilter - new");
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(">> HelloFilter - Query string for HelloController: " + request.getQueryString());
        chain.doFilter(request, response);
    }
}
