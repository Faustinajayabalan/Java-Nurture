package com.cognizant.employeemanagementsystem.controller;

import java.util.List;
import org.springframework.data.domain.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cognizant.employeemanagementsystem.model.Employee;
import com.cognizant.employeemanagementsystem.service.EmployeeService;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return service.getEmployee(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {
        return service.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {

        service.deleteEmployee(id);

        return "Employee Deleted";

    }
    
    @GetMapping("/search/name/{name}")
    public List<Employee> searchByName(
    @PathVariable String name){

        return service.searchByName(name);

    }
    
    @GetMapping("/search/email/{email}")
    public Employee searchByEmail(
    @PathVariable String email){

        return service.searchByEmail(email);

    }
    
    @GetMapping("/namedquery/{name}")
    public List<Employee> namedQuery(
    @PathVariable String name){

        return service.getEmployeeByName(name);

    }
    
    @GetMapping("/page/{page}/{size}")
    public Page<Employee> getEmployeesByPage(

            @PathVariable int page,

            @PathVariable int size) {

        return service.getEmployeesByPage(page, size);

    }
    
    @GetMapping("/sort")

    public List<Employee> getEmployeesSorted() {

        return service.getEmployeesSortedByName();

    }
    
    @GetMapping("/sortdesc")

    public List<Employee> getEmployeesSortedDesc() {

        return service.getEmployeesSortedByNameDesc();

    }
    
    @GetMapping("/pageSort/{page}/{size}")

    public Page<Employee> getEmployeesPageSorted(

            @PathVariable int page,

            @PathVariable int size) {

        return service.getEmployeesByPageSorted(page, size);

    }
    

}