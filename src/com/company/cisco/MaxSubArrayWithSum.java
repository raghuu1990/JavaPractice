package com.company.cisco;

import java.util.Scanner;

// Longest continious subarray length sum less and equal

public class MaxSubArrayWithSum {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		
		int a[] = new int[m];
		for (int i = 0; i < m; i++) {
			a[i] = s.nextInt();
		}
		int k = s.nextInt();
		int c = maxLength(a, k);
		System.out.println(c);
		s.close();
	}

	public static int maxLength(int[] a, int k) {
		int l = 0;
		int sum = 0;
		int end = 0;

		for (int start = 0; start < a.length; start++) {
			if(start==end) {
				sum = a[start];
			}else {
				sum -= a[start - 1];
			}
			if (sum < k) {
				while (sum < k && end < a.length - 1) {
					end++;
					sum += a[end];
				}
			} else if (sum > k) {
				while (sum > k && end < a.length && end>start) {
					sum -= a[end];
					end--;
				}
			}
			if (sum == k) {
				if (l < (end - start + 1)) {
					l = end - start + 1;
				}
			} else if (sum > k) {
				if (l < (end - start)) {
					l = end - start;
				}
			}
		}
		return l;
	}
}