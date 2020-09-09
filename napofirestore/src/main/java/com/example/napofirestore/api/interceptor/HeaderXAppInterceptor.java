package com.example.napofirestore.api.interceptor;

import com.example.napofirestore.api.common.constants.Attr;
import com.example.napofirestore.api.common.exceptions.HeaderRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class HeaderXAppInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    Attr attr;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        System.out.println("\nHeaderXAppInterceptor.preHandle::" + request.getRequestURL());

        String header = request.getHeader("X-App");
        System.out.println("\nXAppInterceptor.header::" + header);

        if (header == null || header.isEmpty()) {
            throw new HeaderRequestException("Empty X-App Header");
        }

        String headerXapp = request.getHeader("X-App").toLowerCase();
        if (headerXapp.equals(attr.getxAppSignature())) {
            throw new HeaderRequestException("Invalid X-App Header " + headerXapp);
        }

        return true;
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
