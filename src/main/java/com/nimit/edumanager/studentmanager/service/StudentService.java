package com.nimit.edumanager.studentmanager.service;

import com.nimit.edumanager.studentmanager.entity.Student;
import com.nimit.edumanager.studentmanager.repository.StudentRepository;
import com.nimit.edumanager.managersreportingservice.entity.Student;
import com.nimit.edumanager.managersreportingservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student create(Student student) {
        return studentRepository.save(student);}
    public List<Student> getAllActiveStudents() {
        return studentRepository.findByEndDateNull();
    }

}
