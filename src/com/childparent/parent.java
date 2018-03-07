package com.childparent;

public class parent extends superParent{
	//protected int p = 100;
	public parent(int p) {
		//super(100);
		//this.p = p;
		System.out.println("parent constractor with field");
	}

	public parent() {
		super();
		System.out.println("parent constractor with out field");
	}

	protected void method() {
		System.out.println("parent method with out field : ");
	}
	
	public void method(int p) {
		System.out.println("parent method with field : "+ p);
	}
}
