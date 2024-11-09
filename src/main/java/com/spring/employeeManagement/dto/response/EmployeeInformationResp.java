package com.spring.employeeManagement.dto.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
public class EmployeeInformationResp {
    @JsonProperty("employeeId")
    private String id;
    private String name;
    private String nameEn;
    private String surname;
    private LocalDate dateOfBirth;
    private DepartmentResp department;
}
