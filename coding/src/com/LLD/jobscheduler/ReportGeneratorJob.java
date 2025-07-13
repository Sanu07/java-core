package com.LLD.jobscheduler;

public class ReportGeneratorJob implements Job {
    @Override
    public void execute(String content) {
        System.out.println("Report generated " + content);
    }
}
