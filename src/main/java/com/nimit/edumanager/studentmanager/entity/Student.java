package com.nimit.edumanager.studentmanager.entity;

import com.nimit.edumanager.studentmanager.enumeration.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "contact_number")
    private Integer contactNumber;

    @Column(name = "email")
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    @Column(name = "dob")
    private Date dateOfBirth;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "qualification")
    private String qualification;
    @Column(name = "course")
    private String course;
    @Column(name = "total_fee")
    private Integer totalFee;
    @Column(name = "balance_fee")
    private Integer balanceFee;


}
