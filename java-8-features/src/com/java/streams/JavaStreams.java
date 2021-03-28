package com.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {
	

static List<Person> persons =
    Arrays.asList(
        new Person("Max", 18),
        new Person("Peter", 23),
        new Person("Pamela", 23),
        new Person("David", 12));
	
	public static void main(String[] args) {
		reuseStreams();
		collect1();
		flatMap1();
		parallelSum();
	}

	private static void parallelSum() {
		long start = System.currentTimeMillis();
		System.out.println(
				IntStream.rangeClosed(1, 100000000).sum()
				);
		System.out.println("Time Taken Sequence " + (System.currentTimeMillis() - start) + "ms");
		start = System.currentTimeMillis();
		System.out.println(
				IntStream.rangeClosed(1, 100000000).parallel().sum()
				);
		System.out.println("Time Taken Parallel " + (System.currentTimeMillis() - start) + "ms");
	}

	private static void flatMap1() {
		List<List<Integer>> numbers = Arrays.asList(
				Arrays.asList(1, 2, 3),
				Arrays.asList(4, 5, 6),
				Arrays.asList(7, 8, 9));
		System.out.println(numbers.stream().flatMap(List::stream).collect(Collectors.toList()));
	}

	private static void collect1() {
		List<Person> persons = JavaStreams.persons
				.parallelStream()
				.filter(p -> p.getName().startsWith("P"))
				.collect(Collectors.toList());
		System.out.println(persons);
	}

	private static void reuseStreams() {
		Supplier<Stream<String>> s2 = () -> Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> s.startsWith("a"));
		System.out.println(s2.get().anyMatch(s -> s.startsWith("a")));
		System.out.println(s2.get().anyMatch(s -> s.startsWith("A")));
	}
}

class Person {
	private int age;
	private String name;

	public Person(String name, int age) {
		super();
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
}