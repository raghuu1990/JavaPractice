package com.problems;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/chocolate-feast?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
public class ChocolateFeast {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[] result = new int[t];
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int c = in.nextInt();
			int m = in.nextInt();
			result[i] = solve(n, c , m);
		}
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		in.close();
	}

	private static int solve(int n, int c, int m) {
		if(n==0) {
			return 0;
		}
		int count = n/c;
		int cNow = count;
		while(cNow>0) {
			if(m>cNow) {
				break;
			}
			int newC = cNow/m;
			count += newC;
			cNow = cNow%m + newC;
		}
		return count;
	}
}