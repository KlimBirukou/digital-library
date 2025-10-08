package com.example.digital_library.controller.rest;

import com.example.digital_library.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library/organization/{org_id}/users/{user_id}/files")
public class FileController {

    private final FileService fileService;

    @GetMapping
    public ResponseEntity<List<String>> listFiles(
            @PathVariable("org_id") UUID orgUid,
            @PathVariable("user_id") UUID userUid
    ) {
        return ResponseEntity.ok(fileService.findFiles(orgUid,userUid));
    }
}
