package com.example.digital_library.controller.rest;

import com.example.digital_library.dto.CreateOrganizationRequest;
import com.example.digital_library.dto.OrganizationResponse;
import com.example.digital_library.service.OrganizationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<OrganizationResponse> addOrganization(
            @Valid @RequestBody CreateOrganizationRequest request
    ) {
        OrganizationResponse response = organizationService.createOrganization(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{org_id}")
    public ResponseEntity<OrganizationResponse> getOrganizationById(
            @PathVariable("org_id") UUID orgUid
    ) {
        OrganizationResponse response = organizationService.getOrganizationByUid(orgUid);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }
}
