package com.example.napofirestore.api.controller;

import com.example.napofirestore.api.common.constants.Url;
import com.example.napofirestore.api.templates.request.AuthRequestParam;
import com.example.napofirestore.api.templates.response.Res;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
public class AuthController extends BaseRestController {


    @PostMapping(Url.Auth.AUTH)
    public Res auth(HttpServletRequest request, @Valid @RequestBody AuthRequestParam param) {
        return outOk(param);
    }

}
