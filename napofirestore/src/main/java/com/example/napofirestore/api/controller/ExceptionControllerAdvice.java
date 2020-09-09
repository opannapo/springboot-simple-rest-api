package com.example.napofirestore.api.controller;

import com.example.napofirestore.api.common.exceptions.HeaderRequestException;
import com.example.napofirestore.api.templates.response.Res;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionControllerAdvice extends BaseRestController {
    @ExceptionHandler(value = {HeaderRequestException.class})
    protected Res handleHeaderException(HttpServletRequest request, RuntimeException ex) {
        String msg = "Error ye " + ex.getMessage();
        return outFail(200, msg);
    }
}
