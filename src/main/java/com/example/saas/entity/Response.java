package com.example.saas.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response {

    @Id
    @GeneratedValue
    private UUID responseId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "query_id", nullable = false)
    private EmailQuery emailQuery;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String responseText;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private java.sql.Timestamp sentAt;

    @Enumerated(EnumType.STRING)
    private Feedback feedback;

    public enum Feedback {
        POSITIVE, NEGATIVE, NEUTRAL
    }
}
