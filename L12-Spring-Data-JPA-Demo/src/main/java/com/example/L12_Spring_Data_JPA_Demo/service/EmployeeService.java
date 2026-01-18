package com.example.L12_Spring_Data_JPA_Demo.service;


import com.example.L12_Spring_Data_JPA_Demo.dao.BranchRepo;
import com.example.L12_Spring_Data_JPA_Demo.dao.EmployeeRepo;
import com.example.L12_Spring_Data_JPA_Demo.dto.EmployeeDetailReqDto;
import com.example.L12_Spring_Data_JPA_Demo.entity.Address;
import com.example.L12_Spring_Data_JPA_Demo.entity.Branch;
import com.example.L12_Spring_Data_JPA_Demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Long create(EmployeeDetailReqDto employeeDetailReq){

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
        return employee.getId();

    }

    public Employee getEmployeeByEmail(String email){
        return employeeRepo.findByEmail(email);
    }

    public Employee getEmployeeByName(String name){
        List<Employee> employees = employeeRepo.findByName(name);
        if(employees != null && employees.size() > 0){
            return employees.get(0);
        }
        return null;
    }

    public Employee getById(Long id){
        return employeeRepo.findById(id).get();
    }
}
