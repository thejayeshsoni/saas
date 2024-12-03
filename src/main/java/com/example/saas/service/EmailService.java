package com.example.saas.service;

import com.example.saas.dto.EmailDTO;
import com.example.saas.entity.Email;

import java.util.List;
import java.util.UUID;

public interface EmailService {
    List<Email> getAllEmails();
    Email getEmailById(UUID emailId);
    Email createEmail(EmailDTO emailDTO);
    Email updateEmail(UUID emailId, EmailDTO emailDTO);
    void deleteEmail(UUID emailId);
}
