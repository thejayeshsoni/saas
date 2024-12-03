package com.example.saas.controller;

import com.example.saas.dto.EmailDTO;
import com.example.saas.entity.Email;
import com.example.saas.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping
    public ResponseEntity<List<Email>> getAllEmails() {
        return ResponseEntity.ok(emailService.getAllEmails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Email> getEmailById(@PathVariable UUID id) {
        return ResponseEntity.ok(emailService.getEmailById(id));
    }

    @PostMapping
    public ResponseEntity<Email> createEmail(@RequestBody EmailDTO emailDTO) {
        return ResponseEntity.ok(emailService.createEmail(emailDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Email> updateEmail(@PathVariable UUID id, @RequestBody EmailDTO emailDTO) {
        return ResponseEntity.ok(emailService.updateEmail(id, emailDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmail(@PathVariable UUID id) {
        emailService.deleteEmail(id);
        return ResponseEntity.noContent().build();
    }
}
