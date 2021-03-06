package com.example.napofirestore.api.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class HeaderRequestException extends RuntimeException {
    public HeaderRequestException(String msg) {
        super(msg);
    }
}
