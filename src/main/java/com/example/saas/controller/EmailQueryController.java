package com.example.saas.controller;

import com.example.saas.dto.EmailQueryDTO;
import com.example.saas.entity.EmailQuery;
import com.example.saas.service.EmailQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/email-queries")
public class EmailQueryController {

    @Autowired
    private EmailQueryService emailQueryService;

    @GetMapping
    public ResponseEntity<List<EmailQuery>> getAllEmailQueries() {
        return ResponseEntity.ok(emailQueryService.getAllEmailQueries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmailQuery> getEmailQueryById(@PathVariable UUID id) {
        return ResponseEntity.ok(emailQueryService.getEmailQueryById(id));
    }

    @PostMapping
    public ResponseEntity<EmailQuery> createEmailQuery(@RequestBody EmailQueryDTO emailQueryDTO) {
        return ResponseEntity.ok(emailQueryService.createEmailQuery(emailQueryDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmailQuery> updateEmailQueryStatus(@PathVariable UUID id, @RequestParam String status) {
        return ResponseEntity.ok(emailQueryService.updateQueryStatus(id, status));
    }
}
