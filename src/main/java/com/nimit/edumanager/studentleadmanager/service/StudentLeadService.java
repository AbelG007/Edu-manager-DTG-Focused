package com.nimit.edumanager.studentleadmanager.service;

import com.nimit.edumanager.studentleadmanager.exception.StudentLeadNotFoundException;
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

    public List<StudentLead> getAllStudentLeads() {
        return studentLeadRepository.findAll();
    }

    public StudentLead getStudentLeadById(Long id) throws StudentLeadNotFoundException {
        return studentLeadRepository.findById(id).orElseThrow(() -> new StudentLeadNotFoundException("Student with id" + id + "not found"));
    }

    public StudentLead update(Long id, StudentLead studentLead) throws StudentLeadNotFoundException {
        StudentLead studentLeadFromDb = getStudentLeadById(id);
        studentLeadFromDb.setFirstName(studentLead.getFirstName());
        studentLeadFromDb.setLastName(studentLead.getLastName());
        studentLeadFromDb.setContactNumber(studentLead.getContactNumber());
        studentLeadFromDb.setEmail(studentLead.getEmail());
        studentLeadFromDb.setDateOfEnquiry(studentLead.getDateOfEnquiry());
        studentLeadFromDb.setQualification(studentLead.getQualification());
        studentLeadFromDb.setSource(studentLead.getSource());
        studentLeadFromDb.setStatus(studentLead.getStatus());
        studentLeadFromDb.setComments(studentLead.getComments());
        studentLeadFromDb.setNextCallDate(studentLead.getNextCallDate());
        return studentLeadRepository.save(studentLeadFromDb);
    }

}
