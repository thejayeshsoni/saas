package com.example.saas.service.impl;

import com.example.saas.dto.DocumentDTO;
import com.example.saas.entity.Document;
import com.example.saas.repository.DocumentRepository;
import com.example.saas.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public Document getDocumentById(UUID docId) {
        return documentRepository.findById(docId)
                .orElseThrow(() -> new IllegalArgumentException("Document not found with ID: " + docId));
    }

    @Override
    public Document createDocument(DocumentDTO documentDTO) {
        Document document = Document.builder()
                .fileName(documentDTO.getFileName())
                .fileUrl(documentDTO.getFileUrl())
                .build();
        return documentRepository.save(document);
    }

    @Override
    public void deleteDocument(UUID docId) {
        documentRepository.deleteById(docId);
    }
}
