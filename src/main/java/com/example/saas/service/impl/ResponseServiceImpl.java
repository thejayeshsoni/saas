package com.example.saas.service.impl;

import com.example.saas.dto.ResponseDTO;
import com.example.saas.entity.EmailQuery;
import com.example.saas.entity.Response;
import com.example.saas.repository.EmailQueryRepository;
import com.example.saas.repository.ResponseRepository;
import com.example.saas.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    private ResponseRepository responseRepository;

    @Autowired
    private EmailQueryRepository emailQueryRepository;

    @Override
    public Response getResponseByQueryId(UUID queryId) {
        EmailQuery query = emailQueryRepository.findById(queryId)
                .orElseThrow(() -> new IllegalArgumentException("Query not found with ID: " + queryId));
        return responseRepository.findByEmailQuery(query)
                .orElseThrow(() -> new IllegalArgumentException("Response not found for Query ID: " + queryId));
    }

    @Override
    public Response createResponse(ResponseDTO responseDTO, UUID queryId) {
        EmailQuery query = emailQueryRepository.findById(queryId)
                .orElseThrow(() -> new IllegalArgumentException("Query not found with ID: " + queryId));
        Response response = Response.builder()
                .emailQuery(query)
                .responseText(responseDTO.getResponseText())
                .feedback(Response.Feedback.valueOf(responseDTO.getFeedback().toUpperCase()))
                .build();
        return responseRepository.save(response);
    }
}
