package ru.ferdibiflator.javaeeTraining.controller;

import org.apache.catalina.tribes.group.interceptors.TwoPhaseCommitInterceptor;
import ru.ferdibiflator.javaeeTraining.dao.ProductDao;
import ru.ferdibiflator.javaeeTraining.dao.impl.ProductDaoMock;
import ru.ferdibiflator.javaeeTraining.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductListController extends HttpServlet{
    public static final String PAGE_OK = "/productList.jsp";
    public static final String PAGE_ERROR = "/error.jsp";
    public static final String ATTR_PRODUCTS_TO_VIEW = "productList";

    ProductDao productDao = new ProductDaoMock();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(">> ProductListController - doGet");

        List<Product> productList = new LinkedList<>();
        Iterator<Map.Entry<Integer, Product>> productDaoIterator = productDao.iterator();

        while(productDaoIterator.hasNext()) {
            productList.add(productDaoIterator.next().getValue());
        }

        req.setAttribute(ATTR_PRODUCTS_TO_VIEW, productList);
        req.getRequestDispatcher(PAGE_OK).forward(req, resp);
    }
}
