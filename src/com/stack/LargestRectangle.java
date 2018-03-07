package com.stack;

import java.util.Scanner;
import java.util.Stack;

// https://www.hackerrank.com/challenges/largest-rectangle/problem

public class LargestRectangle {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();
		int[] heights = new int[t + 1];
		for (int i = 0; i < t; i++) {
			heights[i] = in.nextInt();
		}
		heights[t] = 0;
		System.out.println(getMaxArea(heights));
		in.close();
	}

	public static int largestRectangle(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int maxAreaSoFar = -1;
		for (int height : heights) {
			int n = 0;
			while (!stack.isEmpty() && stack.peek() > height) {
				n++;
				maxAreaSoFar = Math.max(maxAreaSoFar, n * stack.pop());
			}
			for (int i = 0; i < n + 1; i++) {
				stack.push(height);
			}
		}
		return maxAreaSoFar;
	}

	// O(n)
	public static int getMaxArea(int heights[]) {
		Stack<Integer> s = new Stack<>();
		int maxArea = 0;
		int tp;
		int maxAreaSoFar;

		int i = 0;
		while (i < heights.length) {
			if (s.empty() || heights[s.peek()] <= heights[i]) {
				s.push(i++);
			} else {
				tp = s.pop();
				maxAreaSoFar = heights[tp] * (s.empty() ? i : (i - s.peek() - 1));
				if (maxArea < maxAreaSoFar) {
					maxArea = maxAreaSoFar;
				}
			}
		}

		while (!s.empty()) {
			tp= s.pop();
			maxAreaSoFar = heights[tp] * (s.empty() ? i : (i - s.peek() - 1));

			if (maxArea < maxAreaSoFar) {
				maxArea = maxAreaSoFar;
			}
		}
		return maxArea;
	}
}