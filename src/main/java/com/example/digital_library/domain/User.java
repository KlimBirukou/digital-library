package com.example.digital_library.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class User {
    private UUID userId;
    private String name;
    private UUID organizationId;
}
