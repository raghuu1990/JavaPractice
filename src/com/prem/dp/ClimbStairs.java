package com.prem.dp;

/**
 * 
 * You are given option of taking 1 or 2 steps at once. You have to reach to the top,
 * then how many different ways you can reach up to top.
 * 
 * Problem is like Fibonacci number f(n) = f(n-1)+f(n-2) :: n>=2 n(0)->1 , n(1)->2
 * 
 */

public class ClimbStairs {
	public static void main(String[] args) {
		System.out.println(count(4));
	}

	public static int count(int top) {
		int[] stepsCount = new int[top];
		stepsCount[0] = 1;
		stepsCount[1] = 2;

		for (int i = 2; i < top; i++) {
			stepsCount[i] = stepsCount[i - 2] + stepsCount[i - 1];
		}
		return stepsCount[top - 1];
	}
}