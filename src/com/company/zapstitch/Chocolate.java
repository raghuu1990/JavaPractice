package com.company.zapstitch;

import java.util.Scanner;

public class Chocolate {
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int a[] = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = in.nextInt();
		}

		int max = 0;
		int maxN0 = a[0];

		for (int i = 0; i < N; i++) {
			if (a[i] >= maxN0) {
				maxN0 = a[i];
				int temp = 0;
				for (int j = i + 1; j < N; j++) {
					if (a[j] < a[i]) {
						temp++;
					}
				}
				if (temp > max) {
					max = temp;
				}
			}
		}
		in.close();
		System.out.println(max);
	}
}
