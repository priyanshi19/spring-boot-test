package com.springBoot.Springboottutorial.service;

import com.springBoot.Springboottutorial.entity.Department;
import com.springBoot.Springboottutorial.error.DepartmentNotFoundException;
import com.springBoot.Springboottutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements  DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchAllDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department=departmentRepository.findById(departmentId);
        if(!department.isPresent())
            throw new DepartmentNotFoundException("Department Not Available");
        else
            return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department newDep) {
        Department oldDep=departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(newDep.getDepartmentAddress())&& !newDep.getDepartmentAddress().equalsIgnoreCase("")) {
            oldDep.setDepartmentAddress(newDep.getDepartmentAddress());
        }
        if(Objects.nonNull(newDep.getDepartmentCode())&& !newDep.getDepartmentCode().equalsIgnoreCase("")) {
            oldDep.setDepartmentCode(newDep.getDepartmentCode());
        }
        if(Objects.nonNull(newDep.getDepartmentName())&& !newDep.getDepartmentName().equalsIgnoreCase("")) {
            oldDep.setDepartmentName(newDep.getDepartmentName());
        }
        return departmentRepository.save(oldDep);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }


}
