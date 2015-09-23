package ru.ferdibiflator.springDemoApplication.dao.impl;

import ru.ferdibiflator.springDemoApplication.dao.ProductDao;
import ru.ferdibiflator.springDemoApplication.dao.exception.DaoSystemException;
import ru.ferdibiflator.springDemoApplication.dao.exception.NoSuchEntityException;
import ru.ferdibiflator.springDemoApplication.entity.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProductDaoMock implements ProductDao{
    Map<Integer, Product> products = new ConcurrentHashMap<>();

    public ProductDaoMock() {
        Product product = new Product(1, "Bread", 0.9, 32);
        products.put(product.getId(), product);

        product = new Product(2, "Beer", 0.6, 45);
        products.put(product.getId(), product);

        product = new Product(3, "Water", 0.5, 30);
        products.put(product.getId(), product);

        product = new Product(4, "Banana", 1, 27);
        products.put(product.getId(), product);
    }

    public Product selectById(int id) throws DaoSystemException, NoSuchEntityException {
        Product product = products.get(id);
        if(product == null) {
            throw new NoSuchEntityException("No product with such id");
        }

        return product;
    }

    public List<Product> selectAll() throws DaoSystemException {
        return null;
    }
}
