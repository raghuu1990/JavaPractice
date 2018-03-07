package com.javaconcepts.childparent;


/*
 * Static initialization & Class loads in memory & JVM reads the byte code
 * A class loads in memory if its object created / static method is called or it contains main method
 * First Class loads in order (parent to child) then 
 * All Static fields/blocks initialization/call on class load in the order they are present in class,
 *
 * On Constructor call : Parent constructor calls first (first line super()) then 
 * local fields/variable/blocks initialization/call then rest part of the constructor through which object is created.
 */

public class ObjCreation {
	public static void main(String[] args) {
		Parent.method3();
		//new Parent();
		System.out.println();
		//new GrandChild();
		System.out.println();
		//Child c = new Child();
		System.out.println();
		//Parent p = new Parent();
	}
}

class Parent {
	X x = new X();
	
	{
		System.out.println("PB1");
	}
	
	static {
		System.out.println("PSB1");
	}
	
	Y y = new Y();
	
	public static void method1() {
		System.out.println("PSM1");
	}
	
	static {
		System.out.println("PSB2");
	}

	public static void method2() {
		System.out.println("PSM2");
	}
	
	{
		System.out.println("PB2");
	}

	static {
		System.out.println("PSB3");
	}
	
	public Parent() {
		System.out.println("PC");
	}
	
	public static void method3() {
		System.out.println("PSM3");
	}

	static {
		System.out.println("PSB4");
	}
}

class Child extends Parent {
	Z z = new Z();
	static {
		System.out.println("CS");
	}

	{
		System.out.println("CB");
	}

	public Child() {
		System.out.println("CC");
	}
}

class GrandChild extends Child {
	Z z = new Z();
	static {
		System.out.println("GCS");
	}

	{
		System.out.println("GCB");
	}

	public GrandChild() {
		System.out.println("GCC");
	}
}

class X {
	static {
		System.out.println("XS");
	}

	{
		System.out.println("XB");
	}

	public X() {
		System.out.println("XC");
	}
}

class Y {
	static {
		System.out.println("YS");
	}

	{
		System.out.println("YB");
	}

	public Y() {
		System.out.println("YC");
	}
}

class Z {
	static {
		System.out.println("ZS");
	}

	{
		System.out.println("ZB");
	}

	public Z() {
		System.out.println("ZC");
	}
}