package ru.ferdibiflator.javaeeTraining.dao;

import ru.ferdibiflator.javaeeTraining.dao.exception.*;
import ru.ferdibiflator.javaeeTraining.entity.Product;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public interface ProductDao {
    public Product selectById(int id) throws DaoSystemException, NoSuchEntityException;
    public List<Product> selectAll() throws DaoSystemException;
}
