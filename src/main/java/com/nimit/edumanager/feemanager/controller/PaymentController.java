package com.nimit.edumanager.feemanager.controller;

import com.nimit.edumanager.feemanager.entity.Payment;
import com.nimit.edumanager.feemanager.service.PaymentService;
import com.nimit.edumanager.studentmanager.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping(value = "/payments", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Payment> create(@RequestBody Payment payment) {
        return ResponseEntity.ok(paymentService.create(payment));
    }

    @GetMapping(value = "students/{id}/payments", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Payment>> getPaymentsByStudentId(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(paymentService.getAllPaymentsByStudentId(id), HttpStatus.OK);
        } catch (StudentNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
