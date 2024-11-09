package com.spring.employeeManagement.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.employeeManagement.dto.request.DepartmentEditReq;
import com.spring.employeeManagement.dto.request.DepartmentGetReq;
import com.spring.employeeManagement.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/editDepartment")
    public ResponseEntity<?> editDepartment(@Valid @RequestBody DepartmentEditReq req) throws IOException {

        try {
            return ResponseEntity.ok().body(departmentService.editDepartment(req));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/getAllDepartment")
    public ResponseEntity<?> getAllDepartment(@RequestBody DepartmentEditReq req) {

        try {
            return ResponseEntity.ok().body(departmentService.getAllDepartment(req));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping("/getDepartmentById")
    public ResponseEntity<?> getDepartmentById(@RequestBody DepartmentGetReq req) {

        try {
            return ResponseEntity.ok().body(departmentService.getDepartmentById(req));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

}
