package com.nimit.edumanager.documenthandler.service;

import com.nimit.edumanager.documenthandler.entity.Document;
import com.nimit.edumanager.documenthandler.pojo.DocumentDto;
import com.nimit.edumanager.documenthandler.repository.DocumentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Transactional
public class DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    /**
     * Save a document
     *
     * @param 
     * @return
     */
    public Document create(DocumentDto documentDto) throws IOException {
        Document document = new Document();
        document.setStudent(documentDto.getStudent());
        document.setDocumentType(documentDto.getDocumentType());
        document.setDocumentName(documentDto.getFile().getOriginalFilename());
        document.setFile(documentDto.getFile().getBytes());
        return documentRepository.save(document);
    }
}
