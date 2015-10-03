package ru.ferdibiflator.javaeeTraining.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class HelloController extends HttpServlet{
    public static final String PAGE_OK = "/hello.jsp";
    public static final String PAGE_ERROR = "/error.jsp";
    public static final String PARAM_NAME = "name";
    public static final String ATTR_NAME = "name";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println(">> HelloController - doGet");

        String name = req.getParameter(PARAM_NAME);
        HttpSession session = req.getSession();
        if(name != null) {
            session.setAttribute(ATTR_NAME, name);
        }
        else {
            if(session.getAttribute(ATTR_NAME) == null) {
                session.setAttribute(ATTR_NAME, "stranger");
            }
        }
        getServletContext().getRequestDispatcher(PAGE_OK).forward(req, res);
    }
}