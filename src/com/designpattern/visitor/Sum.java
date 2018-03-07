package com.designpattern.visitor;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int sum = 0;
		for (int i = 0; i < t; i++) {
			sum += in.nextInt();
		}
		System.out.println(sum);
		in.close();
	}
}
