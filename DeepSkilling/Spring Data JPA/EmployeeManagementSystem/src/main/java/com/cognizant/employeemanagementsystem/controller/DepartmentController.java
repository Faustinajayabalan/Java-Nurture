package com.cognizant.employeemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cognizant.employeemanagementsystem.model.Department;
import com.cognizant.employeemanagementsystem.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping
    public List<Department> getAllDepartments() {
        return service.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable int id) {
        return service.getDepartment(id);
    }

    @PostMapping
    public Department addDepartment(@RequestBody Department department) {
        return service.addDepartment(department);
    }

    @PutMapping
    public Department updateDepartment(@RequestBody Department department) {
        return service.updateDepartment(department);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable int id) {

        service.deleteDepartment(id);

        return "Department Deleted";

    }

}