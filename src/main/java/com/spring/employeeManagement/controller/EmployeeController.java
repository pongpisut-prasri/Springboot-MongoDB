package com.spring.employeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.employeeManagement.dto.request.EmployeeEditReq;
import com.spring.employeeManagement.service.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/editEmployee")
    public ResponseEntity<?> editEmployee(@RequestBody EmployeeEditReq req) {
        try {
            return ResponseEntity.ok().body(employeeService.editEmployee(req));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
    

}
