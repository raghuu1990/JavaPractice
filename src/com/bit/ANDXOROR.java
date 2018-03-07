package com.bit;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

// https://www.hackerrank.com/challenges/and-xor-or/problem

public class ANDXOROR {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int arr[] = new int[t];
		for (int i = 0; i < t; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println(andOrXor(arr));
		in.close();
	}

	public static int andOrXor(int[] arr) {
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!stack.isEmpty() && arr[i] < stack.peek()) {
				while (!stack.isEmpty() && stack.peek() > arr[i]) {
					max = Math.max(max, stack.pop() ^ arr[i]);
				}
			} else if (!stack.isEmpty() && arr[i] > stack.peek()) {
				max = Math.max(max, stack.peek() ^ arr[i]);
			}
			stack.push(arr[i]);
		}
		
		stack = new Stack<Integer>();
		for (int i = arr.length; i >=0 ; i--) {
			if (!stack.isEmpty() && arr[i] < stack.peek()) {
				while (!stack.isEmpty() && stack.peek() > arr[i]) {
					max = Math.max(max, stack.pop() ^ arr[i]);
				}
			} else if (!stack.isEmpty() && arr[i] > stack.peek()) {
				max = Math.max(max, stack.peek() ^ arr[i]);
			}
			stack.push(arr[i]);
		}
		return max;
	}
}