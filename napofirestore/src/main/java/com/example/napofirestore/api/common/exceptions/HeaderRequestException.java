package com.example.napofirestore.api.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class HeaderRequestException extends RuntimeException {
    public HeaderRequestException(String msg) {
        super(msg);
    }
}
