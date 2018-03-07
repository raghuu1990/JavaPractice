package com.maths;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/sam-and-substrings/problem

public class SubStringSum {
	private static int MOD = 1000000007;
	static long arr[] = new long[200001];
	
	public static void main(String[] args) {
		process();
		Scanner in = new Scanner(System.in);
		String balls = in.next();
		long result = substrings(balls);
		System.out.println(result);
		in.close();
	}

	public static long process() {
		arr[1] = 1;
		int i = 1;
		long f = 1;
		while(i<200000) {
			f = (((f*10)%MOD)+1)%MOD;
			i++;
			arr[i] = f;
		}
		return f;
	}
	
	static long substrings(String str) {
		long sum = 0;
		int ones = str.length();
		for (int i = 0; i < str.length(); i++) {
			sum = (sum + (Long.parseLong(str.substring(i, i+1)) * (i + 1) * arr[ones--])) % MOD;
		}
		return sum % MOD;
	}
}
