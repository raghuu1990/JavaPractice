package com.company.swiggy.deliverymanagment.pojo;

// [{“order_id”:123,”de_id”:765}]

// Assignment class, used for maintain combination of order and DEs Ids
public class Assignment {
	int de_id;
	int order_id;

	public Assignment(int order_id, int de_id) {
		this.de_id = de_id;
		this.order_id = order_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getDe_id() {
		return de_id;
	}

	public void setDe_id(int de_id) {
		this.de_id = de_id;
	}
	
	@Override
	public String toString() {
		return "ORDER ID : " +this.getOrder_id() + " , DE : " + this.getDe_id()+" ";
	}
	
}