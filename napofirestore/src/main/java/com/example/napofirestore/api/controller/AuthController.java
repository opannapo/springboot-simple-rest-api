package com.example.napofirestore.api.controller;

import com.example.napofirestore.api.common.constants.Url;
import com.example.napofirestore.api.templates.response.Res;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthController extends BaseRestController {

    @GetMapping(Url.Auth.AUTH)
    public Res welcomeTest(HttpServletRequest request) {
        return outOk("test " + request);
    }
}
