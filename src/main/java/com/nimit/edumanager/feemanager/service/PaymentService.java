package com.nimit.edumanager.feemanager.service;

import com.nimit.edumanager.feemanager.entity.Payment;
import com.nimit.edumanager.feemanager.repository.PaymentRepository;
import com.nimit.edumanager.studentmanager.entity.Student;
import com.nimit.edumanager.studentmanager.exception.StudentNotFoundException;
import com.nimit.edumanager.studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    StudentService studentService;

    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPaymentsByStudentId(Long studentId) throws StudentNotFoundException {
        Student student = studentService.getStudentById(studentId);
        return getAllPaymentsByStudent(student);
    }

    public List<Payment> getAllPaymentsByStudent(Student student) {
        return paymentRepository.findByStudent(student);
    }

}
