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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProductAddToBucketController extends HttpServlet {
    public static final String PAGE_ERROR = "/error.jsp";
    public static final String PARAM_ID = "id";
    public static final String ATTR_BUCKET_FOR_SESSION = "bucket";

    ProductDao productDao = ProductDaoMock.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(">> ProductAddToBucketController - doGet");

        try {
            int addProductId = Integer.parseInt(req.getParameter(PARAM_ID));
            Product addProduct = productDao.selectById(addProductId);
            HttpSession session = req.getSession(true); // true - is create new session if it's not
            Map<Product, Integer> oldBucket = (Map<Product, Integer>) session.getAttribute(ATTR_BUCKET_FOR_SESSION);

            if (oldBucket == null) { // Bucket is empty
                session.setAttribute(ATTR_BUCKET_FOR_SESSION, Collections.singletonMap(addProduct, 1));
            } else {// Bucket is not empty
                Map<Product, Integer> newBucket = new LinkedHashMap<>(oldBucket);

                if (newBucket.containsKey(addProduct)) { // Some product is already in the bucket
                    newBucket.put(addProduct, newBucket.get(addProduct) + 1);
                } else { // There is no some product in bucket
                    newBucket.put(addProduct, 1);
                }

                session.setAttribute(ATTR_BUCKET_FOR_SESSION, Collections.unmodifiableMap(newBucket));
            }

            resp.sendRedirect(req.getContextPath() + "/product.do?id=" + addProductId);
            return;
        } catch (NumberFormatException | NoSuchEntityException | DaoSystemException e) {

        }

        resp.sendRedirect(req.getContextPath() + PAGE_ERROR);
    }
}
