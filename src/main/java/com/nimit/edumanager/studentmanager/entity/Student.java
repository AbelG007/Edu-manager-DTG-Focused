package com.nimit.edumanager.studentmanager.entity;

import com.nimit.edumanager.common.enumeration.Course;
import com.nimit.edumanager.studentmanager.enumeration.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "student")
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
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "qualification")
    private String qualification;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "course")
    private Course course;

    @Column(name = "total_fee")
    private Integer totalFee;

    @Column(name = "balance_fee")
    private Integer balanceFee;

}
