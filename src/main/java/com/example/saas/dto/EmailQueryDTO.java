package com.example.saas.dto;

import lombok.Data;

@Data
public class EmailQueryDTO {
    private String customerEmail;
    private String subject;
    private String body;
    private String status; // Enum: PENDING, PROCESSED, FAILED
}
