package com.example.digital_library.service;

import com.example.digital_library.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class FileService {
    private final UserService userService;

    public FileService(UserService userService) {
        this.userService = userService;
    }

    public List<String> findFiles(UUID orgUid, UUID userUid) {
        return userService.findUserByUid(userUid)
                .filter(user -> orgUid.equals(user.getOrganizationId()))
                .map(user -> List.of("el1", "el2"))
                .orElse(List.of());
    }
}
