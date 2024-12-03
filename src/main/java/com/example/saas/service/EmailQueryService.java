package com.example.saas.service;

import com.example.saas.dto.EmailQueryDTO;
import com.example.saas.entity.EmailQuery;

import java.util.List;
import java.util.UUID;

public interface EmailQueryService {
    List<EmailQuery> getAllEmailQueries();
    EmailQuery getEmailQueryById(UUID queryId);
    EmailQuery createEmailQuery(EmailQueryDTO emailQueryDTO);
    EmailQuery updateQueryStatus(UUID queryId, String status);
}
