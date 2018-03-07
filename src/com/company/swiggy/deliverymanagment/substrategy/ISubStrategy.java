package com.company.swiggy.deliverymanagment.substrategy;

import java.util.List;

import com.company.swiggy.deliverymanagment.executives.DeliveryExecutive;
import com.company.swiggy.deliverymanagment.orders.Order;
import com.company.swiggy.deliverymanagment.pojo.Assignment;
import com.company.swiggy.deliverymanagment.strategy.Strategy;

//Interface for SubStrategy
public interface ISubStrategy {
	public List<Assignment> execute(List<Order> orders, List<DeliveryExecutive> deliveryExecutives, Strategy strategy);
}