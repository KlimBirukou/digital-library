package com.example.digital_library.exception;

import java.util.UUID;

public class OrganizationNotFoundException extends RuntimeException {
    public OrganizationNotFoundException(UUID organizationUid) {
        super("Organization with UUID %s not found".formatted(organizationUid));
    }
}
