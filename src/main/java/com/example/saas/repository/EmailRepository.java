package com.example.saas.repository;

import com.example.saas.entity.Email;
import com.example.saas.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmailRepository extends JpaRepository<Email, UUID> {
    List<Email> findByOrganization(Organization organization);
    Optional<Email> findByEmailAddress(String emailAddress);
}
