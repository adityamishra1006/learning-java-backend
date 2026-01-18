package com.example.L_20_RestTemplate_Feign_demo.client;

import com.example.L_20_RestTemplate_Feign_demo.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductClient {

    @PostMapping("/product")
    ProductDTO createProduct(@RequestBody ProductDTO productDTO, @RequestHeader(required = false) String requestId );

    @GetMapping("/product/list")
    List<ProductDTO> getAllProduct();



}
