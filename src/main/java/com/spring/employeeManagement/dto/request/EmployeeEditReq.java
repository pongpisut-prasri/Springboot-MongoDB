package com.spring.employeeManagement.dto.request;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeEditReq extends BaseRequest{
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String departmentId;
}
