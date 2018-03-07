package com.company.swiggy.deliverymanagment.strategy;

import java.util.ArrayList;
import java.util.List;

import com.company.swiggy.deliverymanagment.executives.DeliveryExecutive;
import com.company.swiggy.deliverymanagment.orders.Order;
import com.company.swiggy.deliverymanagment.pojo.Assignment;
import com.company.swiggy.deliverymanagment.substrategy.ISubStrategy;
import com.company.swiggy.deliverymanagment.substrategy.SubStrategy;
import com.company.swiggy.deliverymanagment.substrategy.SubStrategyFactory;

// Efficiency i.e maximum utilization of delivery boys. So sort DEs by last_order_delivered_time assign nearest order to them.

// This class is implementation of IStrategy, which used to perform EfficiencyStrategy using its SubStrategy in some order
// Efficiency first performs WaitingTime SubStrategy then FirstMile SubStrategy.

public class Efficiency implements IStrategy {
	Strategy strategy = Strategy.EFFICIENCY;

	@Override
	public List<Assignment> resolve(List<Order> orders, List<DeliveryExecutive> deliveryExecutives) {
		List<Assignment> assignments = new ArrayList<Assignment>();
		for(SubStrategy subStrategy : getSubStrategyOrder()) {
			ISubStrategy subStrategyManager = SubStrategyFactory.getStrategy(subStrategy);
			List<Assignment> result = subStrategyManager.execute(orders, deliveryExecutives, strategy);
			assignments.addAll(result);
		}
		return assignments;
	}

	@Override
	public List<SubStrategy> getSubStrategyOrder() {
		List<SubStrategy> subStrategyOrder = new ArrayList<SubStrategy>();
		subStrategyOrder.add(SubStrategy.WAITING_TIME);
		subStrategyOrder.add(SubStrategy.FIRST_MILE);
		return subStrategyOrder;
	}
}