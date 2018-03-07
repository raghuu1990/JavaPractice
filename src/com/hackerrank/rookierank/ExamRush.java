package com.hackerrank.rookierank;

import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/contests/rookierank-4/challenges/exam-rush

public class ExamRush {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int t = in.nextInt();
		int[] tm = new int[n];
		for (int tm_i = 0; tm_i < n; tm_i++) {
			tm[tm_i] = in.nextInt();
		}
		int result = examRush(tm, t);
		System.out.println(result);
		in.close();
	}

	public static int examRush(int[] arr, int t) {
		Arrays.sort(arr);
		int sum = 0;
		int i = 0;
		for (; i < arr.length - 1; i++) {
			sum += arr[i];
			if (sum > t) {
				break;
			}
		}
		return i;
	}
}
