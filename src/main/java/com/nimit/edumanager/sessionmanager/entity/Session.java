package com.nimit.edumanager.sessionmanager.entity;

import com.nimit.edumanager.common.enumeration.Course;
import com.nimit.edumanager.sessionmanager.enumeration.SessionStatus;
import com.nimit.edumanager.trainermanager.entity.Trainer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "course")
    private Course course;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private SessionStatus status;

}
