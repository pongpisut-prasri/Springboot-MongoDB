package com.spring.employeeManagement.dto.request;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Validated
public class BaseRequest {
    private String id;
    private String status;
    private String currentUserId;
}
