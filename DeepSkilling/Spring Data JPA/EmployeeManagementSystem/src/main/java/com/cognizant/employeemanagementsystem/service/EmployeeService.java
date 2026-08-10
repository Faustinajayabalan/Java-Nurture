package com.cognizant.employeemanagementsystem.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.employeemanagementsystem.model.Employee;
import com.cognizant.employeemanagementsystem.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployee(int id) {
        return repository.findById(id).orElse(null);
    }

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return repository.save(employee);
    }

    public void deleteEmployee(int id) {
        repository.deleteById(id);
    }
    
    public List<Employee> searchByName(String name){

        return repository.findByNameContainingIgnoreCase(name);

    }

    public Employee searchByEmail(String email){

        return repository.getEmployeeByEmail(email);

    }

    public List<Employee> getEmployeeByName(String name){

        return repository.getEmployeeByName(name);

    }
    
 // Get employees page by page
    public Page<Employee> getEmployeesByPage(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return repository.findAll(pageable);

    }

    // Get employees sorted by name
    public List<Employee> getEmployeesSortedByName() {

        return repository.findAll(Sort.by("name"));

    }

    // Get employees sorted by name descending
    public List<Employee> getEmployeesSortedByNameDesc() {

        return repository.findAll(Sort.by(Sort.Direction.DESC, "name"));

    }

    // Pagination + Sorting
    public Page<Employee> getEmployeesByPageSorted(int page, int size) {

        Pageable pageable =
                PageRequest.of(page, size, Sort.by("name"));

        return repository.findAll(pageable);

    }
    
    @Transactional
    public void saveEmployees(List<Employee> employees){

        repository.saveAll(employees);

    }

}