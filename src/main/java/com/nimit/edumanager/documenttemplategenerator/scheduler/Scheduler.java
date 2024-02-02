package com.nimit.edumanager.documenttemplategenerator.scheduler;

import com.itextpdf.text.DocumentException;
import com.nimit.edumanager.documenttemplategenerator.service.GenerateTrainerPaySlipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

@Component
@Slf4j
public class Scheduler {

    @Autowired
    GenerateTrainerPaySlipService generateTrainerPaySlipService;

    @Scheduled(fixedRateString = "60000")
    public void PayslipGenerator() throws DocumentException, FileNotFoundException {
        generateTrainerPaySlipService.generatePayslipsForTrainers();
        log.info("Payslip generation task completed successfully");
    }

}
