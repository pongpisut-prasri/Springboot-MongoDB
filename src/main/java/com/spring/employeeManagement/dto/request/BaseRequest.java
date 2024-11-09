package com.spring.employeeManagement.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseRequest {
    private String id;
    private String status;
    private String currentUserId;
}
