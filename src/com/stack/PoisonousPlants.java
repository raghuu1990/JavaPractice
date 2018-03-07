package com.stack;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

// https://www.hackerrank.com/challenges/poisonous-plants/problem

public class PoisonousPlants {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < t; i++) {
			stack.push(in.nextInt());
		}
		System.out.println(poisonousPlants(stack));
		in.close();
	}

	public static int poisonousPlants(Stack<Integer> poison) {
		Stack<Integer> stack = poison;
		int day = 0;
		boolean isReversed = false; 
		while(!stack.isEmpty()) {
			if(stack.size()==1) {
				break;
			}
			int size = stack.size();
			int last =  stack.pop();
			Stack<Integer> stackAfter = new Stack<>();
			if(isReversed) {
				stackAfter.push(last);
			}
			while(!stack.isEmpty()) {
				int i = stack.pop();
				if(!isReversed) {
					if(i>=last) {
						stackAfter.push(last);
					}
				}else {
					if(i<=last) {
						stackAfter.push(i);
					}
				}
				last = i;
			}
			if(!isReversed) {
				stackAfter.push(last);
			}
			if(size == stackAfter.size()) {
				break;
			}
			day++;
			stack = stackAfter;
			isReversed = !isReversed;
		}
		return day;
	}
}