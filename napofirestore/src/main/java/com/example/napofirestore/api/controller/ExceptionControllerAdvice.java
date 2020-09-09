package com.example.napofirestore.api.controller;

import com.example.napofirestore.api.common.exceptions.HeaderRequestException;
import com.example.napofirestore.api.templates.response.Res;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionControllerAdvice extends BaseRestController {
    @ExceptionHandler(value = {HeaderRequestException.class})
    protected ResponseEntity<Res> headerRequestException(HttpServletRequest request, RuntimeException ex) {
        String msg = "Error ye " + ex.getMessage();
        Res res = outFail(HttpStatus.BAD_REQUEST.value(), msg);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    protected ResponseEntity<Res> httpRequestMethodNotSupportedException(HttpServletRequest request, HttpRequestMethodNotSupportedException ex) {
        String msg = "Error ye " + ex.getMessage();
        Res res = outFail(HttpStatus.BAD_REQUEST.value(), msg);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
