package com.example.L_17_SpringSecurity_demo.repo;

import com.example.L_17_SpringSecurity_demo.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser,Long> {
    public AppUser findByEmail(String username);
}
