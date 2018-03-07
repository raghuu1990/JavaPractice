package com.company.flipkart.cab;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DashBoard {
	Cities cities;
	List<Cab> cabs;
	HashMap<String, Cab> cabNameMapping;
	HashMap<String, Trip> custTripMapping;
	HashMap<String, List<Cab>> cityCabMapping;

	public void print(){
		System.out.println();
		System.out.println("System : ");
		for (Cab cab : cabs) {
			System.out.println(cab.name+ " " + cab.state+ " " + cab.currentCity);
		}
		System.out.println();
	}
	
	public void initialise() {
		cities = new Cities();
		cabs = new LinkedList<Cab>();
		cabNameMapping = new HashMap<String, Cab>();
		cityCabMapping = new HashMap<String, List<Cab>>();
		custTripMapping = new HashMap<String, Trip>();
	}

	public void addCity(String city) {
		cities.addCity(city);
	}

	public void registerCab(String cabName, String city) {
		if(!cities.isCityPresent(city)) {
			addCity(city);
		}
		Cab cab = createCab(cabName, State.IDLE, city);
		updateCabLocation(cab, city);
	}

	public void updateCabLocation(String cabName, String city) {
		if(cabNameMapping.containsKey(cabName)) {
			updateCabLocation(cabNameMapping.get(cabName), city);
		}else {
			System.out.println("No such cab exists");
		}
	}

	public void updateCabLocation(Cab cab, String city) {
		if(cities.isCityPresent(city)) {
			cab.setCurrentCity(city);
			if (cityCabMapping.containsKey(city)) {
				cityCabMapping.get(city).add(cab);
			} else {
				LinkedList<Cab> citiCabs = new LinkedList<Cab>();
				citiCabs.add(cab);
				cityCabMapping.put(city, citiCabs);
			}
		}else {
			System.out.println("No such city exists");
		}
	}

	public void requestCab(String city1, String city2, String custName, Strategy strategy) {
		Cab cab = findCab(city1, strategy); 
		if(cab!=null) {
			Trip trip = new Trip(custName, cab, city1, city2, false);
			updateCabBeforeTrip(cab, trip);
			custTripMapping.put(custName, trip);
			System.out.println(cab.name + " booked");
		}else{
			System.out.println("No Cab Available");
		}
	}

	public void endTrip(String customer) {
		if(custTripMapping.containsKey(customer)) {
			Trip trip = custTripMapping.get(customer);
			trip.setCompleted(true);
			updateCabAfterTrip(trip);
			custTripMapping.remove(customer);
		}else {
			System.out.println("No trip exists");
		}
	}

	public void getCabHistory(String cabName) {
		Cab cab = cabNameMapping.get(cabName);
		System.out.println(cab.getName() + " history");
		for(Trip trip :  cab.getTrips()) { 
			System.out.println(trip.getCity1() +" "+ trip.getCity2());
		}
	}
	
	// Utils
	private Cab findCab(String city1, Strategy strategy) {
		List<Cab> cabs = cityCabMapping.get(city1);
		Cab finalCab = null;
		for (Cab cab : cabs) {
			if(cab.getState()==State.IDLE) {
				if(finalCab==null) {
					finalCab = cab;
				}
				if(Strategy.LEAST_TRIPS==strategy) {
					if(finalCab.tripsNo<cab.tripsNo) {
						finalCab = cab;
					}
				}else if (Strategy.MOST_IDLE==strategy) {
					if(finalCab.getFreeSince().before(cab.getFreeSince())) {
						finalCab = cab;
					}
				}
			}
		}
		return finalCab;
	}
	
	public Cab createCab(String name, State state, String currentCity) {
		Cab cab = new Cab(name, state, currentCity);
		cabNameMapping.put(name, cab);
		cabs.add(cab);
		return cab;
	}
	
	void updateCabBeforeTrip(Cab cab, Trip trip) {
		cab.setState(State.ON_TRIP);
		cab.setTrips(trip);
	}

	void updateCabAfterTrip(Trip trip) {
		Cab cab = trip.getCab();
		cab.setState(State.IDLE);
		cab.updateTripCount();
		cab.setFreeSince();
		updateCabLocation(cab, trip.getCity2());
	}
}