package com.prem;


public class A{
	
	public static void main(String[] args) {
		B b= new B();
		b.setX(56);
		System.out.println(b.getX());
	
		B b2= new B();
		b2.setX(60);
		System.out.println(b2.getX());
		
		System.out.println(b.getX());
		
		System.out.println(B.groupName);
		
	}
}

class B {
	
	private int x;
	private String name;
	public static String groupName="B-group";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
}