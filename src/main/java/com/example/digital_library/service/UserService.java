package com.example.digital_library.service;

import com.example.digital_library.domain.User;
import com.example.digital_library.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public Optional<User> getUserByUid(UUID userUid) {
        return userMapper.findUserByUid(userUid);
    }
}
