package com.example.L16_UnitTesting_Demo.repo;


import com.example.L16_UnitTesting_Demo.dao.BranchRepo;
import com.example.L16_UnitTesting_Demo.dao.EmployeeRepo;
import com.example.L16_UnitTesting_Demo.entity.Address;
import com.example.L16_UnitTesting_Demo.entity.Branch;
import com.example.L16_UnitTesting_Demo.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest(
    properties = {
            "spring.datasource.url=jdbc:h2:mem:testdb",
            "spring.jpa.hibernate.ddl-auto=create-drop"
    })
public class EmployeeRepoTest {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private BranchRepo branchRepo;

    private Employee employee;

    @BeforeEach
    public void setup(){

        Address address = Address.builder()
//                .id(1l)
                .line1("A-43")
                .line2("Sector-87")
                .city("Noida")
                .build();

        Branch branch = Branch.builder()
//                .id(1l)
                .name("Noida Branch")
                .build();
        branchRepo.save(branch);

        employee = Employee.builder()
                .email("adityakumar@gmail.com")
                .name("Aditya")
                .address(address)
                .branch(branch)
//                .id(11l)
                .build();

        employee = employeeRepo.save(employee);
    }

    @Test
    public void testFindByEmail(){
        Employee employeeReturned = employeeRepo.findByEmail("adityakumar@gmail.com");
        assertThat(employeeReturned).isEqualTo(employee);
    }

//    @Test
//    public void testFindByName(){
//        Employee employeeReturned = employeeRepo.findByEmail("Aditya");
//        assertThat(employeeReturned).isEqualTo(employee);
//    }

}
