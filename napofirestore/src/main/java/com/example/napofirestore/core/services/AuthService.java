package com.example.napofirestore.core.services;

public interface AuthService {
    String auth(String key, String signature);

    String refreshToken(String tokenCurrent);
}
