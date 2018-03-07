package com.company.flipkart;

import java.util.Scanner;

public class PrintThKthDigit {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int k = in.nextInt();
			long c = (long) Math.pow(a, b);
			String str = Long.toString(c);
			int l = str.length();
			System.out.println(str.charAt(l - k));
		}
		in.close();
	}
}