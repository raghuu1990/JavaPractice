package com.company.swiggy.deliverymanagment.pojo;

import com.company.swiggy.deliverymanagment.executives.DeliveryExecutive;
import com.company.swiggy.deliverymanagment.orders.Order;

// This HeapNode class is used in Priority Queues to find/compare priority of combination of order and DEs

public class HeapNode implements Comparable<HeapNode> {
	Order order;
	Double priority;
	DeliveryExecutive deliveryExecutive;

	public HeapNode(Order order, Double priority, DeliveryExecutive deliveryExecutive) {
		this.order = order;
		this.priority = priority;
		this.deliveryExecutive = deliveryExecutive;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Double getPriority() {
		return priority;
	}

	public void setPriority(Double priority) {
		this.priority = priority;
	}

	public DeliveryExecutive getDeliveryExecutive() {
		return deliveryExecutive;
	}

	public void setDeliveryExecutive(DeliveryExecutive deliveryExecutive) {
		this.deliveryExecutive = deliveryExecutive;
	}

	public Assignment getAssignment() {
		return new Assignment(this.order.getId(), this.deliveryExecutive.getId());
	}

	@Override
	public int compareTo(HeapNode object) {
		if(this.priority<object.priority) {
			return -1;
		}else if(this.priority>object.priority) {
			return 1;
		}
		return this.deliveryExecutive.getLast_order_delivered_time().after(object.deliveryExecutive.getLast_order_delivered_time())?-1:1;
	}
}