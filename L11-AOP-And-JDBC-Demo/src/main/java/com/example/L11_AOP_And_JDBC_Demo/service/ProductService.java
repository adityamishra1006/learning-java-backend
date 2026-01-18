package com.example.L11_AOP_And_JDBC_Demo.service;


import com.example.L11_AOP_And_JDBC_Demo.aspect.LogExecutionTime;
import com.example.L11_AOP_And_JDBC_Demo.dao.ProductDAO;
import com.example.L11_AOP_And_JDBC_Demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductDAO productDAO;


    @LogExecutionTime
    public Product getById(Long id){
        // Log start time of this method productService.getById, here it will log everywhere this method is called.
        return productDAO.getProductById(id);
    }


    @LogExecutionTime
    public Product create(Product product){
        return productDAO.create(product);
    }

    public Product update(Long id, Product product){
        return productDAO.update(id, product);
    }

    public Product delete(Long id){
        return productDAO.delete(id);
    }
}
