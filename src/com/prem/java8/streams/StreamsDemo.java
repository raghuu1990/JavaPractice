package com.prem.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsDemo {

	public StreamsDemo() {
		Customer prem = new Customer(1, "Prem");
		Customer empty = new Customer(2, "");
		Customer kumar = new Customer(3, "Kumar");
		Customer bharti = new Customer(4, "Bharti");
		Customer gaurav = new Customer(5, "Gaurav");
		Customer nulla = new Customer(6, null);

		customers.add(prem);
		customers.add(empty);
		customers.add(kumar);
		customers.add(bharti);
		customers.add(gaurav);
		customers.add(nulla);
	}

	private static List<Customer> customers = new ArrayList<>();
	private static final Predicate<Customer> notEmpty = (customer) -> null != customer.getName()
			&& customer.getName().length() > 0;
	private static final Predicate<Customer> empty = (customer) -> null == customer.getName()
			|| customer.getName().length() == 0;

	public static void main(String[] args) {
		StreamsDemo demo = new StreamsDemo();
		// System.out.println(demo.filterEmptyNames(customers));
		customers = demo.mapEmptyByDefaultValue(customers);
		System.out.println(customers);

	}

	public List<Customer> filterEmptyNames(List<Customer> customers) {
		return customers.stream().filter(notEmpty).collect(Collectors.toList());
	}

	public List<Customer> mapEmptyByDefaultValue(List<Customer> names) {
		return names.stream().filter(empty).map(customer -> new Customer(customer.getId(), "Anonymous"))
				.collect(Collectors.toList());
	}

}

class Customer {
	private int id;
	private String name;

	public Customer() {
	}

	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer{" + "id=" + id + ", name='" + name + '\'' + '}';
	}
}