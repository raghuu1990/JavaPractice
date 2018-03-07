package com.stack;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		int[] arr = {11, 13, 3, 21};
		// int[] arr = {4, 5, 2, 25};
		// int[] arr = {13, 7, 6, 12};
	
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}

		arr = nextGreaterElement(arr);
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	private static int[] nextGreaterElement(int[] arr) {
		int result [] = new int[arr.length];
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = result.length-1; i >= 0; i--) {
			int value = arr[i];
			while(!stack.isEmpty() && !(stack.peek()>value)) {
				stack.pop();
			}
			if(!stack.isEmpty()) {
				result[i] = stack.peek();
			}else {
				result[i] = -1;
			}
			stack.add(value);
		}
		return result;
	}
}