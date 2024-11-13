package com.springBoot.Springboottutorial.controller;

import com.springBoot.Springboottutorial.entity.Department;
import com.springBoot.Springboottutorial.error.DepartmentNotFoundException;
import com.springBoot.Springboottutorial.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final  Logger logger= LoggerFactory.getLogger(DepartmentController.class);


    @PostMapping("/department")
    public Department saveDepartment(@Valid @RequestBody Department department){
        logger.info("Inside the save department");
       return departmentService.saveDepartment(department);

    }

    @GetMapping("/department")
    public List<Department> fetchDepartmentList(){
        logger.info("Inside the fetch Department");
        return departmentService.fetchAllDepartment();
    }

    @GetMapping("/department/fetch/{id}")
    public Department fetchDepartmentListById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchAllDepartmentById(departmentId);
    }

    @GetMapping("/department/delete/{id}")
    public String deleteDepartmentById(@PathVariable("id")Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department Deleted successfully!!!!";
    }

    @PutMapping("/department/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/department/name/{departmentName}")
    public Department fetchDepartmentByName(@PathVariable("departmentName") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }


}
