package com.example.napofirestore.api.interceptor;

import com.example.napofirestore.api.common.config.AppConfig;
import com.example.napofirestore.api.common.exceptions.JWTAuthException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Component
public class JWTInterceptor extends HandlerInterceptorAdapter {
    private final AppConfig appConfig;

    public JWTInterceptor(AppConfig appConfig) {
        this.appConfig = appConfig;
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
        Jws<Claims> jws = Jwts.parserBuilder()
                .setSigningKey(appConfig.getJwtKey())
                .build()
                .parseClaimsJws(jwtIn);

        throw new JWTAuthException("RESULT JWS from :: " + jwtIn + " is :: " + jws);
        //return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("\nHeaderXAppInterceptor.postHandle::" + request.getRequestURL());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long takenTime = (endTime - startTime);
        System.out.println("\nHeaderXAppInterceptor.afterCompletion::" + request.getRequestURL() + ":: " + takenTime + "ms");
    }
}
