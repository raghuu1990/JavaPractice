package com.calls;


public class StaticTest {
	public static int i;

	public static void main(String[] args) {
		StaticTest t1 = new StaticTest();
		StaticTest t2 = new StaticTest();
		System.out.println("Before "+ i);
		System.out.println("t1.i "+ t1.i);
		modify(i);
		System.out.println("After modify "+ i);
		t1.i=30;
		System.out.println("after "+ i);
		System.out.println("t2.i "+ t2.i);
	}

	private static void modify(int i) {
		i+=10;
		System.out.println("in method "+ i);
	}
}

