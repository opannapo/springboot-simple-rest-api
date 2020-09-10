package com.example.napofirestore.api.templates.request;


import org.hibernate.validator.constraints.Length;

public class AuthRequestParam {
    @Length(min = 5, message = "Key min 5 character")
    private String key;
    @Length(min = 8, message = "Signature min 8 character")
    private String signature;
    private int type;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
