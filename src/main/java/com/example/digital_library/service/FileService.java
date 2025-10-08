package com.example.digital_library.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileService {

    private final UserService userService;

    public List<String> findFiles(UUID orgUid, UUID userUid) {
        return userService.getUserByUid(userUid)
                .filter(user -> orgUid.equals(user.getOrganizationId()))
                // TODO: do a normal check
                .map(user -> List.of("el1", "el2"))
                // TODO: add normal error handling
                .orElseGet(List::of);
    }
}
