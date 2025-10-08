package com.example.digital_library.service;

import com.example.digital_library.domain.User;
import com.example.digital_library.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Optional<User> findUserByUid(UUID userUid) {
        return userMapper.findUserByUid(userUid);
    }
}
