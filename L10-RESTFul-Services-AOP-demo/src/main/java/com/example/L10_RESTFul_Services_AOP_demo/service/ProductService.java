package com.example.L10_RESTFul_Services_AOP_demo.service;


import com.example.L10_RESTFul_Services_AOP_demo.dao.ProductDAO;
import com.example.L10_RESTFul_Services_AOP_demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductDAO productDAO;

    public Product getProductById(Long id){
        return productDAO.getProductById(id);
    }

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
