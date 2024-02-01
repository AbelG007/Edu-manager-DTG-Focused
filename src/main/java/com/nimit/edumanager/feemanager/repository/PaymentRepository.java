package com.nimit.edumanager.feemanager.repository;

import com.nimit.edumanager.feemanager.entity.Payment;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@EntityScan(basePackageClasses = Payment.class)
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

