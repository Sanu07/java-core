package com.LLD.kvstore;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache();
        lruCache.put("1", "One");
        System.out.println(lruCache.get("1"));
        lruCache.put("2", "Two");
        System.out.println(lruCache.get("2"));
        System.out.println(lruCache.get("1"));

        List<Employee> employees = new ArrayList<>();
        employees.add(Employee.builder().id(1).name("e-2").salary(BigDecimal.valueOf(10L)).build());
        employees.add(Employee.builder().id(2).name("e-1").salary(BigDecimal.valueOf(10L)).build());
        employees.add(Employee.builder().id(3).name("e-3").salary(BigDecimal.valueOf(30L)).build());

        List<Employee> sortBySalaryAndName = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary)
                        .thenComparing(Employee::getName).reversed())
                .collect(Collectors.toList());
        System.out.println(sortBySalaryAndName);

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return a.getKey().compareTo(b.getKey());
            } else {
                return b.getValue() - a.getValue();
            }
        });
        Map<String, Integer> countMap = Map.of("Alice", 11, "Andrew", 33, "Charlie", 33);
        pq.addAll(countMap.entrySet());

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
