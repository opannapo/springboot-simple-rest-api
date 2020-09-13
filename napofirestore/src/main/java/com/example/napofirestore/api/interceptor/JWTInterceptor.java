package com.example.napofirestore.api.interceptor;

import com.example.napofirestore.api.common.config.AppConfig;
import com.example.napofirestore.api.common.exceptions.JWTAuthException;
import com.example.napofirestore.core.utils.JWTUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Component
public class JWTInterceptor extends HandlerInterceptorAdapter {
    private final JWTUtils jwtUtils;

    public JWTInterceptor(AppConfig appConfig, JWTUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String header = request.getHeader("Authorization");
        if (header == null || header.isEmpty()) {
            throw new JWTAuthException("Empty Authorization Header");
        }

        String[] headerAuthorization = request.getHeader("Authorization").split(" ");
        if (headerAuthorization.length == 1 || headerAuthorization.length > 2)
            throw new JWTAuthException("Invalid Authorization Header " + Arrays.toString(headerAuthorization));

        String jwtIn = headerAuthorization[1];
        jwtUtils.validateToken(jwtIn, (claims, ex) -> {
            if (ex == null) {
                request.setAttribute("token-body", claims.getBody());
            } else {
                throw new JWTAuthException(ex.getMessage() + " :: " + jwtIn);
            }
        });

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("\nJWTInterceptor.postHandle::" + request.getRequestURL());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("\nJWTInterceptor.afterCompletion::" + request.getRequestURL());
    }
}
