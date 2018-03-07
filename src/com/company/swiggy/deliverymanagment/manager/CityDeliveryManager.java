package com.company.swiggy.deliverymanagment.manager;

import java.util.ArrayList;
import java.util.List;

import com.company.swiggy.deliverymanagment.city.City;
import com.company.swiggy.deliverymanagment.executives.DeliveryExecutive;
import com.company.swiggy.deliverymanagment.orders.Order;
import com.company.swiggy.deliverymanagment.pojo.Assignment;
import com.company.swiggy.deliverymanagment.strategy.IStrategy;
import com.company.swiggy.deliverymanagment.strategy.Strategy;
import com.company.swiggy.deliverymanagment.strategy.StrategyFactory;

// This class is responsible for find best Assignment for orders of a city.

public class CityDeliveryManager implements IManager {
	List<City> cities = new ArrayList<City>();
	public void initialise() {
		// load all cities
		cities = new ArrayList<City>();
	}
	
	public void execute() {
		// for each city
		for (City city : cities) {
			// get all orders from city Orders Queue
			// get all DEs from city DeliveryExecutive Queue
			// get defaultCityStrategy

			List<Order> orders = city.getOrders();
			List<DeliveryExecutive> deliveryExecutives = city.getDeliveryExecutives();
			Strategy cityStrategy = city.getDefaultStrategyForCity();
			
			List<Assignment> assignments = execute(orders, deliveryExecutives, cityStrategy);
			
			// Put all city assignment in city Assignment Queue, 
			// We will maintain a city Assignment Queue, after assignment all orders and DEs will be notified
			for (Assignment assignment : assignments) {
				System.out.println(assignment.toString());
			}
		}
	}

	public List<Assignment> execute(List<Order> orders, List<DeliveryExecutive> deliveryExecutives,
			Strategy strategyType) {
		IStrategy executer = StrategyFactory.getStrategy(strategyType);
		return executer.resolve(orders, deliveryExecutives);
	}
}