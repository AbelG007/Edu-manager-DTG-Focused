package com.nimit.edumanager.documenttemplategenerator.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Scheduler {
    @Scheduled(fixedRateString = "60000")
    public void PayslipGeneratorTask() {
        log.info("Payslip generation task completed successfully");
    }

}