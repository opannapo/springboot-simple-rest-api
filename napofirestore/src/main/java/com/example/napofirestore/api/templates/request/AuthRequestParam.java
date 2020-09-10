package com.example.napofirestore.api.templates.request;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Setter
@Getter
@ToString
public class AuthRequestParam {
    @Length(min = 5, message = "Key min 5 character")
    private String key;
    @Length(min = 8, message = "Signature min 8 character")
    private String signature;
    private int type;
}