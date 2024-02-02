package com.nimit.edumanager.feemanager.entity;

import com.nimit.edumanager.feemanager.enumeration.PaymentMode;
import com.nimit.edumanager.studentmanager.entity.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "pay_date")
    private Date payDate;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "payment_mode")
    private PaymentMode paymentMode;

}




