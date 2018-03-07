package com.company.flipkart.cab;

public class Trip {
	String tripId;
	String custName;
	Cab cab;
	String city1;
	String city2;
	boolean completed;

	public Trip(String custName, Cab cab, String city1, String city2, boolean completed) {
		this.custName = custName;
		this.cab = cab;
		this.city1 = city1;
		this.city2 = city2;
		this.completed = completed;
	}

	public String getTripId() {
		return tripId;
	}

	public void setTripId(String tripId) {
		this.tripId = tripId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public String getCity1() {
		return city1;
	}

	public void setCity1(String city1) {
		this.city1 = city1;
	}

	public String getCity2() {
		return city2;
	}

	public void setCity2(String city2) {
		this.city2 = city2;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
}