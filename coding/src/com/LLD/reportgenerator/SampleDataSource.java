package com.LLD.reportgenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleDataSource implements ReportDataSource {
    @Override
    public List<Map<String, Object>> fetchData() {
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> row1 = new HashMap<>();
        row1.put("Name", "Alice");
        row1.put("Age", 30);
        row1.put("Department", "Engineering");

        Map<String, Object> row2 = new HashMap<>();
        row2.put("Name", "Bob");
        row2.put("Age", 25);
        row2.put("Department", "HR");

        list.add(row1);
        list.add(row2);

        return list;
    }
}
