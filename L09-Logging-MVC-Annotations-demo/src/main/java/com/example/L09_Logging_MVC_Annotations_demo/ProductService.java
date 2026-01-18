package com.example.L09_Logging_MVC_Annotations_demo;


import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private static Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    private List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init(){
        products.add(new Product(1L, "Laptop"));
        products.add(new Product(2L, "Mobile"));
        products.add(new Product(3L, "TV"));
        products.add(new Product(4L, "Tablet"));
        products.add(new Product(5L, "Headphones"));
        products.add(new Product(6L, "Watch"));
    }

    public String createProduct(Product product){
        LOGGER.info("Creating Product: {} ", product);
        if(product.getName() == null){
            LOGGER.error("Product name is null, cannot create product");
            return "Product name cannot be null";
        }
        products.add(product);
        return "Product created successfully";
    }

    public List<Product> getAll(){
        LOGGER.info("Getting all Products");
        return products;
    }

    public Product getById(Long id){
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }



}
