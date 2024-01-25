package com.nimit.edumanager.automationservice.controller;

import com.itextpdf.text.DocumentException;
import com.nimit.edumanager.studentmanager.exception.StudentNotFoundException;
import com.nimit.edumanager.automationservice.service.InvoiceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class GenerateInvoiceController {

    @Autowired
    InvoiceGeneratorService invoiceGeneratorService;

    @GetMapping(value = "/students/{id}/generate-invoice", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> generateStudentPaymentInvoice(@PathVariable Long id) {
        try {
            invoiceGeneratorService.generateStudentPaymentInvoicePdf(id);
            return ResponseEntity.ok("Invoice generated successfully for student with id :" + id);
        } catch (StudentNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (DocumentException | FileNotFoundException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

}
