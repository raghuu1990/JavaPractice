package com.company.swiggy.deliverymanagment.pojo;

// Location class, contains cordinates(lat,lang), Used in Order and DE classes
public class Location {
	double lat;
	double lon;

	public Location(double lat, double lon) {
		this.lat = lat;
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lang) {
		this.lon = lang;
	}
}