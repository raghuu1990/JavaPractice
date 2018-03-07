package com.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/equal-stacks/problem

public class EqualStacks {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		MyStack2 stack1 = new MyStack2();
		MyStack2 stack2 = new MyStack2();
		MyStack2 stack3 = new MyStack2();

		int n1 = in.nextInt();
		int n2 = in.nextInt();
		int n3 = in.nextInt();

		for (int i = 0; i < n1; i++) {
			stack1.add(in.nextInt());
		}

		for (int i = 0; i < n2; i++) {
			stack2.add(in.nextInt());
		}

		for (int i = 0; i < n3; i++) {
			stack3.add(in.nextInt());
		}

		System.out.println(equalStack(stack1, stack2, stack3));
		in.close();
	}

	private static int equalStack(MyStack2 stack1, MyStack2 stack2, MyStack2 stack3) {
		while (!areEqual(stack1, stack2, stack3)) {
			if (stack1.size == 0 || stack2.size == 0 || stack3.size == 0) {
				return 0;
			}
			if (stack1.sum > stack2.sum && stack1.sum > stack3.sum) {
				stack1.remove();
			} else if (stack2.sum > stack1.sum && stack2.sum > stack3.sum) {
				stack2.remove();
			} else if (stack3.sum > stack1.sum && stack3.sum > stack2.sum) {
				stack3.remove();
			} else if (stack1.sum == stack2.sum && stack1.sum > stack3.sum) {
				stack1.remove();
				stack2.remove();
			} else if (stack2.sum == stack3.sum && stack2.sum > stack1.sum) {
				stack2.remove();
				stack3.remove();
			} else if (stack3.sum == stack1.sum && stack3.sum > stack2.sum) {
				stack1.remove();
				stack3.remove();
			} else if (areEqual(stack1, stack2, stack3)) {
				break;
			}
		}
		return stack1.sum;
	}

	private static boolean areEqual(MyStack2 stack1, MyStack2 stack2, MyStack2 stack3) {
		if (stack1.sum == stack2.sum && stack2.sum == stack3.sum) {
			return true;
		}
		return false;
	}
}

class MyStack2 {
	int size = 0;
	int sum = 0;
	Queue<Integer> stack = new LinkedList<Integer>();

	public void add(int value) {
		stack.add(value);
		sum += value;
		size = stack.size();
	}

	public int remove() {
		int value = -1;
		if (stack.size() > 0) {
			value = stack.poll();
			sum -= value;
			size = stack.size();
		}
		return value;
	}
}