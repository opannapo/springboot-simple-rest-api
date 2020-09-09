package com.example.napofirestore.api.controller;

import com.example.napofirestore.api.common.exceptions.HeaderRequestException;
import com.example.napofirestore.api.templates.response.Res;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionControllerAdvice extends BaseRestController {
    @ExceptionHandler(value = {HeaderRequestException.class})
    protected Res headerRequestException(HttpServletRequest request, RuntimeException ex) {
        String msg = "Error ye " + ex.getMessage();
        return outFail(HttpStatus.BAD_REQUEST.value(), msg);
    }

    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    protected Res httpRequestMethodNotSupportedException(HttpServletRequest request, RuntimeException ex) {
        String msg = "Error ye " + ex.getMessage();
        return outFail(HttpStatus.BAD_GATEWAY.value(), msg);
    }
}
