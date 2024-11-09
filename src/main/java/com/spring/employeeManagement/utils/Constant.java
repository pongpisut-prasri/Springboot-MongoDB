package com.spring.employeeManagement.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class Constant {

    @Getter
    @AllArgsConstructor
    public enum StatusFlag{
        ACTIVE("ACTIVE","Active","ใช้งาน");
        private String code;
        private String valueEn;
        private String valueTh;
    }

    @Getter
    @AllArgsConstructor
    public enum HttpResponse{
        SUCCESS("200","SUCCESS","Success"),
        CREATED("201","CREATE","Create"),
        BAD_REQUEST("400","BAD_REQUEST","Bad Request");
        private String httpStatusCode;
        private String statusCode;
        private String description;
    }
}
