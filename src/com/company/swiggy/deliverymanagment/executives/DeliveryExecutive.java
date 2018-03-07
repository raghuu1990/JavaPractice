package com.company.swiggy.deliverymanagment.executives;

import java.util.Date;

import com.company.swiggy.deliverymanagment.pojo.Location;

//DeliveryExecutive class contains fields/methods related to DeliveryExecutive, implements Comparable,
//Override compareTo method to compare last order delivered time of DE

public class DeliveryExecutive implements IExecutive, Comparable<DeliveryExecutive>{
	int id;
	Location current_location;
	Date last_order_delivered_time;

	public DeliveryExecutive(int id, Date last_order_delivered_time, Location current_location) {
		this.id = id;
		this.current_location = current_location;
		this.last_order_delivered_time = last_order_delivered_time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Location getCurrent_location() {
		return current_location;
	}

	public void setCurrent_location(Location current_location) {
		this.current_location = current_location;
	}

	public Date getLast_order_delivered_time() {
		return last_order_delivered_time;
	}

	public void setLast_order_delivered_time(Date last_order_delivered_time) {
		this.last_order_delivered_time = last_order_delivered_time;
	}
	
	@Override
	public int compareTo(DeliveryExecutive obj) {
		if(this.last_order_delivered_time.before(obj.last_order_delivered_time)) {
			return 1;
		}
		return -1;
	}
}