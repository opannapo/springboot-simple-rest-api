package com.example.napofirestore.api.controller;

import com.example.napofirestore.api.common.constants.Url;
import com.example.napofirestore.api.templates.request.AuthRequestParam;
import com.example.napofirestore.api.templates.response.Res;
import com.example.napofirestore.api.templates.response.View;
import com.example.napofirestore.core.services.CredentialService;
import com.example.napofirestore.core.services.mysql.MysqlCredentialService;
import com.example.napofirestore.entities.CredentialEntity;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@RestController
public class AuthController extends BaseRestController {
    private final CredentialService credentialService;

    public AuthController(MysqlCredentialService authService) {
        this.credentialService = authService;
    }

    @PostMapping(Url.Auth.AUTH)
    @JsonView(View.AuthDefault.class)
    public Res authBySite(HttpServletRequest request, @Valid @RequestBody AuthRequestParam param) {
        Optional<CredentialEntity> credentialEntity = credentialService.auth(param.getKey(), param.getSignature());
        return outOk(credentialEntity);
    }

}
