package com.example.L13_JPA_Transaction_EntityManager_Demo.controller;


import com.example.L13_JPA_Transaction_EntityManager_Demo.dto.EmployeeDetailReqDto;
import com.example.L13_JPA_Transaction_EntityManager_Demo.entity.Employee;
import com.example.L13_JPA_Transaction_EntityManager_Demo.exceptions.AdhaarNotVerifiedException;
import com.example.L13_JPA_Transaction_EntityManager_Demo.exceptions.LaptopAllocationFailedException;
import com.example.L13_JPA_Transaction_EntityManager_Demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAllEmployees(){
        List<Employee> employees = employeeService.getAll();
        return employees;
    }

    @GetMapping("/email")
    public ResponseEntity<Employee> getEmployeeByEmail(@RequestParam String email){
        Employee employee = employeeService.getEmployeeByEmail(email);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id){
        Employee employee = employeeService.getById(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<Long> createEmp(@RequestBody EmployeeDetailReqDto employeeDetailReq) throws AdhaarNotVerifiedException, LaptopAllocationFailedException {
        Long id = employeeService.create(employeeDetailReq);
        return ResponseEntity.ok(id);
    }

}
