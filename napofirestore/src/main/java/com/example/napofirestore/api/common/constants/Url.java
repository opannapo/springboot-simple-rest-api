package com.example.napofirestore.api.common.constants;

public class Url {
    private static final String BASE_URL = "/api/v1";

    public static final class Auth {
        public static final String AUTH = BASE_URL + "/auth";
    }

    public static final class User {
        public static final String USER = BASE_URL + "/user";
        public static final String ADD = BASE_URL + "/user/add";
        public static final String UPDATE = BASE_URL + "/user/update";
        public static final String DELETE = BASE_URL + "/user/delete";
        public static final String USERS = BASE_URL + "/users";
    }

}
