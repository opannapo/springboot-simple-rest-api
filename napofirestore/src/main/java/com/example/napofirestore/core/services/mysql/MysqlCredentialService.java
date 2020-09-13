package com.example.napofirestore.core.services.mysql;

import com.example.napofirestore.core.repositories.CredentialRepository;
import com.example.napofirestore.core.repositories.specifications.CredentialSpecifications;
import com.example.napofirestore.core.services.CredentialService;
import com.example.napofirestore.core.utils.JWTUtils;
import com.example.napofirestore.entities.CredentialEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Optional;

@Service
public class MysqlCredentialService implements CredentialService {
    private final CredentialRepository credentialRepository;
    private final JWTUtils jwtUtils;

    public MysqlCredentialService(CredentialRepository credentialRepository, JWTUtils jwtUtils) {
        this.credentialRepository = credentialRepository;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public Optional<CredentialEntity> auth(String key, String signature) {
        String md5 = DigestUtils.md5DigestAsHex(signature.getBytes());
        Specification<CredentialEntity> spec = CredentialSpecifications.spec1(key, md5);
        Optional<CredentialEntity> result = credentialRepository.findOne(spec);
        result.ifPresent(credentialEntity -> {
            credentialEntity.setToken(jwtUtils.generateToken(credentialEntity.getUserId()));
        });

        return result;
    }

    @Override
    public Optional<CredentialEntity> refreshToken(String tokenCurrent) {
        return Optional.empty();
    }
}
