package com.example.napofirestore.api.common.config;

import com.example.napofirestore.api.common.constants.Url;
import com.example.napofirestore.api.interceptor.HeaderXAppInterceptor;
import com.example.napofirestore.api.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApiConfig implements WebMvcConfigurer {
    private final HeaderXAppInterceptor headerXAppInterceptor;
    private final JWTInterceptor jwtInterceptor;

    public ApiConfig(HeaderXAppInterceptor headerXAppInterceptor, JWTInterceptor jwtInterceptor) {
        this.headerXAppInterceptor = headerXAppInterceptor;
        this.jwtInterceptor = jwtInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(headerXAppInterceptor).addPathPatterns(
                Url.Auth.AUTH,
                Url.User.USER,
                Url.User.USERS,
                Url.User.ADD,
                Url.User.DELETE,
                Url.User.UPDATE
        );
        registry.addInterceptor(jwtInterceptor).addPathPatterns(
                Url.User.USERS,
                Url.User.USER_ME
        );
    }
}
