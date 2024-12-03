package com.example.saas.dto;

import lombok.Data;

@Data
public class ResponseDTO {
    private String responseText;
    private String feedback; // Enum: POSITIVE, NEGATIVE, NEUTRAL
}
