package com.example.saas.repository;

import com.example.saas.entity.Response;
import com.example.saas.entity.EmailQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ResponseRepository extends JpaRepository<Response, UUID> {
    Optional<Response> findByEmailQuery(EmailQuery emailQuery);
}
