package com.nimit.edumanager.feemanager.repository;

import com.nimit.edumanager.feemanager.entity.Payment;
import com.nimit.edumanager.studentmanager.entity.Student;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EntityScan(basePackageClasses = Payment.class)
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStudent(Student student);
}
