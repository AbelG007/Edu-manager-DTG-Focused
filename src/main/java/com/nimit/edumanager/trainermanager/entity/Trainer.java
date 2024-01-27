package com.nimit.edumanager.trainermanager.entity;

import com.nimit.edumanager.trainermanager.enumeration.TrainerType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "trainer")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type")
    private TrainerType type;

    @Column(name = "joining_date")
    private Date joiningDate;

    @Column(name = "termination_date")
    private Date terminationDate;

    @Column(name = "experience")
    private Integer experience;

    @Column(name = "salary")
    private Integer salary;

}
