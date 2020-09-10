package com.example.napofirestore.core.services.mysql;

import com.example.napofirestore.core.repositories.UserRepository;
import com.example.napofirestore.core.services.UserService;
import com.example.napofirestore.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MysqlUserService implements UserService {
    private final UserRepository userRepository;

    public MysqlUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Page<UserEntity> getAll(int page, int limit) {
        return userRepository.findAll(PageRequest.of(page, limit));
    }

    @Override
    public UserEntity getOne(int userId) {
        return null;
    }
}
