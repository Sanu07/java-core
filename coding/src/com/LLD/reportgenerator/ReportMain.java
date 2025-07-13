package com.LLD.reportgenerator;

import java.io.IOException;

public class ReportMain {
    public static void main(String[] args) throws IOException {
        ReportFormatter formatter = new CSVReportFormatter();  // You can swap this for Excel, PDF, etc.
        ReportDataSource dataSource = new SampleDataSource();
        ReportWriter writer = new ReportWriter();

        ReportGenerator generator = new ReportGenerator(formatter, dataSource, writer);
        generator.generateReport("report.csv");
    }
}
