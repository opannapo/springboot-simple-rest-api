package com.example.napofirestore.core.services;

import com.example.napofirestore.entities.UserEntity;
import org.springframework.data.domain.Page;

public interface UserService {
    Page<UserEntity> getAll(int page, int limit);

    UserEntity getOne(int userId);
}
