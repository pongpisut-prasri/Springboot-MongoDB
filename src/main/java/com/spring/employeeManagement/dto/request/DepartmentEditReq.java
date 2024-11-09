package com.spring.employeeManagement.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentEditReq extends BaseRequest{
    private String departmentId;
    private String departmentName;
    private String departmentNameEn;
    private String departmentCode;
}
