package com.example.saas.service.impl;

import com.example.saas.dto.EmailDTO;
import com.example.saas.entity.Email;
import com.example.saas.repository.EmailRepository;
import com.example.saas.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Override
    public List<Email> getAllEmails() {
        return emailRepository.findAll();
    }

    @Override
    public Email getEmailById(UUID emailId) {
        return emailRepository.findById(emailId)
                .orElseThrow(() -> new IllegalArgumentException("Email not found with ID: " + emailId));
    }

    @Override
    public Email createEmail(EmailDTO emailDTO) {
        Email email = Email.builder()
                .emailAddress(emailDTO.getEmailAddress())
                .enabled(emailDTO.getEnabled())
                .build();
        return emailRepository.save(email);
    }

    @Override
    public Email updateEmail(UUID emailId, EmailDTO emailDTO) {
        Email email = getEmailById(emailId);
        email.setEmailAddress(emailDTO.getEmailAddress());
        email.setEnabled(emailDTO.getEnabled());
        return emailRepository.save(email);
    }

    @Override
    public void deleteEmail(UUID emailId) {
        emailRepository.deleteById(emailId);
    }
}
