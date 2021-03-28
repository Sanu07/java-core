package com.java.methodreference;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class MethodReference {
	public static void main(String[] args) {
		Thread t = new Thread(MethodReference::findEvenNumbers);
		t.start();
		Thread t2 = new Thread(MethodReference::groupStudentsByAge);
		t2.start();
		ProcessStudentsDataImpl processData = new ProcessStudentsDataImpl();
		processData.processData(new Student());
	}

	public static void findEvenNumbers() {
		List<Integer> numbers = Arrays.asList(12, 45, 12, 3, 45, 56, 46, 67);
		numbers.parallelStream().filter(i -> i % 2 == 0).forEach(System.out::println);
	}

	public static void groupStudentsByAge() {
		Set<Student> students = new HashSet<>();
		students.add(new Student(11, "John", 14));
		students.add(new Student(22, "Smith", 14));
		students.add(new Student(33, "David", 15));
		Map<Integer, List<Student>> studentsMap = students.parallelStream()
				.collect(Collectors.groupingBy(Student::getAge));
		System.out.println(studentsMap);
	}

	public static Student checkStudentPassCriteria(Student student) {
		ProcessStudentData studentData = (Student s) -> {
			return !ProcessStudentData.validateName(s).getName().isEmpty();
		};
		System.out.println(studentData.validateAge(student));
		return student;
	}
}

@FunctionalInterface
interface ProcessStudentData {

	int test = 0;
	String name = "";

	boolean processData(Student student);

	default boolean validateAge(Student student) {
		return student.getAge() > 0;
	}

	static Student validateName(Student student) {
		return Optional.of(student).orElse(new Student(1, "Default", 10));
	}
}

interface Interface1 {
	default void show() {
		System.out.println("Interface 1");
	}
}

interface Interface2 {
	default void show() {
		System.out.println("Interface 2");
	}
}

class InterfacesImpl implements Interface1, Interface2 {

	public static void main(String[] args) {
		InterfacesImpl impl = new InterfacesImpl();
		impl.show();
	}
	
	@Override
	public void show() {
		Interface1.super.show();
	}
	
}

class ProcessStudentsDataImpl implements ProcessStudentData {

	@Override
	public boolean processData(Student student) {
		ProcessStudentsDataImpl studentData = new ProcessStudentsDataImpl();
		System.out.println(student);
		System.out.println("::::::Validating age::::::");
		studentData.validateAge(student);
		System.out.println("::::::Validating Name::::::");
		ProcessStudentData.validateName(student);
		return true;
	}

}

class Student {
	private int rollNo;

	public int getRollNo() {
		return rollNo;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	private String name;
	private int age;

	public Student() {
		super();
	}

	public Student(int rollNo, String name, int age) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + rollNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rollNo != other.rollNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", age=" + age + "]";
	}

}