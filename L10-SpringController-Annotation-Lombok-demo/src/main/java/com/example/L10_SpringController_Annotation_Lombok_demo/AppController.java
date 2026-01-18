package com.example.L10_SpringController_Annotation_Lombok_demo;


//import com.Aditya.ClassService;
import org.example.KeywordAnalyzerInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class AppController {

    private static Logger LOGGER = LoggerFactory.getLogger(AppController.class);


    @Autowired
    private ProductService productService;

//    @Autowired
//    private KeywordAnalyzerInterface keywordAnalyzer;

    @Autowired
    @Qualifier("uniqueKeywordAnalyzer")
//    If we don't have the bean for this interface, it will throw an error
//    So we can do @Required = false to avoid that error
//    @Autowired(required = false)
    private KeywordAnalyzerInterface keywordAnalyzer;

//    @Autowired(required = false)
//    private ClassService classService;

    @GetMapping("/hello")
    public String sayHello(@RequestParam(required = false)String name) {
        LOGGER.info("Hello {} ", name);
        return "Hello " + name + " " + Thread.currentThread().getName();
    }

//    @GetMapping("/session")
//    public String getSessionDetails(){
//        return classService.getSessionDetails();
//    }

    @GetMapping("/products") //Query Param/Request Param
    public List<Product> getAllProducts(){
        LOGGER.info("Processing get all products request");
        return productService.getAll();
    }

    @GetMapping("/product/{id}") //Path Param
    public Product getProductById(@PathVariable Long id){
        return productService.getById(id);
    }

    @PostMapping("/product") //Request Body
    public String addProduct(@RequestBody Product product, @RequestHeader Integer appId) { //Request Header
        LOGGER.info("Calling Product Service: {} ", product);
        return productService.createProduct(product);
    }

    @GetMapping("/search/products" )
    public List<Product> searchProduct(@RequestParam String keyword){
        keywordAnalyzer.recordKeyword(keyword);
        return productService.searchProduct(keyword);
    }

    @GetMapping("/allkeywords")
    public List<String> getAllKeywords(){
        return keywordAnalyzer.getKeywords();
    }


}
