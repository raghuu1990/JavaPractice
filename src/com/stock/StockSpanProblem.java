package com.stock;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

// http://www.geeksforgeeks.org/the-stock-span-problem/

// Need to check from present day how many stocks are equal or larger than past stock prices

public class StockSpanProblem {

	public static void main(String[] args) {
		//int[] prices = { 100, 60, 70, 60, 75, 85 };
		 int[] prices = { 1, 1, 2, 1, 4, 5 };
		System.out.print(Arrays.toString(stockSpanStack(prices)));
		System.out.print(Arrays.toString(stockSpanDeque(prices)));
	}

	public static int[] stockSpanStack(int[] prices) {
		int result[] = new int[prices.length];
		Stack<Integer> stack = new Stack<>();
		result[0] = 1;
		stack.push(0);

		for (int i = 1; i < prices.length; i++) {
			// price is greater than top of stack
			while (!stack.isEmpty() && prices[i] >= prices[stack.peek()]) {
				stack.pop();
			}
			result[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
			stack.push(i);
		}
		return result;
	}

	public static int[] stockSpanDeque(int[] prices) {
		int[] result = new int[prices.length];
		Deque<Integer> deque = new ArrayDeque<>();
		result[0] = 1;
		deque.offerFirst(0);

		for (int i = 1; i < prices.length; i++) {
			while (!deque.isEmpty() && prices[i] >= prices[deque.peekFirst()]) {
				deque.pollFirst();
			}
			if (deque.isEmpty()) {
				result[i] = i + 1;
			} else {
				result[i] = i - deque.peekFirst();
			}
			deque.offerFirst(i);
		}
		return result;
	}
}