package com.example.napofirestore.api.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


//@Component
@Configuration
@ConfigurationProperties(prefix = "app.config")
@Setter
@Getter
public class AppConfig {
    /*@Value(value = "${app.jwt.key}")
    public String jwtKey;
    @Value(value = "${app.xapp.signature}")
    public String xAppSignature;*/

    private String jwtKey;
    private String xAppSignature;
}