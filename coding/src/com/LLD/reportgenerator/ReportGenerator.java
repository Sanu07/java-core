package com.LLD.reportgenerator;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReportGenerator {
    private final ReportFormatter formatter;
    private final ReportDataSource dataSource;
    private final ReportWriter writer;

    public ReportGenerator(ReportFormatter formatter, ReportDataSource dataSource, ReportWriter writer) {
        this.formatter = formatter;
        this.dataSource = dataSource;
        this.writer = writer;
    }

    public void generateReport(String filePath) throws IOException {
        List<Map<String, Object>> data = dataSource.fetchData();
        String content = formatter.format(data);
        writer.writeToFile(content, filePath);
        System.out.println("Report written to: " + filePath);
    }
}
