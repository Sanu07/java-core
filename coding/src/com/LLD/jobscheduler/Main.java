package com.LLD.jobscheduler;

public class Main {

    public static void main(String[] args) {
        JobScheduler jobScheduler = new JobScheduler(2);
        Job job = new ReportGeneratorJob();
        jobScheduler.schedule(1, "report-job", job, 0, 0, "Hey!!!");

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        jobScheduler.cancel("report-job");
        jobScheduler.shutdown();
    }
}
