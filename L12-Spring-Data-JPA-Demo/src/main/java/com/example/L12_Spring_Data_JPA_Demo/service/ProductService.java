package com.example.L12_Spring_Data_JPA_Demo.service;



import com.example.L12_Spring_Data_JPA_Demo.dao.ProductRepo;
import com.example.L12_Spring_Data_JPA_Demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product getById(Long id){
        // Log start time of this method productService.getById, here it will log everywhere this method is called.
        return productRepo.findById(id).get();
    }

    public Product create(Product product){
        product = productRepo.save(product);
        return product;
    }

    public Product update(Long id, Product product){
        Product existingProduct = productRepo.findById(id).get();
        if(existingProduct !=null){
            existingProduct.setName(product.getName());
            existingProduct.setCost(product.getCost());
            productRepo.save(existingProduct);
        }
        return existingProduct;
    }

    public Product delete(Long id){
        Product existingProduct = productRepo.findById(id).get();
        if(existingProduct != null){
            productRepo.delete(existingProduct);
        }
        return existingProduct;
    }
}
