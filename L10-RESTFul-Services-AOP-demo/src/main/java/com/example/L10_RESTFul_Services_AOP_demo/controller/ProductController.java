package com.example.L10_RESTFul_Services_AOP_demo.controller;


import com.example.L10_RESTFul_Services_AOP_demo.entity.Product;
import com.example.L10_RESTFul_Services_AOP_demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductbyId(@PathVariable Long id){
        Product product = productService.getProductById(id);
        if(product == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product){
        Product newProduct = productService.create(product);
        String location = "/product" + newProduct.getId();
        try {
            return ResponseEntity.created(new URI(location)).build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.update(id, product);
        if (updatedProduct == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id){
        Product deletedProduct = productService.delete(id);
        if(deletedProduct == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deletedProduct);
    }
}
