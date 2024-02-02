package com.nimit.edumanager.automationservice.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.nimit.edumanager.feemanager.entity.Payment;
import com.nimit.edumanager.feemanager.service.PaymentService;
import com.nimit.edumanager.studentmanager.entity.Student;
import com.nimit.edumanager.studentmanager.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class InvoiceGeneratorService {

    @Autowired
    PaymentService paymentService;

    public void generateStudentPaymentInvoicePdf(Long id) throws StudentNotFoundException, DocumentException, FileNotFoundException {
        List<Payment> payments = paymentService.getAllPaymentsByStudentId(id);
        Integer sumOfAmount = payments.stream()
                .mapToInt(Payment::getAmount)
                .sum();
        Student student = payments.get(0).getStudent();
        generatePdf(student, sumOfAmount);
    }

    public void generatePdf(Student student, Integer sumOfAmount) throws FileNotFoundException, DocumentException, DocumentException {

        Document document = new Document();

        PdfWriter.getInstance(document, new FileOutputStream("temp/invoice.pdf"));
        document.open();

        Font headingFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 32, BaseColor.BLACK);
        Paragraph heading = new Paragraph("Invoice", headingFont);
        heading.setAlignment(Element.ALIGN_CENTER);
        document.add(heading);


        document.add(new Paragraph("Student Name : " + student.getFirstName() + " " + student.getLastName()));
        document.add(new Paragraph("Total Amount : " + sumOfAmount));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String generationDate = dateFormat.format(new Date());
        document.add(new Paragraph("Invoice Generation Date : " + generationDate));

        document.close();

    }

}
