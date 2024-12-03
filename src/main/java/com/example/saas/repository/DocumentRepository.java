package com.example.saas.repository;

import com.example.saas.entity.Document;
import com.example.saas.entity.Email;
import com.example.saas.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DocumentRepository extends JpaRepository<Document, UUID> {
    List<Document> findByOrganization(Organization organization);
    List<Document> findByEmail(Email email);
}
