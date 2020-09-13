package com.example.napofirestore.core.services;

import com.example.napofirestore.entities.CredentialEntity;

import java.util.Optional;

public interface CredentialService {
    Optional<CredentialEntity> auth(String key, String signature);

    Optional<CredentialEntity> refreshToken(String tokenCurrent);
}
