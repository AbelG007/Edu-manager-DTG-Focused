package com.nimit.edumanager.managersreportingservice.service;

import com.nimit.edumanager.managersreportingservice.entity.Student;
import com.nimit.edumanager.studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReportService {

    @Autowired
    StudentService studentService;

    public Integer getAllActiveStudentsCount() {
        List<Student> studentList = studentService.getAllActiveStudents();
        return studentList.size();
    }

}
