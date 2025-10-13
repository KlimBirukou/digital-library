package com.example.digital_library.exception;

public class OrganizationAlreadyExistsException extends RuntimeException {

    public OrganizationAlreadyExistsException(String name) {
        super("Organization with name %s already exist".formatted(name));
    }
}
