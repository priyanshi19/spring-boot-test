package com.springBoot.Springboottutorial.service;

import com.springBoot.Springboottutorial.entity.Department;
import com.springBoot.Springboottutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchAllDepartment();

    Department fetchAllDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);
}
