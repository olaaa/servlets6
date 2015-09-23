package ru.ferdibiflator.springDemoApplication.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class HelloController extends HttpServlet{
    public static final String PAGE_OK = "/hello.jsp";
    public static final String PAGE_ERROR = "/error.jsp";
    public static final String PARAM_NAME = "name";
    public static final String ATTR_NAME_TO_VIEW = "name";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(">> HelloController - doGet");

        String name = request.getParameter(PARAM_NAME);
        if(name != null) {
            request.setAttribute(ATTR_NAME_TO_VIEW, name);
            getServletContext().getRequestDispatcher(PAGE_OK).forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + PAGE_ERROR);
        }
    }
}
