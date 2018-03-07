package com.childparent;

public class superParent {
	public static int p =1000;
	public superParent(int p) {
		super();
		//this.p = p;
		System.out.println("superParent constractor with field : "+ p);
	}

	public superParent() {
		super();
		System.out.println("superParent constractor with out field");
	}
	
	protected void method() {
		p = p+10;
		System.out.println("superParent method with out field : ");
	}
	
	public void method(int p) {
		System.out.println("superParent method with field : "+ p);
	}
}
