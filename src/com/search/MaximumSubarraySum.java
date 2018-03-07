package com.search;

import java.util.Scanner;
import java.util.TreeSet;

// https://www.hackerrank.com/challenges/maximum-subarray-sum/problem
// https://www.quora.com/What-is-the-logic-used-in-the-HackerRank-Maximise-Sum-problem

public class MaximumSubarraySum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int i = 0; i < q; i++) {
			int n = in.nextInt();
			long m = in.nextLong();
			long[] a = new long[n];
			for (int j = 0; j < n; j++) {
				a[j] = in.nextLong()%m;
			}
			long result = maximumSum(a, m);
			System.out.println(result);
		}
		in.close();
	}

	public static long maximumSum(long[] a, long m) {
		TreeSet<Long> set = new TreeSet<Long>();
		long sum = 0;
		long max = 0;
		for (int i = 0; i < a.length; i++) {
			sum = (sum+a[i])%m;
			max = Math.max(max, sum);
			if(set.higher(sum)!=null) {
				max = Math.max(max, (sum-set.ceiling(sum)+m)%m);
			}
			set.add(sum);
			if(max == m-1) {
				break;
			}
		}
		return max;
	}
}