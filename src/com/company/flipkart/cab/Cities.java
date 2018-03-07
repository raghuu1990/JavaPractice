package com.company.flipkart.cab;

import java.util.HashSet;
import java.util.Set;

public class Cities {
	int size=0;
	Set<String> cities = new HashSet<String>();

	public Set<String> getCities() {
		return cities;
	}

	public boolean isCityPresent(String city){
		if(cities.contains(city)) {
			return true;
		}
		return false;
	}
	
	public void addCity(String city) {
		if(!cities.contains(city)) {
			cities.add(city);
			size=cities.size();
			System.out.println(city + " added");
		}else {
			System.out.println(city + " already present");
		}
	}

	public void deleteCity(String city) {
		if(cities.contains(city)) {
			cities.remove(city);
			size=cities.size();
			System.out.println(city + " removed");
		}else {
			System.out.println(city + " not present");
		}
	}
}