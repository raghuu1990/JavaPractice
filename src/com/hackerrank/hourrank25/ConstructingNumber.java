package com.hackerrank.hourrank25;

import java.util.Scanner;

// https://www.hackerrank.com/contests/hourrank-25/challenges/constructing-a-number

public class ConstructingNumber{
	static String canConstruct(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += digitSum(a[i]);
		}
		if (sum % 3 == 0) {
			return "Yes";
		}
		return "No";
	}

	static int digitSum(int num) {
		int sum = 0;
		while(num>0) {
			sum+=num%10;
			num=num/10;
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int[] a = new int[n];
			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = in.nextInt();
			}
			String result = canConstruct(a);
			System.out.println(result);
		}
		in.close();
	}
}