package com.stack;

import java.util.Stack;

public class ReverseStack {
	// http://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
	
	// Can be done as linked list reverse in O(n)
	static Stack<Character> stack = new Stack<>();

	public static void main(String[] args) {
		stack.push('1');
		stack.push('2');
		stack.push('3');
		stack.push('4');
		
		System.out.println(stack);		
		reverse();
		System.out.println(stack);
	}

	private static void reverse() {
		if(stack!=null && !stack.isEmpty()) {
			char c = stack.pop();
			reverse();
			insertBottom(c);
		}
		
	}
	
	private static void insertBottom(char x) {
		if(stack.isEmpty()) {
			stack.push(x);
		}else {
			char c = stack.pop();
			insertBottom(x);
			stack.push(c);
		}
	}
}