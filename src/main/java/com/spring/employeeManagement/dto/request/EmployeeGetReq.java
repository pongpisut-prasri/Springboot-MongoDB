package com.spring.employeeManagement.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeGetReq {
    private String employeeId;
    private String departmentId;
}
