package com.example.napofirestore.api.controller;

import com.example.napofirestore.api.templates.response.Res;
import com.example.napofirestore.api.templates.response.ResError;
import org.springframework.data.domain.Page;

import java.util.List;

public abstract class BaseRestController {
    Res outOk(Object obj, int page, int limit) {
        Res res = new Res();
        res.setSuccess(true);
        res.setData(obj, page, limit);
        return res;
    }

    Res outOk(Object obj) {
        Res res = new Res();
        res.setSuccess(true);
        res.setData(obj, 0, 0);
        return res;
    }

    Res outOk(List<?> list, int page, int limit) {
        Res res = new Res();
        res.setSuccess(true);
        res.setData(list, page, limit);
        return res;
    }

    Res outOk(Page<?> page) {
        Res res = new Res();
        res.setSuccess(true);
        res.setData(page, 0, 0);
        return res;
    }

    Res outFail(int code, String msg) {
        Res res = new Res();
        ResError resError = new ResError();

        res.setSuccess(false);
        resError.setCode(code);
        resError.setMessage(msg);
        res.setError(resError);
        return res;
    }
}
