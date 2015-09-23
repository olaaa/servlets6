package ru.ferdibiflator.springDemoApplication.dao;

import ru.ferdibiflator.springDemoApplication.dao.exception.*;
import ru.ferdibiflator.springDemoApplication.entity.Product;

import java.util.List;

public interface ProductDao {
    public Product selectById(int id) throws DaoSystemException, NoSuchEntityException;
    public List<Product> selectAll() throws DaoSystemException;
}
