package com.stack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

// https://www.hackerrank.com/challenges/waiter/problem

public class Waiter {
	public static ArrayList<Integer> primes = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		primes = getFirstNPrimes(q);
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			stack.push(in.nextInt());
		}
		solve(stack, q);
		in.close();
	}

	public static void solve(Stack<Integer> stack, int q) {
		Stack<Integer> stackB = new Stack<Integer>();
		Stack<Integer> stackA = new Stack<Integer>();
		int i = 1;
		while(i<=q) {
			int prime = primes.get(i-1);
			while(!stack.isEmpty()) {
				int pop = stack.pop();
				if(pop%prime==0) {
					stackB.add(pop);
				}else {
					stackA.add(pop);
				}
			}
			while(!stackB.isEmpty()) {
				System.out.println(stackB.pop());
			}
			stack = stackA;
			stackA = new Stack<Integer>();
			i++;
		}
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
	
	public static ArrayList<Integer> getFirstNPrimes(int n) {
		 ArrayList<Integer> primes = new ArrayList<Integer>();
		 int i = 2;
		 while(primes.size()<n) {
			 if(isPrime(i)) {
				 primes.add(i);
			 }
			 i++;
		 }
		 return primes;
	}
	
	public static boolean isPrime(int n) {
		if (n == 2) {
			return true;
		}
		if (n % 2 == 0) {
			return false;
		}
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}