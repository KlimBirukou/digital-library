package com.example.digital_library.exception;

import lombok.NonNull;

public class EmptyOrganizationSearchListException extends RuntimeException {
    public EmptyOrganizationSearchListException(@NonNull String partialName) {
        super("Organizations with partial name %s not found".formatted(partialName));
    }
}
