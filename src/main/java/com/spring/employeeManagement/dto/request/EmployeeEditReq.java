package com.spring.employeeManagement.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeEditReq extends BaseRequest{
    
    @NotNull(message = "name is require")
    private String name;

    @NotEmpty(message = "surname is require")
    private String surname;
    private LocalDate dateOfBirth;
    private String departmentId;
}
