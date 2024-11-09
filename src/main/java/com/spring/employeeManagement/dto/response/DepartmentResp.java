package com.spring.employeeManagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DepartmentResp {
    private String id;
    private String departmentName;
    private String departmentNameEn;
    private String departmentCode;
}
