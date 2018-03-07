package com.hackerrank.hourrank26;

import java.util.Scanner;

// https://www.hackerrank.com/contests/hourrank-26/challenges/combo-meal

public class ComboMeal {
	static int profit(int b, int s, int c) {
		return b + s - c;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int b = in.nextInt();
			int s = in.nextInt();
			int c = in.nextInt();
			int result = profit(b, s, c);
			System.out.println(result);
		}
		in.close();
	}
}