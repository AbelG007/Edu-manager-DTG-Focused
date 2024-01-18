package com.nimit.edumanager.studentmanager.repository;

import com.nimit.edumanager.studentmanager.entity.Student;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@EntityScan(basePackageClasses = Student.class)
public interface StudentRepository extends JpaRepository<Student, Long> {
}
