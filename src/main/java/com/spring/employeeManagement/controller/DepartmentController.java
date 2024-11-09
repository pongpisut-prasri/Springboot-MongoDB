package com.spring.employeeManagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.employeeManagement.dto.request.DepartmentEditReq;
import com.spring.employeeManagement.dto.request.DepartmentGetReq;
import com.spring.employeeManagement.service.DepartmentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/department")
public class DepartmentController {
    
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @PostMapping("/editDepartment")
    public ResponseEntity<?> editDepartment(@RequestBody DepartmentEditReq req) {
        //TODO: process POST request
        try {
            return ResponseEntity.ok().body(departmentService.editDepartment(req));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping("/getAllDepartment")
    public ResponseEntity<?> getAllDepartment(@RequestBody DepartmentEditReq req) {
        //TODO: process POST request
        try {
            return ResponseEntity.ok().body(departmentService.getAllDepartment(req));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping("/getDepartmentById")
    public ResponseEntity<?> getDepartmentById(@RequestBody DepartmentGetReq req) {
        //TODO: process POST request
        try {
            return ResponseEntity.ok().body(departmentService.getDepartmentById(req));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
    
}
