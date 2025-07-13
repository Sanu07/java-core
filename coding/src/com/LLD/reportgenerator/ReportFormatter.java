package com.LLD.reportgenerator;

import java.util.List;
import java.util.Map;

public interface ReportFormatter {
    String format(List<Map<String, Object>> data);
}
