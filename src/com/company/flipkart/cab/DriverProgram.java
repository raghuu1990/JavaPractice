package com.company.flipkart.cab;

public class DriverProgram {
	public static void main(String[] args) {
		System.out.println("Start");
		DashBoard d = new DashBoard();
		d.initialise();
		
		d.print();
		
		d.addCity("City1");
		d.addCity("City2");
		d.addCity("City3");
		d.addCity("City4");
		d.addCity("City5");
		
		d.registerCab("Cab1", "City1");
		d.registerCab("Cab2", "City2");
		d.registerCab("Cab3", "City3");
		d.registerCab("Cab4", "City3");
		
		d.registerCab("Cab5", "City1");
		d.registerCab("Cab6", "City2");
		d.registerCab("Cab7", "City3");
		d.registerCab("Cab8", "City3");
		
		d.print();
		
		d.updateCabLocation("Cab4", "City");
		d.updateCabLocation("Cab8", "City");
		d.updateCabLocation("Cab4", "City4");
		d.updateCabLocation("Cab8", "City4");
		
		d.print();

		d.requestCab("City1", "City2", "Customer1", Strategy.LEAST_TRIPS);
		d.print();
		d.requestCab("City2", "City1", "Customer2", Strategy.MOST_IDLE);
		d.print();
		d.requestCab("City3", "City4", "Customer3", Strategy.LEAST_TRIPS);
		d.print();
		d.requestCab("City4", "City3", "Customer4", Strategy.MOST_IDLE);
		d.print();
		
		d.endTrip("Customer1");
		d.print();
		d.endTrip("Customer2");
		d.print();
		d.endTrip("Customer3");
		d.print();
		d.endTrip("Customer4");
		
		d.print();
	}
}