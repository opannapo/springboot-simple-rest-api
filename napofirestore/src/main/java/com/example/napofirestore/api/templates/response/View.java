package com.example.napofirestore.api.templates.response;

public class View {
    interface BaseResponse {
    }

    public interface All extends BaseResponse, Public, Owner {
    }

    public interface Public extends BaseResponse {
    }

    public interface Owner extends BaseResponse, Public {
    }

    public interface AuthDefault extends BaseResponse {
    }
}