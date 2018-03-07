package com.maths;

import java.util.Scanner;

public class MultiplicationPrint {
	public static void multiplication(int num) {
		for (int i = 1; i < 11; i++) {
			System.out.println(num + " x " + i + " = " + num * i);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = 1;
		
		while(sc.hasNextLine()) {
			System.out.println(t+++sc.nextLine());
		}

		sc.close();
	}
}