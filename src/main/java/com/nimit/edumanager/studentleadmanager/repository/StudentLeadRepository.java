package com.nimit.edumanager.studentleadmanager.repository;

import com.nimit.edumanager.studentleadmanager.entity.StudentLead;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@EntityScan(basePackageClasses = StudentLead.class)
public interface StudentLeadRepository extends JpaRepository<StudentLead, Long> {
}
