package com.example.L16_UnitTesting_Demo.integration;

import com.example.L16_UnitTesting_Demo.dao.BranchRepo;
import com.example.L16_UnitTesting_Demo.dao.EmployeeRepo;
import com.example.L16_UnitTesting_Demo.dto.EmployeeDetailReqDto;
import com.example.L16_UnitTesting_Demo.entity.Branch;
import com.example.L16_UnitTesting_Demo.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@TestPropertySource(
        locations = ("classpath:application-it.properties")
)
public class EmployeeAPITest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BranchRepo branchRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    private EmployeeDetailReqDto employeeDetailReq1;

    private EmployeeDetailReqDto employeeDetailReq2;


    private Branch branch;


    @BeforeEach
    public void setup(){
        branch = Branch.builder()
                .name("Noida Branch")
                .build();
        branch = branchRepo.save(branch);
        employeeDetailReq1 = EmployeeDetailReqDto.builder()
                .email("adityakumar@gmail.com")
                .name("Aditya")
                .line1("005")
                .line2("Sector-34")
                .city("Noida")
                .branchId(branch.getId())
                .build();


        employeeDetailReq2 = EmployeeDetailReqDto.builder()
                .email("rahul@yopmail.com")
                .line1("A-43")
                .line2("Sector-87")
                .city("Noida")
                .branchId(branch.getId())
                .build();

    }


    @Test
    public void testCreateEmpAPI() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = objectMapper.writeValueAsString(employeeDetailReq1);

        mockMvc.perform(post("/emp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonData))
                .andDo(print()).andExpect(status().isOk());

        Employee employeeFromDB = employeeRepo.findByEmail("adityakumar@gmail.com");
        assertThat(employeeFromDB).isNotNull();
    }

    @Test
    public void testCreateEmpAPIWithoutName() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = objectMapper.writeValueAsString(employeeDetailReq2);

        mockMvc.perform(post("/emp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonData))
                .andDo(print()).andExpect(status().isBadRequest());

        Employee employeeFromDB = employeeRepo.findByEmail("rahul@yopmail.com");
        assertThat(employeeFromDB).isNull();
    }


}