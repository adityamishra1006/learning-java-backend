package com.example.L_17_SpringDataRedis_demo.repo;

import com.example.L_17_SpringDataRedis_demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

}
