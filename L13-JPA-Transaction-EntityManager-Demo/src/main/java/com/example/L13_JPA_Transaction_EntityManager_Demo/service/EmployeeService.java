package com.example.L13_JPA_Transaction_EntityManager_Demo.service;


import com.example.L13_JPA_Transaction_EntityManager_Demo.dao.BranchRepo;
import com.example.L13_JPA_Transaction_EntityManager_Demo.dao.EmployeeRepo;
import com.example.L13_JPA_Transaction_EntityManager_Demo.dto.EmployeeDetailReqDto;
import com.example.L13_JPA_Transaction_EntityManager_Demo.entity.Address;
import com.example.L13_JPA_Transaction_EntityManager_Demo.entity.Branch;
import com.example.L13_JPA_Transaction_EntityManager_Demo.entity.Employee;
import com.example.L13_JPA_Transaction_EntityManager_Demo.exceptions.AdhaarNotVerifiedException;
import com.example.L13_JPA_Transaction_EntityManager_Demo.exceptions.LaptopAllocationFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private Branch branch;
    @Autowired
    private BranchRepo branchRepo;

    public List<Employee> getAll(){
        return employeeRepo.findAll();
    }


    @Transactional(rollbackFor = AdhaarNotVerifiedException.class)
    public Long create(EmployeeDetailReqDto employeeDetailReq) throws AdhaarNotVerifiedException, LaptopAllocationFailedException {

        boolean isAdhaarVerified = true;
        // Aadhar API Call
        boolean isLaptopAllocated = true;
        // Asset Management API call to Asset Management System

        Employee employee = new Employee();
        employee.setName(employeeDetailReq.getName());
        employee.setEmail(employeeDetailReq.getEmail());

        Branch branch = branchRepo.findById(employeeDetailReq.getBranchId()).get();
        employee.setBranch(branch);

        Address address = new Address();
        address.setLine1(employeeDetailReq.getLine1());
        address.setLine2(employeeDetailReq.getLine2());
        address.setCity(employeeDetailReq.getCity());

        employee.setAddress(address);

        employeeRepo.save(employee);

        if(!isAdhaarVerified){
            throw new AdhaarNotVerifiedException("Adhaar Not Verified");
        }
        if(!isLaptopAllocated){
            throw new LaptopAllocationFailedException("Laptop Not Allocated");
        }

        return employee.getId();

    }

    public Employee getEmployeeByEmail(String email){
        return employeeRepo.findByEmail(email);
    }

//    public Employee getEmployeeByName(String name){
//        List<Employee> employees = employeeRepo.findByName(name);
//        if(employees != null && employees.size() > 0){
//            return employees.get(0);
//        }
//        return null;
//    }

    public Employee getById(Long id){
        return employeeRepo.findById(id).get();
    }
}
