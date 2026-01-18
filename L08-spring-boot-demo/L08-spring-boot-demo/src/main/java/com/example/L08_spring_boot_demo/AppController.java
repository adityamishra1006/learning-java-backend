package com.example.L08_spring_boot_demo;


import org.example.DefaultKeywordAnalyzer;
import org.example.KeywordAnalyzerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private FlightSearchService flightSearchService;

    @Autowired
    private ProductService productService;

    @Autowired
    private KeywordAnalyzerInterface keywordAnalyzer;

    @GetMapping("/hello")
    public String getHello() {
        return "Hello World from : " + Thread.currentThread().getName();
    }

    @GetMapping("/flightdata")
    public String getFlightData() {
        return flightSearchService.callIndigoAPIForData();
    }


//    @GetMapping("/product")
//    public ResponseEntity<Product> getProduct(@RequestParam String key) {
//        Product product = productService.getProduct(key);
//        return ResponseEntity.ok(product);
//    }

    @GetMapping("/product")
    public Product getProduct(@RequestParam String key) {
        keywordAnalyzer.recordKeyword(key);
        Product product = productService.getProduct(key);
        return product;
    }

    @GetMapping("/allKeywords")
    public List<String> getAllKeywords(){
        return keywordAnalyzer.getKeywords();
    }
}
