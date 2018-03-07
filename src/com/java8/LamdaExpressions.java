package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

// https://dzone.com/articles/a-little-lambda-tutorial

// Using a lambda expression first requires a functional interface that contains a method 
// that it will override. The are many classes that are already built into Java that can be
// used as a functional interface, such as Runnable and Comparator.

// The lambda expression is made of two parts the one on the left of the arrow symbol (->) 
// listing its parameters and the one on the right containing its body.
// Method references are a feature of Java 8. They are effectively a subset of lambda expressions, 
// Optional is a wrapper of a value that can potentially doesn't exist at all. 
// You can create a Stream from any Collection by invoking the new stream() method on it

public class LamdaExpressions {

	static Function<Integer, Integer> addOne = x -> x + 1;
	static Function<String, String> concat = x -> x + 1;
	static Function<Integer, Boolean> checkEven = LamdaExpressions::isEven;
	Function<Integer, Function<Integer, Integer>> makeAdder = x -> y -> x + y;
	Function<Integer, Function<Integer, Integer>> makeAdder2 = LamdaExpressions::makeAdder1;
	public static Function<Integer, Integer> makeAdder1(Integer x) {
		return y -> x + y;
	}

	Function<Integer,Integer> add1 = makeAdder.apply(1);
	
	static Function<Integer,Integer> add11 = x -> x + 1;

	static Function<Integer,Integer> mul3 = x -> x * 3;
	static BinaryOperator<Integer> sum = (a,b) -> a + b;
	
	// Lambda expressions can also be passed in as inputs into methods that require a functional interface as one of their parameters.
	static Comparator<String> comparator = (a,b) -> a.compareTo(b);  
	
	public static void main(String[] args) {
		System.out.println(sum.apply(1,2));
		Integer res = mul3.apply(add11.apply(1)); //yields 33
		System.out.println(res);
		Integer two = addOne.apply(1); //yields 2
		System.out.println(two);
		String answer = concat.apply("0 + 1 = "); //yields "0 + 1 = 1"
		System.out.println(answer);
		
		// int [] arr = {1,2,3,4,5};
		Integer[] arr = { 1, 2, 3, 4, 5 };
		List<Integer> list = new ArrayList<Integer>();
		list = Arrays.asList(arr);
		
		list.forEach((Integer value) -> System.out.print(value));
		System.out.println();
		
		list.forEach(value -> System.out.print(value));
		System.out.println();
		
		list.forEach(System.out::print);
		System.out.println();
		
		list.forEach(new Consumer<Integer>() {
			public void accept(Integer value) {
				System.out.print(value);
			}
		});
		System.out.println();

		sumAll(list, n -> true);
		sumAll(list, n -> n % 2 == 0);
		sumAll(list, n -> n > 3);

		System.out.println();
		
		System.out.println(
				list.stream()
				.filter(LamdaExpressions::isEven)
				//.filter(n -> n % 2 == 0)
				.map(LamdaExpressions::doubleIt)
				.filter(LamdaExpressions::isGreaterThan5)
				.findFirst().get());
	
	
		// Anonymous class
		
		Runnable runnable = () -> System.out.println("I have implemented Runnable");
		runnable.run();
		
		Collections.sort(list, (a,b) -> { return a.compareTo(b); });
	}

	public static int sumAll(List<Integer> numbers, Predicate<Integer> p) {
		int total = 0;
		for (int number : numbers) {
			if (p.test(number)) {
				total += number;
			}
		}
		return total;
	}

	public int sumAllEven(List<Integer> numbers) {
		int total = 0;
		for (int number : numbers) {
			if (number % 2 == 0) {
				total += number;
			}
		}
		return total;
	}

	public static boolean isEven(int number) {
		return number % 2 == 0;
	}

	public static int doubleIt(int number) {
		return number * 2;
	}

	public static boolean isGreaterThan5(int number) {
		return number > 5;
	}
}