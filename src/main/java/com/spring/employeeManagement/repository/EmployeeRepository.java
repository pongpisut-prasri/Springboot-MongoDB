package com.spring.employeeManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.employeeManagement.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    // * join department table
    @Query(value = "SELECT e.* FROM emp_data e " +
            "JOIN department de ON e.department_id = de.id " +
            "WHERE e.id = ?1", nativeQuery = true)
    Employee findEmployeeInformation(String employeeId);

    List<Employee> findByDepartmentId(String departmentId);
}
