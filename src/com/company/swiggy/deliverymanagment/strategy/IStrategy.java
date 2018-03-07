package com.company.swiggy.deliverymanagment.strategy;

import java.util.List;

import com.company.swiggy.deliverymanagment.executives.DeliveryExecutive;
import com.company.swiggy.deliverymanagment.orders.Order;
import com.company.swiggy.deliverymanagment.pojo.Assignment;
import com.company.swiggy.deliverymanagment.substrategy.SubStrategy;

// Interface for Strategy
public interface IStrategy {
	public List<SubStrategy> getSubStrategyOrder();
	public List<Assignment> resolve(List<Order> orders, List<DeliveryExecutive> deliveryExecutives);
}