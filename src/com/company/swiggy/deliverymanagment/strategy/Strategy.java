package com.company.swiggy.deliverymanagment.strategy;

// This is a enum for Strategy, a Strategy can be combination of some SubStrategy in some order
/*
	-> Efficiency i.e maximum utilization of delivery boys.
	-> Quality i.e prioritize order delay, equal distribution of orders among delivery boys.
*/
public enum Strategy {
	QUALITY, EFFICIENCY
}