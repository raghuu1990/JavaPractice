package com.stack;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

import com.io.Reader;

// https://www.hackerrank.com/challenges/game-of-two-stacks/problem

public class GameOfTwoStacks {
	public static int max = 0;

	public static void main(String[] args) throws IOException {
		//Scanner in = new Scanner(System.in);
		Reader in = new Reader();
		int t = in.nextInt();
		for (int j = 0; j < t; j++) {
			max = 0;
			Stack<Integer> stack1 = new Stack<Integer>();
			Stack<Integer> stack2 = new Stack<Integer>();

			int n1 = in.nextInt();
			int n2 = in.nextInt();
			int maxSum = in.nextInt();

			LinkedList<Integer> list1 = new LinkedList<Integer>();
			for (int i = 0; i < n1; i++) {
				list1.add(in.nextInt());
			}
			Collections.reverse(list1);
			stack1.addAll(list1);

			LinkedList<Integer> list2 = new LinkedList<Integer>();
			for (int i = 0; i < n2; i++) {
				list2.add(in.nextInt());
			}
			Collections.reverse(list2);
			stack2.addAll(list2);

			maxScore(stack1, stack2, maxSum);
			System.out.println(max);
		}
		in.close();
	}

	private static void maxScore(Stack<Integer> stack1, Stack<Integer> stack2, int maxSum) {
		Stack<Integer> newStack1 = new Stack<Integer>();
		int count = 0;
		int sum = 0;
		while (!stack1.isEmpty() && (sum+stack1.peek()) <= maxSum) {
			sum+=stack1.peek();
			count++;
			newStack1.add(stack1.peek());
			stack1.pop();
		}

		max = count;
		Stack<Integer> newStack2 = new Stack<Integer>();
		
		while(!stack2.isEmpty() && newStack1.size()>=0) {
			sum+=stack2.peek();
			newStack2.add(stack2.pop());

			while(sum > maxSum && newStack1.size()>0) {
				sum-=newStack1.peek();
				stack1.add(newStack1.peek());
				newStack1.pop();
			}
			
			if(sum<=maxSum) {
				count = newStack1.size()+ newStack2.size();
				max = Math.max(count, max);
			}
		}
	}
}