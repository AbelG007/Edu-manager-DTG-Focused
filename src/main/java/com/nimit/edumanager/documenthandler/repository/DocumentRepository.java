package com.nimit.edumanager.documenthandler.repository;

import com.nimit.edumanager.documenthandler.entity.Document;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@EntityScan(basePackageClasses = Document.class)
public interface DocumentRepository extends JpaRepository<Document, Long> {

}
