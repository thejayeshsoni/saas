package com.example.saas.service.impl;

import com.example.saas.dto.EmailQueryDTO;
import com.example.saas.entity.EmailQuery;
import com.example.saas.repository.EmailQueryRepository;
import com.example.saas.service.EmailQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmailQueryServiceImpl implements EmailQueryService {

    @Autowired
    private EmailQueryRepository emailQueryRepository;

    @Override
    public List<EmailQuery> getAllEmailQueries() {
        return emailQueryRepository.findAll();
    }

    @Override
    public EmailQuery getEmailQueryById(UUID queryId) {
        return emailQueryRepository.findById(queryId)
                .orElseThrow(() -> new IllegalArgumentException("Query not found with ID: " + queryId));
    }

    @Override
    public EmailQuery createEmailQuery(EmailQueryDTO emailQueryDTO) {
        EmailQuery emailQuery = EmailQuery.builder()
                .customerEmail(emailQueryDTO.getCustomerEmail())
                .subject(emailQueryDTO.getSubject())
                .body(emailQueryDTO.getBody())
                .status(EmailQuery.QueryStatus.PENDING)
                .build();
        return emailQueryRepository.save(emailQuery);
    }

    @Override
    public EmailQuery updateQueryStatus(UUID queryId, String status) {
        EmailQuery query = getEmailQueryById(queryId);
        query.setStatus(EmailQuery.QueryStatus.valueOf(status.toUpperCase()));
        return emailQueryRepository.save(query);
    }
}
