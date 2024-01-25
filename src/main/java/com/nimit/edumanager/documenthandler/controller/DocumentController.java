package com.nimit.edumanager.documenthandler.controller;

import com.nimit.edumanager.documenthandler.entity.Document;
import com.nimit.edumanager.documenthandler.pojo.DocumentDto;
import com.nimit.edumanager.documenthandler.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    /**
     * Create a document
     */
    @PostMapping(value = "/document", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Document> create(@ModelAttribute DocumentDto documentDto) {
        Document savedDocument = null;
        try {
            savedDocument = documentService.create(documentDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedDocument);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
