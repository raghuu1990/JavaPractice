package com.company.swiggy.deliverymanagment.manager;

import java.util.List;

import com.company.swiggy.deliverymanagment.executives.DeliveryExecutive;
import com.company.swiggy.deliverymanagment.orders.Order;
import com.company.swiggy.deliverymanagment.pojo.Assignment;
import com.company.swiggy.deliverymanagment.strategy.IStrategy;
import com.company.swiggy.deliverymanagment.strategy.Strategy;
import com.company.swiggy.deliverymanagment.strategy.StrategyFactory;

// This class is responsible for find best Assignment executing execute method.

public class DeliveryManager implements IManager {
	public void initialise() {
		// Initialise
	}

	public List<Assignment> execute(List<Order> orders, List<DeliveryExecutive> deliveryExecutives, Strategy strategyType) {
		IStrategy executer = StrategyFactory.getStrategy(strategyType);
		return executer.resolve(orders, deliveryExecutives);
	}
}