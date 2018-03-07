package com.prem.temp;

/**
 * Created by prembharti on 5/4/17.
 */
public class C {
	public static void main(String[] args) {
		B b = new B();
		// A a = new A();
	}
}

// static in order parent -> child, non static parent -> parent -> constractor

class A {
	static int i =0;
	
	A() {
		// load in memory
		System.out.println("A");
	}

	static {
		System.out.println("B");
	}
	{
		System.out.println("C");
	}
	int j =0;
}

class B extends A {
	B() {
		System.out.println("D");
	}

	static {
		System.out.println("E");
	}
	{
		System.out.println("F");
	}
}
