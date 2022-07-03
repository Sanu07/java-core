package com.java.solution;

import java.util.List;

public class Solution2 {
	
	List<Employee> employees = EmployeeUtil.getEmployees();
	
	public static void main(String[] args) {
		Solution2 s2 = new Solution2();
		// s2.countAllEmployees();
		s2.checkDouble(1);
		s2.checkDouble(1.0);
		s2.checkDouble(1.0d);
	}

	public long countAllEmployees() {
		long count = employees.parallelStream().count();
		System.out.println(count);
		return count;
	}
	
	public void checkOptional() {
		employees.stream().filter(e -> e.getFirstName().equalsIgnoreCase("Zinedine")).findAny()
		.orElseThrow().getId();
	}
	
	public void checkDouble(double progress) {
		boolean b = Double.compare(progress, 1) == 0;
		System.out.println(b);
	}
}
