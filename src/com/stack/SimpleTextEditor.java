package com.stack;

import java.io.IOException;
import java.util.Stack;

import com.io.Reader;

// https://www.hackerrank.com/challenges/simple-text-editor/problem

public class SimpleTextEditor {
	public static void main(String[] args) throws IOException {
		Reader in = new Reader();
		int t = in.nextInt();
		String s = new String();
		Stack<String> stack = new Stack<String>();
		stack.push(s);
		for (int i = 0; i < t; i++) {
			int j = in.nextInt();
			if (j == 1) {
				String word = in.nextString();
				stack.push(stack.peek() + word);
			} else if (j == 2) {
				int k = in.nextInt();
				stack.push(stack.peek().substring(0, stack.peek().length() - k));
			} else if (j == 3) {
				int k = in.nextInt();
				System.out.println(stack.peek().charAt(k - 1));
			} else if (j == 4) {
				stack.pop();
			} else {
				System.out.println("Invalid Input");
			}
		}
		in.close();
	}
}