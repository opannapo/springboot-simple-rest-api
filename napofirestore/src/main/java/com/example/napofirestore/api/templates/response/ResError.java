package com.example.napofirestore.api.templates.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResError {
    private String message;
    private int code;
}
