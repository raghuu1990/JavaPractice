package com.basics;

public class Overloading {
	public static void main1() {
		System.out.println("static main() method invoked");
	}

	static {
		System.out.println("static block invoked");
	}

	public static void main(int a) {
		System.out.println(a);
	}

	public static final void main(String args[]) {
		System.out.println("main() method invoked");
		main(10);
	}
}