package com.nimit.edumanager.studentleadmanager.service;

import com.nimit.edumanager.studentleadmanager.entity.StudentLead;
import com.nimit.edumanager.studentleadmanager.repository.StudentLeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentLeadService {

    @Autowired
    StudentLeadRepository studentLeadRepository;

    public StudentLead create(StudentLead studentLead) {
        return studentLeadRepository.save(studentLead);
    }

    public List<StudentLead> fetchAllStudentLeads() {
        return studentLeadRepository.findAll();
    }

}
