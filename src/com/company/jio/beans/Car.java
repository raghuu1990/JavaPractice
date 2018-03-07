package com.company.jio.beans;

import com.company.jio.enums.Color;
import com.company.jio.enums.Condition;
import com.company.jio.enums.Make;
import com.company.jio.enums.Type;

public class Car {
	public String name;
	public Make make;
	public Condition condition; 
	public Type type;
	public Color color;
	public double price;

	public Car(String name, Make make2, Condition condition, Type type, Color color, double d) {
		super();
		this.name = name;
		this.make = make2;
		this.condition = condition;
		this.type = type;
		this.color = color;
		this.price = d;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", make=" + make + ", condition=" + condition + ", type=" + type + ", color="
				+ color + ", price=" + price + "]";
	}
}