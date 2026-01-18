package com.example.L16_UnitTesting_Demo.dao;

import com.example.L16_UnitTesting_Demo.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepo extends JpaRepository<Branch, Long> {

}
