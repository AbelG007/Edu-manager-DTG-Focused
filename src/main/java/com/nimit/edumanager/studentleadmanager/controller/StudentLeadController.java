package com.nimit.edumanager.studentleadmanager.controller;

import com.nimit.edumanager.studentleadmanager.exception.StudentLeadNotFoundException;
import com.nimit.edumanager.studentleadmanager.entity.StudentLead;
import com.nimit.edumanager.studentleadmanager.service.StudentLeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<StudentLead>> getAllStudentLead() {
        return ResponseEntity.ok(studentLeadService.getAllStudentLeads());
    }

    @GetMapping(value = "/student-leads/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentLead> getStudentLeadById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(studentLeadService.getStudentLeadById(id));
        } catch (StudentLeadNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping(value = "/student-leads/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentLead> update(@PathVariable Long id, @RequestBody StudentLead studentLead) {
        try {
            return ResponseEntity.ok(studentLeadService.update(id, studentLead));
        } catch (StudentLeadNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
