package com.example.L08_spring_boot_demo;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {
    private Map<String, Product> dataStore;

    @PostConstruct
    void init(){
        dataStore = new HashMap<>();
        dataStore.put("laptop", new Product("Laptop", 50000.0));
        dataStore.put("mobile", new Product("Mobile", 20000.0));
        dataStore.put("tablet", new Product("Tablet", 30000.0));
    }

    public Product getProduct(String key){
        return dataStore.get(key);
    }
}
