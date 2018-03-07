package com.codechef.jan2018;

import java.util.Scanner;

public class Rectangle {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		boolean[] result = new boolean[T];
		for (int i = 0; i < T; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			int d = in.nextInt();
			result[i] = (a ^ b ^ c ^ d) == 0;
		}
		for (int i = 0; i < T; i++) {
			if (result[i]) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		in.close();
	}
}