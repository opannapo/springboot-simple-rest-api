package com.example.napofirestore.api.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


//@Component
@Configuration
@ConfigurationProperties(prefix = "app.config")
public class AppConfig {
    /*@Value(value = "${app.jwt.key}")
    public String jwtKey;
    @Value(value = "${app.xapp.signature}")
    public String xAppSignature;*/


    private String jwtKey;
    private String xAppSignature;

    public String getJwtKey() {
        return jwtKey;
    }

    public void setJwtKey(String jwtKey) {
        this.jwtKey = jwtKey;
    }

    public String getxAppSignature() {
        return xAppSignature;
    }

    public void setxAppSignature(String xAppSignature) {
        this.xAppSignature = xAppSignature;
    }
}