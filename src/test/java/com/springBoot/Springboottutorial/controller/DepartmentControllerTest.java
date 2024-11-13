package com.springBoot.Springboottutorial.controller;

import com.springBoot.Springboottutorial.entity.Department;
import com.springBoot.Springboottutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp(){
         department= Department.builder()
                .departmentCode("IT01")
                .departmentAddress("Pune")
                .departmentName("IT")
                 .departmentId(1l)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        mockMvc.perform(post("/department")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n"+
                                "\t\"departmentName\":\"IT\",\n"+
                                "\t\"departmentAddress\":\"Pune\",\n"+
                                "\t\"departmentCode\":\"ITO1\" \n"+
                                "}"))
                .andExpect(status().isOk());
        
        Department inputDepartment= Department.builder()
                .departmentCode("IT01")
                .departmentAddress("Pune")
                .departmentName("IT")
                .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

    }

    @Test
    void fetchDepartmentList() throws Exception {
        mockMvc.perform(get("/department")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        List<Department> list=new ArrayList<>();
        list.add(department);
        Mockito.when(departmentService.fetchAllDepartment()).thenReturn(list);

    }

    @Test
    void fetchDepartmentListById() {
    }
}