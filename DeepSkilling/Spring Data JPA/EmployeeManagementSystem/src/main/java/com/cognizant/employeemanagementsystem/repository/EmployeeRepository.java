package com.cognizant.employeemanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.employeemanagementsystem.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

    Employee findByEmail(String email);

    List<Employee> findByNameContaining(String name);

    List<Employee> findByNameStartingWith(String name);

    List<Employee> findByNameEndingWith(String name);

    List<Employee> findByNameContainingIgnoreCase(String name);
    
    @Query("SELECT e FROM Employee e WHERE e.email=:email")
    Employee getEmployeeByEmail(
            @Param("email") String email);
    
    @Query(name="Employee.findByEmployeeName")
    List<Employee> getEmployeeByName(
            @Param("name") String name);
    
    @Query("""
    		SELECT new com.cognizant.employeemanagementsystem.projection.EmployeeDTO(
    		e.name,
    		e.email)
    		FROM Employee e
    		""")
    		List<EmployeeDTO> getEmployeeDTO();

}