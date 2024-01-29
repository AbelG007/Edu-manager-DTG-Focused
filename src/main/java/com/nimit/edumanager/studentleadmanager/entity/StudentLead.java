package com.nimit.edumanager.studentleadmanager.entity;

import com.nimit.edumanager.studentleadmanager.enumeration.Course;
import com.nimit.edumanager.studentleadmanager.enumeration.Source;
import com.nimit.edumanager.studentleadmanager.enumeration.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "student_lead")
public class StudentLead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "date_of_enquiry")
    private Date dateOfEnquiry;

    @Column(name = "qualification")
    private String qualification;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "source")
    private Source source;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "course")
    private Course course;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "comments")
    private String comments;

    @Column(name = "next_call_date")
    private Date nextCallDate;

}
