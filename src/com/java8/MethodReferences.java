package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

// Supplier<Collection<Integer>>, Collection

// () -> System.out.println("Zero parameter lambda");
// One parameter: (p) -> System.out.println("One parameter: " + p);
// It is not mandatory to use parentheses, if the type of that variable can be inferred from the context
// Multiple parameters : (p1, p2) -> System.out.println("Multiple parameters: " + p1 + ", " + p2);



public class MethodReferences {
	public static void main(String args[]) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		list.forEach(MethodReferences::print);
		list.forEach(number -> MethodReferences.print(number));
		for (int number : list) {
			MethodReferences.print(number);
		}

		final MyComparator myComparator = new MyComparator();
		Collections.sort(list, myComparator::compare);
		Collections.sort(list, (a, b) -> myComparator.compare(a, b));

		
        final List<Person> people = Arrays.asList(new Person("dan"), new Person("laura"));
        people.forEach(Person::printName);
        people.forEach(person -> person.printName());
        for (final Person person : people) {
            person.printName();
        }
        
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        copyElements(list, ArrayList<Integer>::new);
        copyElements(list, () -> new ArrayList<Integer>());
        copyElements(list, () -> list2);
        
        Runnable runnable = () -> System.out.println("I have implemented Runnable");
        runnable.run();
        System.out.println("DONE");
	

        final int number = 4;
        final Supplier <Boolean> computeResult = () -> compute(number);
        final Supplier <Boolean> processResult = () -> process(number);
        if (computeResult.get() && processResult.get()) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
        
        
        final Stream<Integer> stream = list.stream().
        		filter(MethodReferences::compute).
        		filter(MethodReferences::process);

        final int result = stream.findFirst().orElse(0);
        System.out.println("THE RESULT IS : " + result);
    }

    public static boolean compute(final int number) {
        return number > 5 ? true : false;
    }

    public static boolean process(final int number) {
        return number % 3 == 0 ? true : false;
    }

    private static void copyElements(final List<Integer> list, 
    		final Supplier<Collection<Integer>> targetCollection) {
        list.forEach(targetCollection.get()::add);
        
        targetCollection.get().forEach(System.out::print);
        System.out.println("DONE");
    }
    
	public static void print(final int number) {
		System.out.println("I am printing: " + number);
	}

	private static class MyComparator {
		public int compare(final Integer a, final Integer b) {
			return a.compareTo(b);
		}
	}

	private static class Person {
		private String name;
		public Person(final String name) {
			this.name = name;
		}

		public void printName() {
			System.out.println(name);
		}
	}
}