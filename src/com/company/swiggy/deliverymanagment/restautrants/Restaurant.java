package com.company.swiggy.deliverymanagment.restautrants;

import com.company.swiggy.deliverymanagment.pojo.Location;

//Restaurant class will be used latter when problem will be extended

public class Restaurant implements IRestaurant{
	String Name;
	Location location;

	public Restaurant(String name, Location location) {
		Name = name;
		this.location = location;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}