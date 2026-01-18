package com.example.L_20_RestTemplate_Feign_demo;

import com.example.L_20_RestTemplate_Feign_demo.client.ProductClient;
import com.example.L_20_RestTemplate_Feign_demo.dto.ProductDTO;
import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/product-proxy")
public class ProductControllerProxy {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    private static Logger LOGGER = LoggerFactory.getLogger(ProductControllerProxy.class);


//    @PostMapping
//    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO product, @RequestHeader(required = false) String requestId){
//        LOGGER.info("Processing createProduct Req: {}",product);
//        String url = "http://localhost:8080/product";
//        String reqId = MDC.get("requestId");
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("requestId", reqId);
//        HttpEntity<ProductDTO> request = new HttpEntity<>(product, headers);
//        ProductDTO response = restTemplate.postForObject(url, request, ProductDTO.class);
//        LOGGER.info("Created Product");
//        return ResponseEntity.ok(response);
//    }

//    @PostMapping
//    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO product, @RequestHeader(required = false) String requestId){
//        LOGGER.info("Processing createProduct Req: {}",product);
//        String url = "http://localhost:8080/product";
//        String reqId = MDC.get("requestId");
//
//        ProductDTO response = productClient.createProduct(product, reqId);
//        LOGGER.info("Created Product");
//        return ResponseEntity.ok(response);
//    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO product, @RequestHeader(required = false) String requestId){
        LOGGER.info("Processing createProduct Req: {}",product);
        String url = "http://localhost:8080/product";
        String reqId = MDC.get("requestId");
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("requestId",reqId);
//        HttpEntity<ProductDto> entity = new HttpEntity(product,headers);
//        ProductDto response = restTemplate.postForObject(url,entity, ProductDto.class);

        ProductDTO response = productClient.createProduct(product,reqId);
        LOGGER.info("Created Product");
        return ResponseEntity.ok(response);
    }
}
