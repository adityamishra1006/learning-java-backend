package com.example.L16_UnitTesting_Demo.service;

import com.example.L16_UnitTesting_Demo.dao.BranchRepo;
import com.example.L16_UnitTesting_Demo.dao.EmployeeRepo;
import com.example.L16_UnitTesting_Demo.dto.EmployeeDetailReqDto;
import com.example.L16_UnitTesting_Demo.entity.Address;
import com.example.L16_UnitTesting_Demo.entity.Branch;
import com.example.L16_UnitTesting_Demo.entity.Employee;
import com.example.L16_UnitTesting_Demo.exceptions.AdhaarNotVerifiedException;
import com.example.L16_UnitTesting_Demo.exceptions.LaptopAllocationFailedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {

    private EmployeeService employeeService;

    @Mock
    private BranchRepo branchRepo;
    @Mock
    private EmployeeRepo employeeRepo;

    private EmployeeDetailReqDto employeeDetailReq;

    private Employee employee;

    private Branch branch;

    private AutoCloseable autoCloseable;


    @BeforeEach
    public void setup(){

        autoCloseable = MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeService(employeeRepo, branchRepo);

        Address address = Address.builder()
                .id(1l)
                .line1("A-43")
                .line2("Sector-87")
                .city("Noida")
                .build();

        branch = Branch.builder()
                .id(1l)
                .name("Noida Branch")
                .build();

        employee = Employee.builder()
                .email("adityakumar@gmail.com")
                .name("Aditya")
                .address(address)
                .branch(branch)
                .id(11l)
                .build();

        employeeDetailReq = EmployeeDetailReqDto.builder()
                .email("adityakumar@gmail.com")
                .name("Aditya")
                .line1("A-43")
                .line2("Sector-87")
                .city("Noida")
                .branchId(1l)
                .build();
    }

    @Test
    public void createEmployeeTest() throws AdhaarNotVerifiedException, LaptopAllocationFailedException {
        when(employeeRepo.save(any())).thenReturn(employee);
        when(branchRepo.findById(1l)).thenReturn(Optional.of(branch));

        Long id = employeeService.create(employeeDetailReq);
        assertThat(id).isEqualTo(11);
    }

    @Test
    public void findByEmail(){
        when(employeeRepo.findByEmail("adityakumar@gmail.com")).thenReturn(employee);
        Employee actualEmployee = employeeService.getEmployeeByEmail("adityakumar@gmail.com");


        assertThat(actualEmployee.getName()).isEqualTo(employee.getName());
//        assertThat(actualEmployee.getName()).isEqualTo("abc");
    }

//    @Test
//    void findByEmail_shouldFailWhenEmailsDifferent() {
//        Employee employee = new Employee();
//        employee.setName("Aditya");
//        employee.setEmail("adityakumar@gmail.com");
//        when(employeeRepo.findByEmail("adityakumar@gmail.com")).thenReturn(employee);
//        Employee actualEmployee = employeeService.getEmployeeByEmail("other@gmail.com");
//        assertThat(actualEmployee).isNotNull();
//        assertThat(actualEmployee.getEmail()).isEqualTo(employee.getEmail());
//    }

//    55:46

}
