package com.LLD.reportgenerator;

import java.util.List;
import java.util.Map;

public interface ReportDataSource {
    List<Map<String, Object>> fetchData();
}
