package com.spring.employeeManagement.service;

import com.spring.employeeManagement.dto.request.EmployeeEditReq;
import com.spring.employeeManagement.dto.response.BaseResponse;

public interface EmployeeService {
    
    public BaseResponse editEmployee(EmployeeEditReq req);
}
