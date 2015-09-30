package ru.ferdibiflator.javaeeTraining.controller;

import ru.ferdibiflator.javaeeTraining.dao.ProductDao;
import ru.ferdibiflator.javaeeTraining.dao.exception.DaoSystemException;
import ru.ferdibiflator.javaeeTraining.dao.impl.ProductDaoMock;
import ru.ferdibiflator.javaeeTraining.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductListController extends HttpServlet{
    public static final String PAGE_OK = "/productList.jsp";
    public static final String PAGE_ERROR = "/error.jsp";
    public static final String ATTR_PRODUCTS_TO_VIEW = "productList";

    ProductDao productDao = ProductDaoMock.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(">> ProductListController - doGet");

        try {
            List<Product> productList = productDao.selectAll();

            req.setAttribute(ATTR_PRODUCTS_TO_VIEW, productList);
            req.getRequestDispatcher(PAGE_OK).forward(req, resp);
            return;
        }
        catch(DaoSystemException ignore) {

        }

        resp.sendRedirect(PAGE_ERROR);
    }
}
