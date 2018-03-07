package com.bit;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/30-binary-numbers/problem

public class MaxContiniousOne {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		System.out.println(maxContiniousOne(num));
		in.close();
	}

	public static int maxContiniousOne(int num) {
		int max = 0;
		int j = 0;
		int temp = 0;
		while (num > Math.pow(2, j)) {
			if ((num & (int) Math.pow(2, j)) == Math.pow(2, j)) {
				temp++;
				max = Math.max(max, temp);
			} else {
				temp = 0;
			}
		}

		return max;
	}
}