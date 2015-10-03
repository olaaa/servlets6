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

public class ProductRemoveFromBucketController extends HttpServlet {
    public static final String PARAM_ID = "id";
    public static final String PAGE_ERROR = "/error.jsp";
    public static final String ATTR_BUCKET_FOR_SESSION = "bucket";

    private ProductDao productDao = ProductDaoMock.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(">> ProductRemoveFromBucketController - doGet");

        try {
            int removeProductId = Integer.parseInt(req.getParameter(PARAM_ID));
            HttpSession session = req.getSession();
            Map<Product, Integer> oldBucket = (Map<Product, Integer>) session.getAttribute(ATTR_BUCKET_FOR_SESSION);

            if(oldBucket != null) {
                Product removeProduct = productDao.selectById(removeProductId);

                if(oldBucket.get(removeProduct) != null) { // if remove product is in the bucket
                    Map<Product, Integer> newBucket = new LinkedHashMap<>(oldBucket);

                    int countNow = newBucket.get(removeProduct);
                    if(countNow <= 1) {
                        newBucket.remove(removeProduct);
                    }
                    else {
                        newBucket.put(removeProduct, countNow - 1);
                    }

                    session.setAttribute(ATTR_BUCKET_FOR_SESSION, Collections.unmodifiableMap(newBucket));

                    //resp.getWriter().print(Integer.toString(newBucket.get(removeProduct)));
                    return;
                }
            }
        } catch (NumberFormatException | NoSuchEntityException | DaoSystemException e) {

        }

        resp.sendRedirect(req.getContextPath() + PAGE_ERROR);
    }
}
