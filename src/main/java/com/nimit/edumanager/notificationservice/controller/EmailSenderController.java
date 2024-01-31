package com.nimit.edumanager.notificationservice.controller;

import com.nimit.edumanager.notificationservice.pojo.EmailDto;
import com.nimit.edumanager.notificationservice.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class EmailSenderController {

    @Autowired
    EmailSenderService emailSenderService;

    @PostMapping(value = "/emails-send", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> sendEmail(@RequestBody EmailDto emailDto) {
        try {
            return ResponseEntity.ok(emailSenderService.sendEmail(emailDto.getEmailId()));
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
