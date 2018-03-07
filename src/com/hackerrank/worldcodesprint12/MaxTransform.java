package com.hackerrank.worldcodesprint12;

import java.util.Scanner;
import java.util.Stack;

public class MaxTransform {
	private static int MOD = 1000000007;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int sum = solve3(arr);
		System.out.println(sum);
		in.close();
	}

	static int solve3(int[] list) {
		int size = list.length;

		int[] left = new int[size];
		Stack<Integer> leftStack = new Stack<Integer>();
		leftStack.add(0);
		left[0] = 0;
		for (int i = 1; i < size; i++) {
			if (!leftStack.isEmpty() && list[leftStack.peek()] > list[i]) {
				left[i] = 0;
				leftStack.add(i);
			} else {
				while (!leftStack.isEmpty() && list[leftStack.peek()] <= list[i]) {
					leftStack.pop();
				}
				if (leftStack.isEmpty()) {
					left[i] = i;
				} else {
					left[i] = i - leftStack.peek() - 1;
				}
				leftStack.add(i);
			}
		}

		int[] right = new int[size];
		Stack<Integer> rightStack = new Stack<Integer>();
		rightStack.add(size - 1);
		right[size - 1] = 0;
		for (int i = size - 2; i >= 0; i--) {
			if (!rightStack.isEmpty() && list[rightStack.peek()] > list[i]) {
				right[i] = 0;
				rightStack.add(i);
			} else if (!rightStack.isEmpty() && list[rightStack.peek()] == list[i]) {
				right[i] = 0;
			} else {
				while (!rightStack.isEmpty() && list[rightStack.peek()] < list[i]) {
					rightStack.pop();
				}
				if (rightStack.isEmpty()) {
					right[i] = size - 1 - i;
				} else {
					right[i] = rightStack.peek() - i - 1;
				}
				rightStack.add(i);
			}
		}

		int sum = 0;
		for (int i = 0; i < size; i++) {
			int r = right[i];
			int l = left[i];
			int k = l+r+1;
			sum = ((calc(k) - calc(r) - calc(l))*list[i])%MOD;
		}
		return sum;
	}
	
	static int calc(int i) {
		int sum = 0; 
		for (int j = 1; j <= i; j++) {
			sum = (sum+((j*(j+1))%MOD))%MOD;
		}
		return sum/2;
		
	}
}