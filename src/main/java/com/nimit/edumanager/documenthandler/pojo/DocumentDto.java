package com.nimit.edumanager.documenthandler.pojo;

import com.nimit.edumanager.documenthandler.enumeration.DocumentType;
import com.nimit.edumanager.studentmanager.entity.Student;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class DocumentDto {

    private Student student;

    private DocumentType documentType;

    private MultipartFile file;

}
