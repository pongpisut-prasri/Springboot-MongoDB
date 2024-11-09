package com.spring.employeeManagement.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentEditReq extends BaseRequest{
    private String departmentId;

    @NotEmpty(message = "departmentName is required")
    private String departmentName;
    @NotEmpty(message = "departmentNameEn is required")
    private String departmentNameEn;
    @NotEmpty(message = "departmentCode is required")
    private String departmentCode;
}
