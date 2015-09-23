package ru.ferdibiflator.springDemoApplication.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloController extends HttpServlet{
    public static final String PAGE_OK = "/hello.jsp";
    public static final String PAGE_ERROR = "/error.jsp";
    public static final String PARAM_NAME = "name";
    public static final String ATTR_NAME_TO_VIEW = "name";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println(">> HelloController - doGet");

        String name = req.getParameter(PARAM_NAME);
        if(name != null) {
            req.setAttribute(ATTR_NAME_TO_VIEW, name);
            getServletContext().getRequestDispatcher(PAGE_OK).forward(req, res);
        }
        else {
            res.sendRedirect(req.getContextPath() + PAGE_ERROR);
        }
    }
}