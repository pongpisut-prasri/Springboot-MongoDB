package com.spring.employeeManagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BaseResponse {
    private String code;
    private String description;
    private Object content;

    public BaseResponse(Object object){
        this.code="200";
        this.description="SUCCESS";
        this.content=object;
    }

    public BaseResponse(){
        this.code="200";
        this.description="SUCCESS";
    }
    public BaseResponse(String code ,String description){
        this.code=code;
        this.description=description;
    }
}
