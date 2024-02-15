package com.nimit.edumanager.studentleadmanager.controller;

import com.nimit.edumanager.studentleadmanager.entity.StudentLead;
import com.nimit.edumanager.studentleadmanager.service.StudentLeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentLeadController {

    @Autowired
    StudentLeadService studentLeadService;

    @PostMapping(value = "/student-leads", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentLead> create(@RequestBody StudentLead studentLead) {
        return ResponseEntity.ok(studentLeadService.create(studentLead));
    }

    @GetMapping(value = "/student-leads", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentLead>> getAllStudentLeads() {
        return ResponseEntity.ok(studentLeadService.fetchAllStudentLeads());
    }

}
