package com.company.swiggy.deliverymanagment.manager;

import java.util.List;

import com.company.swiggy.deliverymanagment.executives.DeliveryExecutive;
import com.company.swiggy.deliverymanagment.orders.Order;
import com.company.swiggy.deliverymanagment.pojo.Assignment;
import com.company.swiggy.deliverymanagment.strategy.Strategy;

// Interface for Managers.
public interface IManager {
	public void initialise();
	public List<Assignment> execute(List<Order> orders, List<DeliveryExecutive> deliveryExecutives, Strategy strategyType);	
}