package com.company.flipkart;

import java.util.List;

public class Employee {
	private int id;
	private String name;
	private int salary;
	private int rating;
	private List<Integer> reportingTo;
	private List<Integer> reportingBy;
	private boolean isEligible;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public List<Integer> getReportingTo() {
		return reportingTo;
	}

	public void setReportingTo(List<Integer> reportingTo) {
		this.reportingTo = reportingTo;
	}

	public List<Integer> getReportingBy() {
		return reportingBy;
	}

	public void setReportingBy(List<Integer> reportingBy) {
		this.reportingBy = reportingBy;
	}

	public boolean isEligible() {
		return isEligible;
	}

	public void setEligible(boolean isEligible) {
		this.isEligible = isEligible;
	}

	public Employee(String name, List<Integer> reportingTo,
			List<Integer> reportingBy, int salary, int rating, boolean isEligible) {
		this.name = name;
		this.reportingTo = reportingTo;
		this.reportingBy = reportingBy;
		this.salary = salary;
		this.rating = rating;
		this.isEligible = isEligible;
	}
	
	public static boolean isValidEmployee(Employee employee){
		if(isNullOrEmptyString(employee.name)){
			return true;
		}
		return false;
	}
	
	private static boolean isNullOrEmptyString(String temp){
		if(temp == null){
			return false;
		}else if ("".equalsIgnoreCase(temp)){
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Employee [Emp Id=" + id + ", Name=" + name + ", Salary=" + salary
				+ ", Rating=" + rating + ", ReportingTo=" + reportingTo
				+ ", ReportingBy=" + reportingBy +"]";
	}
	
	/*private static String isEligibe(Employee E) {
		Map<Integer, Employee> empMap = getLevelOfEmployee(E);
		return "true";
	}

	private static Map<Integer, Employee> getLevelOfEmployee(Employee e) {
		return null;
	}*/
}
