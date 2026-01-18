package com.example.L07_Spring_Boot_Demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
public class AppController {

    @GetMapping("/hello")
    public String hello(@RequestParam String name){
        return "Hello " + name +" from Spring Boot Thread! : " + Thread.currentThread().getName();
    }
}
