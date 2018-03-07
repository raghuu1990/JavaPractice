package com.java8;

import java.util.Random;

public class Interface {
	Random random;

	public MyInterface test() {
		return this.m1();
	}

	public MyInterface m1() {
		return random::nextInt;
	}

	public void test1() {
		random = new Random();
		MyInterface o1 = test();
		System.out.println(o1.next());
		MyInterface o2 = test();
		random = null;
		System.out.println(o2.next());
	}

	public static void main(String args[]) {
		Interface testInnerClass = new Interface();
		testInnerClass.test1();
	}
}

interface MyInterface {
	int next();
}