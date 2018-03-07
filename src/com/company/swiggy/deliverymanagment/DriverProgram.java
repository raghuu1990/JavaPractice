package com.company.swiggy.deliverymanagment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.company.swiggy.deliverymanagment.executives.DeliveryExecutive;
import com.company.swiggy.deliverymanagment.manager.CityDeliveryManager;
import com.company.swiggy.deliverymanagment.manager.DeliveryManager;
import com.company.swiggy.deliverymanagment.orders.Order;
import com.company.swiggy.deliverymanagment.pojo.Assignment;
import com.company.swiggy.deliverymanagment.pojo.Location;
import com.company.swiggy.deliverymanagment.strategy.Strategy;

//This class is driver class takes DEs and orders as input and find best Assignments using given Strategy(ie. EFFICIENCY, QUALITY).

public class DriverProgram {
	public static void main(String[] args) {
		DeliveryManager deliveryManager = new  DeliveryManager();
		CityDeliveryManager cityDeliveryManager = new  CityDeliveryManager();

		List<Assignment> result;
		
		List<Order> orders = new ArrayList<Order>();
		Date a1 = new Date(5); 	
		Date a2 = new Date(12);
		
		orders.add(new Order(1, a1, new Location(20, 20)));
		orders.add(new Order(2, a2, new Location(40, 30)));
		
		Date t1 = new Date(6); 
		Date t2 = new Date(2);	
		Date t3 = new Date(9);
		
		List<DeliveryExecutive> deliveryExecutives = new ArrayList<DeliveryExecutive>();
		deliveryExecutives.add(new DeliveryExecutive(1, t1, new Location(30, 30)));
		deliveryExecutives.add(new DeliveryExecutive(2, t2, new Location(10, 20)));
		deliveryExecutives.add(new DeliveryExecutive(3, t3, new Location(40,20)));
		
		result = deliveryManager.execute(orders, deliveryExecutives, Strategy.EFFICIENCY);
		System.out.println(result);
		
		result = deliveryManager.execute(orders, deliveryExecutives, Strategy.QUALITY);
		System.out.println(result);
		
		// For whole city
		cityDeliveryManager.initialise();
		cityDeliveryManager.execute();
	}
}