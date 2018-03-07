package com.company.swiggy.deliverymanagment.utils;

import com.company.swiggy.deliverymanagment.pojo.Location;

// Utility method to find distance b/w two Locations (ie. Order and DE)

public class DistanceUtils {
	public static final double R = 6372.8; // In kilometers

	public static double findDistance(Location l1, Location l2) {
		return findDistance(l1.getLat(), l1.getLon(), l2.getLat(), l2.getLon());
	}

	public static double findDistance(double lat1, double lon1, double lat2, double lon2) {
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);

		double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
		double c = 2 * Math.asin(Math.sqrt(a));
		return R * c;
	}

	public static void main(String[] args) {
		System.out.println(findDistance(36.12, -86.67, 33.94, -118.40));
	}
}