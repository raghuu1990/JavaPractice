package com.company.swiggy.deliverymanagment.substrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.company.swiggy.deliverymanagment.executives.DeliveryExecutive;
import com.company.swiggy.deliverymanagment.orders.Order;
import com.company.swiggy.deliverymanagment.pojo.Assignment;
import com.company.swiggy.deliverymanagment.strategy.Strategy;

// This class is implementation of ISubStrategy, which used to perform WaitingTime SubStrategy on Orders and DEs
// It sort DeliveryExecutive by there last_order_delivered_time

public class WaitingTime implements ISubStrategy {
	public List<Assignment> execute(List<Order> order, List<DeliveryExecutive> deliveryExecutives, Strategy strategy) {
		Collections.sort(deliveryExecutives);
		return new ArrayList<Assignment>();
	}
}