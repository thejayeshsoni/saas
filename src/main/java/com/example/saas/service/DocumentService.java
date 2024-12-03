package com.example.saas.service;

import com.example.saas.dto.DocumentDTO;
import com.example.saas.entity.Document;

import java.util.List;
import java.util.UUID;

public interface DocumentService {
    List<Document> getAllDocuments();
    Document getDocumentById(UUID docId);
    Document createDocument(DocumentDTO documentDTO);
    void deleteDocument(UUID docId);
}
