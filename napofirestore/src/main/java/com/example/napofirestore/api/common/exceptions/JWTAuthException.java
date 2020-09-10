package com.example.napofirestore.api.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class JWTAuthException extends RuntimeException {
    public JWTAuthException(String msg) {
        super(msg);
    }
}
