package com.example.L10_RESTFul_Services_AOP_demo.dao;

import com.example.L10_RESTFul_Services_AOP_demo.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductDAO {
    private Map<Long, Product> dataStore = new HashMap<>();
    private AtomicLong nextId = new AtomicLong(1L);

    public Product getProductById(Long id){
        return dataStore.get(id);
    }

    public Product create(Product product){
        product.setId(nextId.getAndIncrement());
        dataStore.put(product.getId(), product);
        return product;
    }

    public Product update(Long id, Product product){
        Product existingProduct = dataStore.get(id);
        if(existingProduct == null){
            return null;
        } else {
            existingProduct.setName(product.getName());
            existingProduct.setCost(product.getCost());
            dataStore.put(id, existingProduct);
            return existingProduct;
        }
    }

    public Product delete(Long id){
        Product existingProduct = dataStore.get(id);
        if(existingProduct == null){
            return null;
        } else {
            dataStore.remove(id);
            return existingProduct;
        }
    }
}
