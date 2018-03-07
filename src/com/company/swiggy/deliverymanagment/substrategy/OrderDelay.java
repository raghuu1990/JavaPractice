package com.company.swiggy.deliverymanagment.substrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.company.swiggy.deliverymanagment.executives.DeliveryExecutive;
import com.company.swiggy.deliverymanagment.orders.Order;
import com.company.swiggy.deliverymanagment.pojo.Assignment;
import com.company.swiggy.deliverymanagment.strategy.Strategy;

// This class is implementation of ISubStrategy, which used to perform OrderDelay SubStrategy on Orders and DEs
// It sort Orders by there ordered_time

public class OrderDelay implements ISubStrategy {
	public List<Assignment> execute(List<Order> order, List<DeliveryExecutive> deliveryExecutives, Strategy strategy) {
		Collections.sort(order);
		return new ArrayList<Assignment>();
	}
}