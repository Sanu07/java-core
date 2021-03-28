package com.java.solution;

import java.util.List;

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
		//#5
		printNameInUppercase();
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
   