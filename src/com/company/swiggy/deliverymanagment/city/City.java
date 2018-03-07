package com.company.swiggy.deliverymanagment.city;

import java.util.ArrayList;
import java.util.List;

import com.company.swiggy.deliverymanagment.executives.DeliveryExecutive;
import com.company.swiggy.deliverymanagment.orders.Order;
import com.company.swiggy.deliverymanagment.strategy.DefaultStrategy;
import com.company.swiggy.deliverymanagment.strategy.Strategy;

// City class will be used latter when problem will be extended to whole city

public class City implements ICity {
	Strategy strategy;
	String cityName;
	List<Order> orders = new ArrayList<Order>();
	List<DeliveryExecutive> deliveryExecutives = new ArrayList<DeliveryExecutive>();

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<DeliveryExecutive> getDeliveryExecutives() {
		return deliveryExecutives;
	}

	public void setDeliveryExecutives(List<DeliveryExecutive> deliveryExecutives) {
		this.deliveryExecutives = deliveryExecutives;
	}

	public Strategy getDefaultStrategyForCity() {
		if (strategy == null) {
			return DefaultStrategy.getDefaultStrategy();
		}
		return strategy;
	}
}