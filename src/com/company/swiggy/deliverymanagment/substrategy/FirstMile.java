package com.company.swiggy.deliverymanagment.substrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import com.company.swiggy.deliverymanagment.executives.DeliveryExecutive;
import com.company.swiggy.deliverymanagment.orders.Order;
import com.company.swiggy.deliverymanagment.pojo.Assignment;
import com.company.swiggy.deliverymanagment.pojo.HeapNode;
import com.company.swiggy.deliverymanagment.strategy.Strategy;
import com.company.swiggy.deliverymanagment.utils.DistanceUtils;

// This class is implementation of ISubStrategy, which used to perform FirstMile SubStrategy on Orders and DEs
// FirstMile sort DeliveryExecutive by minimum difference b/w Order and DEs Location
// Execute method takes Strategy as a param, so accordingly perform FirstMile. 
// ie: for QUALITY find closest DE from given Order, for Efficiency find closest Order from DEs

public class FirstMile implements ISubStrategy {
	PriorityQueue<HeapNode> minHeap;

	@Override
	public List<Assignment> execute(List<Order> orders, List<DeliveryExecutive> deliveryExecutives, Strategy strategy) {
		List<DeliveryExecutive> tempDE = new ArrayList<DeliveryExecutive>();
		List<Order> tempOrder = new ArrayList<Order>();
		tempDE.addAll(deliveryExecutives);

		List<Assignment> assignments = new ArrayList<Assignment>();
		
		if(Strategy.QUALITY==strategy) {
			if(deliveryExecutives.size()>orders.size()) {
				tempOrder.addAll(orders.subList(0, orders.size()));
			}else {
				tempOrder.addAll(orders);
			}
			for (Order order : orders) {
				minHeap = new PriorityQueue<HeapNode>();
				for (DeliveryExecutive DE : deliveryExecutives) {
					if(tempDE.size()==0) {
						break;
					}
					if(tempDE.contains(DE)) {
						Double distance = compare(order, DE);
						minHeap.add(new HeapNode(order, distance, DE));
					}
				}
				HeapNode result = minHeap.poll();
				if(result!=null) {
					assignments.add(result.getAssignment());
					tempDE.remove(result.getDeliveryExecutive());
				}
			}
		}else {
			tempOrder.addAll(orders);
			for (DeliveryExecutive DE : deliveryExecutives) {
				minHeap = new PriorityQueue<HeapNode>();
				for (Order order : orders) {
					if(tempOrder.size()==0) {
						break;
					}
					if(tempOrder.contains(order)) {
						Double distance = compare(order, DE);
						minHeap.add(new HeapNode(order, distance, DE));
					}
				}
				HeapNode result = minHeap.poll();
				if(result!=null) {
					assignments.add(result.getAssignment());
					tempOrder.remove(result.getOrder());
				}
			}
		}
		return assignments;
	}

	private double compare(Order order, DeliveryExecutive DE) {
		return DistanceUtils.findDistance(order.getRestaurant_location(), DE.getCurrent_location());
	}
}