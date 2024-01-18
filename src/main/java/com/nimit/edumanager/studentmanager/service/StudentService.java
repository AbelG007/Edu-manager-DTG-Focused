package com.nimit.edumanager.studentmanager.service;

import com.nimit.edumanager.studentmanager.entity.Student;
import com.nimit.edumanager.studentmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student create(Student student) {
        return studentRepository.save(student);
    }
}
