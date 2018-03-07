package com.operators;

public class increment {

	public static void main(String[] args) {
		int i = 0;
		System.out.println(i++==1);
		
		System.out.println(i);
		i=0;
		System.out.println(++i);
		System.out.println(i++);
		
		i=0;
		System.out.println(++i==1);
		for (int j = 0; j < 10; j++) {
			System.out.print(j);
		}
		System.out.println();
		
		for (int j = 0; j < 10; ++j) {
			System.out.print(j);
		}
	}
}
