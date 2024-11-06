package com.spring.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.employeeManagement.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String>{
    
}
