package com.example.saas.repository;

import com.example.saas.entity.EmailQuery;
import com.example.saas.entity.Organization;
import com.example.saas.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmailQueryRepository extends JpaRepository<EmailQuery, UUID> {
    List<EmailQuery> findByOrganization(Organization organization);
    List<EmailQuery> findByEmail(Email email);
    List<EmailQuery> findByStatus(EmailQuery.QueryStatus status);
}
