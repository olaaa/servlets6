package ru.ferdibiflator.javaeeTraining.controller;

import ru.ferdibiflator.javaeeTraining.dao.ProductDao;
import ru.ferdibiflator.javaeeTraining.dao.exception.DaoSystemException;
import ru.ferdibiflator.javaeeTraining.dao.exception.NoSuchEntityException;
import ru.ferdibiflator.javaeeTraining.dao.impl.ProductDaoMock;
import ru.ferdibiflator.javaeeTraining.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductController extends HttpServlet{
    public static final String PARAM_ID = "id";
    public static final String PAGE_OK = "/product.jsp";
    public static final String PAGE_ERROR = "/error.jsp";
    public static final String ATTR_PRODUCT_TO_VIEW = "product";

    ProductDao productDao = ProductDaoMock.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println(">> ProductController - doGet");

        try {
            int id = Integer.parseInt(req.getParameter(PARAM_ID));
            Product product = productDao.selectById(id);

            req.setAttribute(ATTR_PRODUCT_TO_VIEW, product);
            req.getRequestDispatcher(PAGE_OK).forward(req, res);
            return;
        }
        catch(NumberFormatException | NoSuchEntityException | DaoSystemException e) {
            res.sendRedirect(req.getContextPath() + PAGE_ERROR);
        }
    }
}
