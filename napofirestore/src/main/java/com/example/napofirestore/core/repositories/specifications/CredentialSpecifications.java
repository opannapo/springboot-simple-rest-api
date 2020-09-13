package com.example.napofirestore.core.repositories.specifications;

import com.example.napofirestore.entities.CredentialEntity;
import org.springframework.data.jpa.domain.Specification;

public class CredentialSpecifications {
    public static Specification<CredentialEntity> spec1(String key, String signature) {
        return (Specification<CredentialEntity>) (root, query, criteriaBuilder) ->
                criteriaBuilder.and(
                        criteriaBuilder.equal(root.get("key"), key),
                        criteriaBuilder.equal(root.get("signature"), signature)
                );
    }
}
