package com.company.swiggy.deliverymanagment.substrategy;

//This is enum for SubStrategy, A SubStrategy is a strategy used for find best Assignments. SubStrategy is used/part of, Strategy
/*
	-> First mile (Distance between restaurant and DE’s current location): Prioritise assignment pairs with low first mile.
	-> DE waiting time(Time elapsed since DE last delivered the order): Prioritise DE with already high waiting time.
	-> Order delay time (Time elapsed since Order was placed): Prioritize Order with already high order delay.
*/
public enum SubStrategy {
	FIRST_MILE, WAITING_TIME, ORDER_DELAY
}