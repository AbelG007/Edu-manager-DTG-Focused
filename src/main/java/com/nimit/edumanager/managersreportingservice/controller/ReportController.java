package com.nimit.edumanager.managersreportingservice.controller;

import com.nimit.edumanager.managersreportingservice.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {
    @Autowired
    ReportService reportService;

    @GetMapping("/students/active")
    public Integer getAllActiveStudentsCount() {
        return reportService.getAllActiveStudentsCount();
    }

}
