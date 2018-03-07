package com.company.swiggy.deliverymanagment.strategy;

import java.util.ArrayList;
import java.util.List;

import com.company.swiggy.deliverymanagment.executives.DeliveryExecutive;
import com.company.swiggy.deliverymanagment.orders.Order;
import com.company.swiggy.deliverymanagment.pojo.Assignment;
import com.company.swiggy.deliverymanagment.substrategy.ISubStrategy;
import com.company.swiggy.deliverymanagment.substrategy.SubStrategy;
import com.company.swiggy.deliverymanagment.substrategy.SubStrategyFactory;

// Quality i.e prioritize order delay, equal distribution of orders among delivery boys.
// So sort Orders by there ordered_time, then sort DEs by last_order_delivered_time then assign nearest order to them.

// This class is implementation of IStrategy, which used to perform EfficiencyStrategy using its SubStrategy in some order
// Quality first performs OrderDelay SubStrategy then WaitingTime SubStrategy and FirstMile SubStrategy at last.


public class Quality implements IStrategy {
	Strategy strategy = Strategy.QUALITY;
	
	@Override
	public List<Assignment> resolve(List<Order> orders, List<DeliveryExecutive> deliveryExecutives) {
		List<Assignment> assignments = new ArrayList<Assignment>();
		for(SubStrategy subStrategy : getSubStrategyOrder()) {
			ISubStrategy subStrategyManager = SubStrategyFactory.getStrategy(subStrategy);
			List<Assignment> result = subStrategyManager.execute(orders, deliveryExecutives, strategy);
			if(!result.isEmpty()) {
				assignments.addAll(result);
			}
		}
		return assignments;
	}

	@Override
	public List<SubStrategy> getSubStrategyOrder() {
		List<SubStrategy> subStrategyOrder = new ArrayList<SubStrategy>();
		subStrategyOrder.add(SubStrategy.ORDER_DELAY);
		subStrategyOrder.add(SubStrategy.WAITING_TIME);
		subStrategyOrder.add(SubStrategy.FIRST_MILE);
		return subStrategyOrder;
	}
}