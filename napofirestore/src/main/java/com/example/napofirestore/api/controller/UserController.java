package com.example.napofirestore.api.controller;

import com.example.napofirestore.api.common.constants.Url;
import com.example.napofirestore.api.common.exceptions.JWTAuthException;
import com.example.napofirestore.api.templates.response.Res;
import com.example.napofirestore.api.templates.response.View;
import com.example.napofirestore.core.services.UserService;
import com.example.napofirestore.core.services.mysql.MysqlUserService;
import com.example.napofirestore.entities.UserEntity;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
public class UserController extends BaseRestController {
    private final UserService mysqlUserService;

    public UserController(MysqlUserService mysqlUserService) {
        this.mysqlUserService = mysqlUserService;
    }

    @GetMapping(Url.User.USERS)
    public Res getUsers(HttpServletRequest request,
                        @RequestParam(required = false, defaultValue = "1") Optional<Integer> page,
                        @RequestParam(required = false, defaultValue = "20") Optional<Integer> limit) {
        Page result = mysqlUserService.getAll(page.get(), limit.get());
        return outOk(result);
    }

    @GetMapping(Url.User.USER)
    @JsonView({View.Public.class})
    public Res getUserAsPublic(HttpServletRequest request, @RequestParam int id) {
        UserEntity result = mysqlUserService.getOne(id);
        return outOk(result);
    }

    @GetMapping(Url.User.USER_ME)
    @JsonView({View.Owner.class})
    public Res getUserAsOwner(HttpServletRequest request) {
        try {
            JSONObject tokenBody = new JSONObject(String.valueOf(request.getAttribute("token-body")));
            int id = tokenBody.getInt("uid");
            UserEntity result = mysqlUserService.getOne(id);
            return outOk(result);
        } catch (JSONException e) {
            e.printStackTrace();
            throw new JWTAuthException(e.getMessage());
        }
    }

}
