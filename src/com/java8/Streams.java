package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Comparator, Collectors, Streams, parallelStream
// mapToInt, collect, limit, filter, sorted, map, findFirst().orElse(0);

public class Streams {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Dan", 23),
				new Person("Laura", 22),
				new Person("Billy", 50),
				new Person("George", 21)
		);

		List<String> namesSortedByAge =
				people.stream()
				.filter(p -> p.getAge() > 22)
				.sorted(Comparator.comparing(Person::getAge).reversed())
				.map(Person::getName)
				.limit(2)
				.collect(Collectors.toList());

		System.out.println("stream : " + namesSortedByAge);

		List<Person> filteredPeople = new ArrayList<Person>();
			people.forEach(p -> {
			if (p.getAge() > 22) {
				filteredPeople.add(p);
			}
		});
		Collections.sort(filteredPeople, (a, b) -> b.getAge().compareTo(a.getAge()));
		List<String> namesSortedByAgeForEach = new ArrayList<String>();
		filteredPeople.forEach(p -> namesSortedByAgeForEach.add(p.getName()));
		System.out.println("forEach : " + namesSortedByAgeForEach);
		
		
		boolean areAllPeopleOlderThan20 = people.parallelStream().allMatch(p -> p.getAge() > 20);
		boolean areNoPeopleOlderThan20 = people.parallelStream().noneMatch(p -> p.getAge() > 20);
		boolean areAnyPeopleOlderThan20 = people.parallelStream().anyMatch(p -> p.getAge() > 20);
		
		int totalOfAges = people.stream().mapToInt(Person::getAge).sum();
	}
	
	private static class Person {
		private Integer age;
		private String name;
		
		public Person(final String name, Integer age) {
			this.name = name;
			this.age = age;
		}

		public Integer getAge() {
			return this.age;
		}

		public String getName() {
			return name;
		}
	}
}