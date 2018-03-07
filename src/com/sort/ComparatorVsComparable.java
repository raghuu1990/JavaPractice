package com.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// TODO 
public class ComparatorVsComparable {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		List<StudentComparable> list1 = new ArrayList<StudentComparable>();
		List<StudentComparator> list2 = new ArrayList<StudentComparator>();
		
		// Collections.sort(list, new ComparatorChecker<StudentComparator>());
		Collections.sort(list1);
		// Collections.sort(list2, new ComparatorChecker<StudentComparator>());
		
		Student[] arr = new Student[5];
		StudentComparable[] arr1 = new StudentComparable[5];
		StudentComparator[] arr2 = new StudentComparator[5];

		Arrays.sort(arr);
		Arrays.sort(arr2);
		Arrays.sort(arr2);
		
		Arrays.sort(arr, 0, arr.length, Collections.reverseOrder(new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				if (!s2.cgpa.equals(s1.cgpa)) {
					return s2.cgpa.compareTo(s1.cgpa);
				} else if (!s2.name.equals(s1.name)) {
					return s1.name.compareTo(s2.name);
				}
				return s2.id.compareTo(s1.id);
			}
		}));
	}
}

class ComparatorChecker implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
		if (!s2.cgpa.equals(s1.cgpa)) {
			return s2.cgpa.compareTo(s1.cgpa);
		} else if (!s2.name.equals(s1.name)) {
			return s1.name.compareTo(s2.name);
		}
		return s2.id.compareTo(s1.id);
	}
}

class ComparableChecker implements Comparable<Student> {
	@Override
	public int compareTo(Student o) {
		return 0;
	}
}

class Student {
	Integer id;
	String name;
	Double cgpa;

	Student(int id, String name, double cgpa) {
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}

	public String getName() {
		return name;
	}
}

class StudentComparable implements Comparable<StudentComparable> {
	Integer id;
	String name;
	Double cgpa;

	StudentComparable(int id, String name, double cgpa) {
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(StudentComparable s) {
		if (!s.cgpa.equals(this.cgpa)) {
			return s.cgpa.compareTo(this.cgpa);
		} else if (!s.name.equals(this.name)) {
			return this.name.compareTo(s.name);
		}
		return s.id.compareTo(this.id);
	}
}

class StudentComparator implements Comparator<StudentComparator> {
	Integer id;
	String name;
	Double cgpa;

	StudentComparator(int id, String name, double cgpa) {
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compare(StudentComparator s1, StudentComparator s2) {
		if (!s2.cgpa.equals(s1.cgpa)) {
			return s2.cgpa.compareTo(s1.cgpa);
		} else if (!s2.name.equals(s1.name)) {
			return s1.name.compareTo(s2.name);
		}
		return s2.id.compareTo(s1.id);
	}
}