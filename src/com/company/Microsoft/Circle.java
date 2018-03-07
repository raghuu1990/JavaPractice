package com.company.Microsoft;

public class Circle {
	float radius;

	Circle(float radius) {
		this.radius = radius;
	}

	public Integer getArea() {
		return (int) Math.ceil(3.14159265 * radius * radius);
	}
}

class Rectangle {
	float side1;
	float side2;

	Rectangle(float side1, float side2) {
		this.side1 = side1;
		this.side2 = side2;
	}

	public Integer getArea() {
		return (int) Math.ceil(side1 * side2);
	}
}

class Square {
	float side1;

	Square(float side1) {
		this.side1 = side1;
	}

	public Integer getArea() {
		return (int) Math.ceil(side1 * side1);
	}
}