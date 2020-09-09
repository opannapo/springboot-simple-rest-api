package com.example.napofirestore.api.templates.response;

import com.example.napofirestore.api.common.exceptions.NoResultException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@ResponseStatus(value = HttpStatus.OK)
public class Res {
    private Object data;
    private boolean isSuccess;
    private ResError error;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data, int page, int limit) {
        System.out.print("LOG DATA -> " + data);
        if (data == null || data.equals(Optional.empty())) {
            throw new NoResultException("Content Not Found!");
        }
        this.data = data;
    }

    public ResError getError() {
        return error;
    }

    public void setError(ResError error) {
        this.error = error;
    }

}

