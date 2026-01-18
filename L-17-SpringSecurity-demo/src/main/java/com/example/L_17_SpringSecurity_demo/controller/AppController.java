package com.example.L_17_SpringSecurity_demo.controller;

import com.example.L_17_SpringSecurity_demo.entity.AppUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @GetMapping("/hello")
    String getHello(@AuthenticationPrincipal AppUser appUser){
        //AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Hello "+appUser.getName()+" From: " + Thread.currentThread().getName();
    }

}
