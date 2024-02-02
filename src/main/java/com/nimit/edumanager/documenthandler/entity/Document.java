package com.nimit.edumanager.documenthandler.entity;

import com.nimit.edumanager.documenthandler.enumeration.DocumentType;
import com.nimit.edumanager.studentmanager.entity.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    public Student student;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "document_type")
    private DocumentType documentType;

    @Column(name = "document_name")
    private String documentName;

    /*@Transient
    private MultipartFile multipartFile;*/

    @Lob
    @Column(name = "file", length = 10485760)
    private byte[] file;

}
