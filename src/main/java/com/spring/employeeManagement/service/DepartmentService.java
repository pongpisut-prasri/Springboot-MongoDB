package com.spring.employeeManagement.service;

import com.spring.employeeManagement.dto.request.BaseRequest;
import com.spring.employeeManagement.dto.request.DepartmentEditReq;
import com.spring.employeeManagement.dto.request.DepartmentGetReq;
import com.spring.employeeManagement.dto.response.BaseResponse;

public interface DepartmentService {
    
    public BaseResponse editDepartment(DepartmentEditReq req);

    public BaseResponse getDepartmentById(DepartmentGetReq req);

    public BaseResponse getAllDepartment(BaseRequest req);
}
