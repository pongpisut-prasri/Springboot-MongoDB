package com.spring.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.employeeManagement.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,String>{
    
}
