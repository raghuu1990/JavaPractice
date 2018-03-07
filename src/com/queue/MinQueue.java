package com.queue;

import java.util.PriorityQueue;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/jesse-and-cookies
public class MinQueue {
	private static PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int S = in.nextInt();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < T; i++) {
			int data = in.nextInt();
			minQueue.add(data);
			if(max<data) {
				max = data;
			}
		}

		System.out.println(solve(S, max));
		in.close();
	}

	private static int solve(int s, int max) {
		int t = 0;
		while (minQueue.peek() < s) {
			int a = minQueue.poll();
			if (minQueue.peek() == null) {
				return -1;
			}
			int b = minQueue.poll();
			minQueue.add(a + 2 * b);
			if(max<a + 2 * b) {
				max = a + 2 * b;
			}
			t++;
		}
		return t;
	}
}