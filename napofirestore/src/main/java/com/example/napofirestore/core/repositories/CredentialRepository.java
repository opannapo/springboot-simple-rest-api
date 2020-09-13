package com.example.napofirestore.core.repositories;

import com.example.napofirestore.entities.CredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CredentialRepository extends JpaRepository<CredentialEntity, Integer>, JpaSpecificationExecutor<CredentialEntity> {
}
