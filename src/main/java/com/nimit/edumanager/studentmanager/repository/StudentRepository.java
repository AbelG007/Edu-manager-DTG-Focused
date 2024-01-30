package com.nimit.edumanager.studentmanager.repository;

import com.nimit.edumanager.studentmanager.entity.Student;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EntityScan(basePackageClasses = Student.class)
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByEndDateNull();
}
