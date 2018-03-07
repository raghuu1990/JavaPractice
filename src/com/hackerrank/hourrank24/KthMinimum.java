package com.hackerrank.hourrank24;

import java.util.PriorityQueue;
import java.util.Scanner;

// https://www.hackerrank.com/contests/hourrank-24/challenges/kth-minimum/problem

public class KthMinimum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int x = in.nextInt();
		int k = in.nextInt();
		int[] a = new int[n + 1];
		for (int a_i = 1; a_i <= n; a_i++) {
			a[a_i] = in.nextInt();
		}
		int[] b = new int[m + 1];
		for (int b_i = 1; b_i <= m; b_i++) {
			b[b_i] = in.nextInt();
		}
		System.out.println(kthMinimum(a, b, x, k));
		in.close();
	}

	private static long kthMinimum(int[] A, int[] B, int x, int k) {
		PriorityQueue<Long> pq = new PriorityQueue<Long>(k);

		for (int i = 1; i <= Math.min(A.length - 1, B.length - 1 - x); i++) {
			for (int j = i + x; j <= B.length - 1; j++) {
				//System.out.println(i+" : "+j);
				pq.add((long)((long)A[i] * (long)B[j]));
			}
		}

		long result = 0;
		int i = 0;
		while (i < k && !pq.isEmpty()) {
			result = pq.poll();
			i++;
		}
		return result;
	}
}