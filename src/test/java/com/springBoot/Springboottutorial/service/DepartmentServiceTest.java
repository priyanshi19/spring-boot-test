package com.springBoot.Springboottutorial.service;

import com.springBoot.Springboottutorial.entity.Department;
import com.springBoot.Springboottutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    DepartmentService departmentService;

    @MockBean
    DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department= Department.builder()
                .departmentCode("IT01")
                .departmentId(1L)
                .departmentAddress("Pune")
                .departmentName("IT")
                .build();

        Mockito.when(departmentRepository.findByDepartmentName("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("Get Department By Valid Name")
    void whenValidDepartmentName_then_DepartmentShouldBeFound(){
        String departmentName="IT";
        Department dep=departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName,dep.getDepartmentName());
    }
}