package com.hackerrank.worldcodesprint12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

// https://www.hackerrank.com/contests/world-codesprint-12/challenges/animal-transport/problem

public class AnimalTransport {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int a0 = 0; a0 < T; a0++) {
			int m = in.nextInt();
			int n = in.nextInt();
			char[] names = new char[n];
			for (int i = 0; i < n; i++) {
				names[i] = in.next().charAt(0);
			}
			int[] start = new int[n];
			for (int i = 0; i < n; i++) {
				start[i] = in.nextInt();
			}
			int[] end = new int[n];
			for (int i = 0; i < n; i++) {
				end[i] = in.nextInt();
			}
			int[] result = minimumZooNumbers(m, n, names, start, end);
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
			}
			System.out.println("");
		}
		in.close();
	}

	public static int[] minimumZooNumbers(int m, int n, char[] names, int[] start, int[] end) {
		PriorityQueue<Animal> endTime = new PriorityQueue<Animal>(new Comparator<Animal>() {
			public int compare(Animal a, Animal b) {
				return a.end.compareTo(b.end);
			}
		});
		PriorityQueue<Animal> startTime = new PriorityQueue<Animal>(new Comparator<Animal>() {
			public int compare(Animal a, Animal b) {
				return a.end.compareTo(b.end);
			}
		});

		int max = 0;
		for (int i = 0; i < n; i++) {
			Animal animal = new Animal(i, names[i], start[i], end[i]);
			endTime.add(animal);
			startTime.add(animal);
			max = Math.max(max, end[i]);
		}

		/*
		
		while(!endTime.isEmpty()) {
			System.out.println(endTime.poll().end);
		}
		while(!startTime.isEmpty()) {
			System.out.println(startTime.poll().start);
		}
		
		*/
		
		int[] result = new int[n];
		result[0] = endTime.peek().end;
		List<Animal> list = new ArrayList<Animal>();
		for (int i = 1; i <= max; i++) {
			Animal animal = startTime.peek();
			if(animal.start<=i) {
				addAnimalInList(list, animal);
				startTime.poll();
				endTime.remove(animal);
			}
			
			
			
			//result[i] = ;
		}
		return result;
	}
	
	public static void addAnimalInList(List<Animal> list, Animal animal) {
		
	}
}

class Animal {
	int id;
	char name;
	Integer start;
	Integer end;

	public Animal(int id, char name, int start, int end) {
		this.name = name;
		this.start = start;
		this.end = end;
	}

	public char getName() {
		return name;
	}

	public void setName(char name) {
		this.name = name;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
}