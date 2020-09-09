package com.example.napofirestore.api.controller;

import com.example.napofirestore.api.common.exceptions.HeaderRequestException;
import com.example.napofirestore.api.templates.response.Res;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class ExceptionControllerAdvice extends BaseRestController {
    @ExceptionHandler(value = {HeaderRequestException.class})
    protected ResponseEntity<Res> headerRequestException(RuntimeException ex) {
        return generateErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    protected ResponseEntity<Res> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        return generateErrorResponse(ex.getMessage(), HttpStatus.METHOD_NOT_ALLOWED.value());
    }

    @ExceptionHandler(value = {NoHandlerFoundException.class})
    protected ResponseEntity<Res> noHandlerFoundException(NoHandlerFoundException ex) {
        return generateErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    private ResponseEntity<Res> generateErrorResponse(String msg, int internalCode) {
        Res res = outFail(internalCode, msg);
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }


}
