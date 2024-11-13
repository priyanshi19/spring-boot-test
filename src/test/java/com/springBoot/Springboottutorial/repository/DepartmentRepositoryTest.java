package com.springBoot.Springboottutorial.repository;

import com.springBoot.Springboottutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp(){
        Department department= Department.builder()
                .departmentCode("IT01")
                .departmentAddress("Pune")
                .departmentName("IT")
                .build();

        testEntityManager.persist(department);
    }

    @Test
    void whenFindById_thenReturnDepartment(){

        Long departmentId=1l;
        Department department=departmentRepository.findById(departmentId).get();
        assertEquals(department.getDepartmentName(),"IT");
    }

}