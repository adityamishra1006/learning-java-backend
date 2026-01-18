package com.example.L_17_SpringSecurity_demo.controller;


import com.example.L_17_SpringSecurity_demo.entity.AppUser;
import com.example.L_17_SpringSecurity_demo.service.MyAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MyAppUserService myAppUserService;

    @GetMapping("/hello")
    String getHello(@AuthenticationPrincipal AppUser appUser){
       return "Hello ADMIN "+appUser.getName()+" From: " + Thread.currentThread().getName();
    }

    @PostMapping("/createUser")
    String createUser(@RequestBody AppUser appUser){
        return myAppUserService.createUser(appUser);
    }

    @PostMapping("/changePassword")
    public ResponseEntity<String> changePassword(@AuthenticationPrincipal AppUser appUser, @RequestParam String newPassword){
        myAppUserService.changePassword(appUser, newPassword);
        return ResponseEntity.ok("Password changed successfully");
    }
}
