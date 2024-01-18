package com.nimit.edumanager.sessionmanager.repository;

import com.nimit.edumanager.sessionmanager.entity.Session;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@EntityScan(basePackageClasses = Session.class)
public interface SessionRepository extends JpaRepository<Session, Long> {
}