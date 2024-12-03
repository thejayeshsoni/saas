package com.example.saas.service.impl;

import com.example.saas.dto.OrganizationDTO;
import com.example.saas.entity.Organization;
import com.example.saas.repository.OrganizationRepository;
import com.example.saas.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization getOrganizationById(UUID orgId) {
        return organizationRepository.findById(orgId)
                .orElseThrow(() -> new IllegalArgumentException("Organization not found with ID: " + orgId));
    }

    @Override
    public Organization createOrganization(OrganizationDTO organizationDTO) {
        Organization organization = Organization.builder()
                .orgName(organizationDTO.getOrgName())
                .emailDomain(organizationDTO.getEmailDomain())
                .build();
        return organizationRepository.save(organization);
    }

    @Override
    public Organization updateOrganization(UUID orgId, OrganizationDTO organizationDTO) {
        Organization organization = getOrganizationById(orgId);
        organization.setOrgName(organizationDTO.getOrgName());
        organization.setEmailDomain(organizationDTO.getEmailDomain());
        return organizationRepository.save(organization);
    }

    @Override
    public void deleteOrganization(UUID orgId) {
        organizationRepository.deleteById(orgId);
    }
}
