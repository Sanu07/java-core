package com.java.solution;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

	static List<Employee> employees = EmployeeUtil.getEmployees();
	public static void main(String[] args) {
		// #1
		// countAllEmployees();
		// #2
		// printDistinctEmployees();
		// #3
		// increaseSalary();
		// #4
		// printFirstName();
		// #5
		// printNameInUppercase();
		// #6
		// sortOrgByJoiningDate();
		// #7
		// findDurationInFirstOrg();
		// #8
		// printEmpWithSameDigitsZipcode();
		// #9
		// printEmpWithSameAddress();
		// #10
		// groupEmpByCountry();
		// #11
		// countEmpInEveryCountry();
		// #12
		// printEmpByname();
		// #13
		// printEmpByZip();
		// #14
		printEmpByJoiningDate();
		// #15
		// findEmpInTCS();
		// #16
		// findEmpWithFirstOrgAsCTS();
		// #17
		// findEmpWithDOJAfter2015();
		// #18
		// arrangeEmpByJoiningDate();
		// #19
		// sumOfSalariesInTCS();
		// #20
		// findMinMaxSalaries();
		// #21
		// findEmpWithSameLastname();
		// #22
		// findEmpInOrgThatContainsC();
	}

	private static void findMinMaxSalaries() {
		Map<String, LongSummaryStatistics> empsSalary = employees.stream().distinct()
		.collect(Collectors.groupingBy(e -> ((Employee) e).getAddress().getCountry(), Collectors.summarizingLong(e -> e.getSalary())));
		for (Map.Entry<String, LongSummaryStatistics> map: empsSalary.entrySet()) {
			System.out.println(map.getKey() + " [MIN -> " + map.getValue().getMin() + " MAX -> " + map.getValue().getMax() + "]");
		}
		
	}

	private static void findEmpInOrgThatContainsC() {
		employees.stream().filter(e -> e.getOrgs().stream().anyMatch(o -> o.getName().contains("C")))
			.forEach(System.out::println);
	}

	private static void findEmpWithSameLastname() {
		employees.stream().collect(Collectors.groupingBy(Employee::getLastName, Collectors.counting()))
			.entrySet().stream().filter(e -> e.getValue() > 1L)
			.forEach(System.out::println);
	}

	private static void sumOfSalariesInTCS() {
		Long sum = employees.stream().filter(e -> {
			e.getOrgs().stream().sorted((o1, o2) -> o1.getJoiningDate().compareTo(o2.getJoiningDate()));
			return e.getOrgs().stream().skip(1L).anyMatch(o -> ((Organization) o).getName().contains("TCS"));
		}).collect(Collectors.summingLong(Employee::getSalary));
		System.out.println("Total Sum of Salaries for Emps working in TCS " + sum);
	}

	private static void arrangeEmpByJoiningDate() {
		employees.stream().distinct().flatMap(e -> e.getOrgs().stream()).sorted(Comparator.comparing(Organization::getJoiningDate))
		.forEach(System.out::println);
	}

	private static void findEmpWithDOJAfter2015() {
		employees.stream().distinct().filter(e ->
			e.getOrgs().stream().anyMatch(o -> o.getJoiningDate().isAfter(LocalDate.of(2015, 1, 1))))
		.forEach(System.out::println);
	}

	private static void findEmpWithFirstOrgAsCTS() {
		employees.stream().distinct().filter(e ->
			e.getOrgs().stream().sorted(Comparator.comparing(Organization::getJoiningDate))
			.map(Organization::getName).findFirst().orElse("").equalsIgnoreCase("CTS"))
		.forEach(System.out::println);
	}

	private static void findEmpInTCS() {
		employees.stream().filter(e ->
			e.getOrgs().stream().map(Organization::getName).anyMatch(o -> ((String) o).equalsIgnoreCase("TCS"))
		).forEach(System.out::println);
	}

	private static void countEmpInEveryCountry() {
		employees.stream().collect(Collectors.groupingBy(e -> ((Employee) e).getAddress().getCountry(), 
				Collectors.counting()))
				.forEach((k, v) -> System.out.println(k + " -> " + v));
	}

	private static void printEmpByJoiningDate() {
		employees.stream().sorted((e1, e2) -> {
			return e1.getOrgs().stream().sorted(Comparator.comparing(Organization::getJoiningDate))
			.collect(Collectors.toList()).get(0).getJoiningDate()
			.compareTo(e2.getOrgs().stream().sorted(Comparator.comparing(Organization::getJoiningDate))
			.collect(Collectors.toList()).get(0).getJoiningDate());
		})
		.forEach(System.out::println);
	}

	private static void printEmpByZip() {
		employees.stream().sorted(Comparator.comparing(e -> ((Employee) e).getAddress().getZip())).collect(Collectors.toList())
		.forEach(System.out::println);
	}

	private static void printEmpByname() {
		Collections.sort(employees, Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getSalary));
		employees.forEach(System.out::println);
	}

	private static void groupEmpByCountry() {
		Map<String, Set<String>> emps = employees.stream().collect(Collectors.groupingBy(e -> ((Employee) e).getAddress().getCountry(), 
				Collectors.mapping(Employee::getFirstName, Collectors.toSet())));
		for (Map.Entry<String, Set<String>> map : emps.entrySet()) {
			System.out.println(map.getKey() + " -> " + map.getValue());
		}
	}

	private static void printEmpWithSameAddress() {
		employees.stream().collect(Collectors.groupingBy(Employee::getAddress, Collectors.counting()))
			.entrySet().stream().filter(e -> e.getValue() > 1L)
			.forEach(System.out::println);
	}

	private static void printEmpWithSameDigitsZipcode() {
		employees.stream().distinct().filter(e -> {
			long n = e.getAddress().getZip();
			long lastDig = n % 10;
			while (n != 0) {
				if (lastDig == n % 10) {
					n = n / 10;
				} else return false;
			}
			return true;
		}).forEach(System.out::println);
	}

	private static void findDurationInFirstOrg() {
		employees.stream().distinct()
		.map(e -> e.getFirstName() + " " + 
				e.getOrgs().stream().sorted(Comparator.comparing(Organization::getJoiningDate))
				.map(e1 -> e1.getName()).limit(1)
				.collect(Collectors.joining(" "))
				+ " " + 
				e.getOrgs().stream().sorted(Comparator.comparing(Organization::getJoiningDate))
				.map(d -> d.getJoiningDate().getYear())
				.reduce(0, (d1, d2) -> d2 - d1)
				)
		.forEach(System.out::println);
	}

	private static void sortOrgByJoiningDate() {
		employees.stream().distinct()
			.map(e -> e.getFirstName() + " " + e.getLastName() + " " + 
					e.getOrgs().stream().sorted((o1, o2) -> o1.getJoiningDate().compareTo(o2.getJoiningDate()))
					.map(org -> org.getName() + " " + DateTimeFormatter.ofPattern("dd/MM/YYYY").format(org.getJoiningDate()))
					.collect(Collectors.joining(" ")))
			.forEach(System.out::println);
	}

	private static void printNameInUppercase() {
		employees.stream().map(e -> e.getFirstName() + " " + e.getLastName())
			.map(String::toUpperCase)
			.forEach(System.out::println);
	}

	private static void printFirstName() {
		employees.stream().map(Employee::getFirstName).forEach(System.out::println);
		System.out.println("------------------------------------------------------");
		employees.stream().map(e -> e.getFirstName()).forEach(System.out::println);
	}

	private static void increaseSalary() {
		employees.stream().forEach(e -> {
			e.setSalary(e.getSalary() + 10);
			System.out.println(e);
		});
	}

	private static void countAllEmployees() {
		long count = employees.parallelStream().count();
		System.out.println(count);
	}
	
	private static void printDistinctEmployees() {
		// O/P is 9 only when we override hashcode and equals for all the individual classes
		employees.stream().distinct().forEach(System.out::println);
	}

}
   