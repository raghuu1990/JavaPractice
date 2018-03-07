package com.company.swiggy.deliverymanagment.orders;

import java.util.Date;

import com.company.swiggy.deliverymanagment.pojo.Location;

//  Order class contains fields/methods related to order, implements Comparable,
//  Override compareTo method to compare time of orders
public class Order implements IOrder, Comparable<Order>{
	int id;
	Date ordered_time;
	Location restaurant_location;

	public Order(int id, Date ordered_time, Location restaurant_location) {
		this.id = id;
		this.ordered_time = ordered_time;
		this.restaurant_location = restaurant_location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrdered_time() {
		return ordered_time;
	}

	public void setOrdered_time(Date ordered_time) {
		this.ordered_time = ordered_time;
	}

	public Location getRestaurant_location() {
		return restaurant_location;
	}

	public void setRestaurant_location(Location restaurant_location) {
		this.restaurant_location = restaurant_location;
	}

	@Override
	public int compareTo(Order obj) {
		if(this.ordered_time.before(obj.ordered_time)) {
			return 1;
		}
		return -1;
	}
}