package com.example.L_17_SpringSecurity_demo.service;

import com.example.L_17_SpringSecurity_demo.entity.AppUser;
import com.example.L_17_SpringSecurity_demo.repo.AppUserRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MyAppUserService implements UserDetailsService {

//    Map<String, UserDetails> userStore = new HashMap<>();
//
//    @PostConstruct
//    public void inti(){
//        userStore.put("rahul", User.builder()
//        .username("rahul")
//        .password("$2a$10$oHID8wjC6o15WeQD3oB8keW9KMuOICNm.MaKinkI7XbG6BC15/wmu") //rahul123
//        .roles("USER")
//        .build());
//
//        userStore.put("ayush", User.builder()
//                .username("ayush")
//                .password("$2a$10$NDPbFBsuu8pLxALJZeJiS.nToS8SkEcQjcAk1gny0H9tGQBb5wfje")
//                .roles("USER")
//                .build());
//    }

    @Autowired
    private AppUserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String createUser(AppUser appUser){
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        userRepo.save(appUser);
        return "User created successfully";
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepo.findByEmail(username);
        if(appUser == null){
            throw new UsernameNotFoundException("User not found");
        }
        return appUser;
    }

    public boolean changePassword(AppUser appUser, String newPassword) {
        appUser.setPassword(passwordEncoder.encode(newPassword));
        appUser = userRepo.save(appUser);
        return true;
    }
}
