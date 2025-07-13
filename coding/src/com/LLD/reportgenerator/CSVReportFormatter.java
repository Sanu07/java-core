package com.LLD.reportgenerator;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CSVReportFormatter implements ReportFormatter {
    @Override
    public String format(List<Map<String, Object>> data) {
        if (data == null || data.isEmpty()) return "";

        StringBuilder builder = new StringBuilder();

        // Headers
        Set<String> headers = data.get(0).keySet();
        builder.append(String.join(",", headers)).append("\n");

        // Rows
        for (Map<String, Object> row : data) {
            for (String header : headers) {
                builder.append(row.getOrDefault(header, "")).append(",");
            }
            builder.deleteCharAt(builder.length() - 1); // remove trailing comma
            builder.append("\n");
        }

        return builder.toString();
    }
}
