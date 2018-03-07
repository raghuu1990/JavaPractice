package com.company.flipkart.cab;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cab {
	String name;
	State state;
	String currentCity;
	Date freeSince;
	int tripsNo;
	List<Trip> trips;

	public Cab(String name, State state, String currentCity) {
		this.name = name;
		this.state = state;
		this.currentCity = currentCity;
		this.tripsNo = 0;
		this.freeSince = new Date();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getCurrentCity() {
		return currentCity;
	}

	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}

	public Date getFreeSince() {
		return freeSince;
	}

	public void setFreeSince() {
		this.freeSince = new Date();
	}

	public int getTripsNo() {
		return tripsNo;
	}

	public void updateTripCount() {
		this.tripsNo++;
	}

	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(Trip trip) {
		if (this.trips == null) {
			this.trips = new ArrayList<Trip>();
		}
		this.trips.add(trip);
	}

	public void setFreeSince(Date freeSince) {
		this.freeSince = freeSince;
	}
}