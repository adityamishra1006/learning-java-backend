package com.example.L_17_SpringDataRedis_demo.service;

import com.example.L_17_SpringDataRedis_demo.entity.Product;
import com.example.L_17_SpringDataRedis_demo.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired(required = true)
    private RedisTemplate<String, Product> redisTemplate;

    public Product getById(Long id){
//        Product product  = productRepo.findById(id).get();
//        redisTemplate.opsForValue().set(key, product, 5, TimeUnit.MINUTES);
        String key = "product:"+id;
        Product product = redisTemplate.opsForValue().get(key);
        if(product == null){
            product  = productRepo.findById(id).get();
            if(product != null){
                redisTemplate.opsForValue().set(key, product, 5, TimeUnit.MINUTES);
            }
        }

        return product;
    }

    public Long createProduct(Product product){
        product = productRepo.save(product);
        return product.getId();
    }
}
