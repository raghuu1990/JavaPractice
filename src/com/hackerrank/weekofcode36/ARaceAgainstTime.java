package com.hackerrank.weekofcode36;

import java.util.Scanner;
import java.util.Stack;

// https://www.hackerrank.com/contests/w36/challenges/a-race-against-time

public class ARaceAgainstTime {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int mason_height = in.nextInt();
		int[] heights = new int[n];
		heights[0] = mason_height;
		for (int i = 1; i < n; i++) {
			heights[i] = in.nextInt();
		}
		int[] prices = new int[n];
		prices[0] = 0;
		for (int i = 1; i < n; i++) {
			prices[i] = in.nextInt();
		}
		long result = raceAgainstTime(n, heights, prices);
		System.out.println(result);
		in.close();
	}

	static long raceAgainstTime(int n, int[] heights, int[] prices) {
		int nextHeigherIndexes[] = nextGreaterElement(heights);
		long[] minCost = new long[n];
		minCost[n - 1] = 0;
		
		for (int i = n - 2; i >= 0; i--) {
			long cost = Long.MAX_VALUE;
			int nextHeigherIndex = nextHeigherIndexes[i];
			int target = i+1;
			for (; target <= nextHeigherIndex; target++) {
				cost = Math.min(cost, minCost[target] + prices[target] + Math.abs(heights[target] - heights[i]));
			}
			minCost[i] = cost;
		}
		return minCost[0] + n;
	}

	private static int[] nextGreaterElement(int[] arr) {
		int result[] = new int[arr.length];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = result.length - 1; i >= 0; i--) {
			int value = arr[i];
			while (!stack.isEmpty() && !(arr[stack.peek()] > value)) {
				stack.pop();
			}
			if (!stack.isEmpty()) {
				result[i] = stack.peek();
			} else {
				result[i] = -1;
			}
			stack.add(i);
		}
		return result;
	}
}