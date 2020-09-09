package com.example.napofirestore.api.common.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Attr {
    @Value(value = "${app.jwt.key}")
    public String jwtKey;
    @Value(value = "${app.xapp.signature}")
    public String xAppSignature;


    public String getJwtKey() {
        return jwtKey;
    }

    public String getxAppSignature() {
        return xAppSignature;
    }
}