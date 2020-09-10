package com.example.napofirestore.api.controller;

import com.example.napofirestore.api.common.constants.Url;
import com.example.napofirestore.api.templates.response.Res;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController extends BaseRestController {
    @GetMapping(Url.User.USERS)
    public Res getUsers(HttpServletRequest request, @RequestParam int page, @RequestParam int limit) {
        return outOk("oke");
    }
}
