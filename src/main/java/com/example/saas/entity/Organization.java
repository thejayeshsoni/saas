package com.example.saas.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Organization {

    @Id
    @GeneratedValue
    private UUID orgId;

    @Column(nullable = false)
    private String orgName;

    @Column(unique = true, nullable = false)
    private String emailDomain;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private java.sql.Timestamp createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private java.sql.Timestamp updatedAt;
}
