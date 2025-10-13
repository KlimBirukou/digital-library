package com.example.digital_library.service;


import com.example.digital_library.domain.Organization;
import com.example.digital_library.dto.CreateOrganizationRequest;
import com.example.digital_library.dto.OrganizationResponse;
import com.example.digital_library.exception.OrganizationAlreadyExistsException;
import com.example.digital_library.mapper.OrganizationMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationMapper organizationMapper;

    @Transactional
    public OrganizationResponse createOrganization(@NonNull CreateOrganizationRequest request) {
        String name = request.name();
        if (organizationMapper.existByName(name)) {
            throw new OrganizationAlreadyExistsException(name);
        }
        Organization organization = new Organization()
                .setOrganizationId(UUID.randomUUID())
                .setName(name);
        organizationMapper.addOrganization(organization);
        return new OrganizationResponse(organization);
    }

    public Optional<Organization> getOrganizationByUid(UUID organizationUid) {
        return organizationMapper.findOrganizationByUid(organizationUid);
    }
}
