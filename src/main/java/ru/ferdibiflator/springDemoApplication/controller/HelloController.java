package ru.ferdibiflator.springDemoApplication.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(">> HelloController - doGet");
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
