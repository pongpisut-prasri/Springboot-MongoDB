package com.spring.employeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.employeeManagement.dto.request.BaseRequest;
import com.spring.employeeManagement.dto.request.EmployeeEditReq;
import com.spring.employeeManagement.dto.request.EmployeeGetReq;
import com.spring.employeeManagement.service.EmployeeService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/editEmployee")
    public ResponseEntity<?> editEmployee(@RequestBody @Valid EmployeeEditReq req) {
        try {
            return ResponseEntity.ok().body(employeeService.editEmployee(req));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping("/getEmployeeInformation")
    public ResponseEntity<?> getEmployeeInformation(@RequestBody BaseRequest req) {
        try {
            return ResponseEntity.ok().body(employeeService.getEmployeeInformation(req));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping("/getAllEmployees")
    public ResponseEntity<?> getAllEmployees(@RequestBody BaseRequest req) {
        try {
            return ResponseEntity.ok().body(null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping("/getEmployeeByDepartment")
    public ResponseEntity<?> getEmployeeByDepartment(@RequestBody EmployeeGetReq req) {
        try {
            return ResponseEntity.ok().body(employeeService.getEmployeeByDepartment(req.getDepartmentId()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
    

}
