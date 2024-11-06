package com.spring.employeeManagement.dto.request;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeEditReq {
    private String id;
    private String name;
    private String surname;
    private LocalDateTime dateOfBirth; 
}
