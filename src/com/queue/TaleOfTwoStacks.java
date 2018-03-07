package com.queue;

import java.util.Scanner;
import java.util.Stack;

// https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem

public class TaleOfTwoStacks {

	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			int operation = scan.nextInt();
			if (operation == 1) { // enqueue
				queue.enqueue(scan.nextInt());
			} else if (operation == 2) { // dequeue
				queue.dequeue();
			} else if (operation == 3) { // print/peek
				System.out.println(queue.peek());
			}
		}
		scan.close();
	}
}

class MyQueue<T> {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void enqueue(int value) {
		stack1.add(value);
	}

	public Integer peek() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.add(stack1.pop());
			}
		}
		if (!stack2.isEmpty()) {
			return stack2.peek();
		}
		return null;
	}

	public void dequeue() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.add(stack1.pop());
			}
		}
		if (!stack2.isEmpty()) {
			stack2.pop();
		}
	}
}