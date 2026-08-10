package com.cognizant.employeemanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.employeemanagementsystem.model.Department;
import com.cognizant.employeemanagementsystem.repository.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    public Department getDepartment(int id) {
        return repository.findById(id).orElse(null);
    }

    public Department addDepartment(Department department) {
        return repository.save(department);
    }

    public Department updateDepartment(Department department) {
        return repository.save(department);
    }

    public void deleteDepartment(int id) {
        repository.deleteById(id);
    }

}