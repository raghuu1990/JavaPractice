package com.testing;

import java.util.Random;

// https://www.hackerrank.com/challenges/30-testing/problem

public class Testing {
	public static void main(String[] args) {
		String[] result = {"YES", "NO", "YES", "NO", "YES"};
		createInput(result);
	}

	private static void createInput(String[] result) {
		System.out.println(result.length);
		for (int i = 0; i < result.length; i++) {
			int m = getRandom(3+(10*i), 3+(10*(i+1)));
			int n = getRandom(3, m-1);
			System.out.println(m+" "+n);
			if(result[i].equalsIgnoreCase("YES")) {
				for (int k = 0; k < n; k++) {
					System.out.print("-"+new Random().nextInt(1000)+" ");
				}
				System.out.print(0+" ");
				for (int k = 0; k <(m-n-1); k++) {
					System.out.print(getRandom(1, 1000)+" ");
				}
			}else {
				System.out.print("-"+new Random().nextInt(1000)+" ");
				System.out.print(0+" ");
				for (int k = 0; k <(m-2); k++) {
					System.out.print(getRandom(1, 1000)+" ");
				}
			}
            System.out.println();
		}
	}

	private static int getRandom(int start, int end) {
		while (true) {
			int i = new Random().nextInt(end);
			if (i >= start) {
				return i;
			}
		}
	}
}