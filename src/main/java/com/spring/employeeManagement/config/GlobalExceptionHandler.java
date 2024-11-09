package com.spring.employeeManagement.config;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import com.spring.employeeManagement.dto.response.BaseResponse;


@RestControllerAdvice
public class GlobalExceptionHandler implements RequestBodyAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        BaseResponse res = new BaseResponse(HttpStatus.BAD_REQUEST.valueOf(400).toString(),"BAD_REQUEST",errors);
        return ResponseEntity.badRequest().body(res);
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter,
            Type targetType, Class<? extends HttpMessageConverter<?>> converterType)
            throws IOException {

        return inputMessage;
    }

    @Override
    public boolean supports(MethodParameter methodParameter,
            Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage,
            MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        List<String> companyIdOption = Optional.ofNullable(inputMessage.getHeaders().get("companyId"))
                .orElse(new ArrayList<>());

        if (companyIdOption != null && companyIdOption.size() != 0) {
            // BaseRequest req = (BaseRequest) body;
            // req.setCompanyId(companyIdOption.get(0));
            return null;
        }

        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage,
            MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

}