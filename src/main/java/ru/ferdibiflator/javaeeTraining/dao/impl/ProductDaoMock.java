package ru.ferdibiflator.javaeeTraining.dao.impl;

import ru.ferdibiflator.javaeeTraining.dao.ProductDao;
import ru.ferdibiflator.javaeeTraining.dao.exception.DaoSystemException;
import ru.ferdibiflator.javaeeTraining.dao.exception.NoSuchEntityException;
import ru.ferdibiflator.javaeeTraining.entity.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProductDaoMock implements ProductDao{
    private static ProductDaoMock uniqueInstance = new ProductDaoMock();
    private Map<Integer, Product> products = new ConcurrentHashMap<>();

    private ProductDaoMock() {
        Product product = new Product(1, "Bread", 0.9, 32);
        products.put(product.getId(), product);

        product = new Product(2, "Beer", 0.6, 45);
        products.put(product.getId(), product);

        product = new Product(3, "Water", 0.5, 30);
        products.put(product.getId(), product);

        product = new Product(4, "Banana", 1, 27);
        products.put(product.getId(), product);
    }

    public static ProductDaoMock getInstance() {
        return uniqueInstance;
    }

    public Product selectById(int id) throws DaoSystemException, NoSuchEntityException {
        Product product = products.get(id);
        if(product == null) {
            throw new NoSuchEntityException("No product with such id");
        }

        return product;
    }

    public List<Product> selectAll() throws DaoSystemException {
        List<Product> allProducts = new ArrayList<>(products.values());
        return allProducts;
    }
}
