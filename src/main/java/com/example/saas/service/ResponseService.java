package com.example.saas.service;

import com.example.saas.dto.ResponseDTO;
import com.example.saas.entity.Response;

import java.util.UUID;

public interface ResponseService {
    Response getResponseByQueryId(UUID queryId);
    Response createResponse(ResponseDTO responseDTO, UUID queryId);
}
