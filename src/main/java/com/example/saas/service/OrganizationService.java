package com.example.saas.service;

import com.example.saas.dto.OrganizationDTO;
import com.example.saas.entity.Organization;

import java.util.List;
import java.util.UUID;

public interface OrganizationService {
    List<Organization> getAllOrganizations();
    Organization getOrganizationById(UUID orgId);
    Organization createOrganization(OrganizationDTO organizationDTO);
    Organization updateOrganization(UUID orgId, OrganizationDTO organizationDTO);
    void deleteOrganization(UUID orgId);
}
