package com.array;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/array-pairs
public class ArrayPair {
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			int a = in.nextInt();
			arr[i] = a;
		}
		System.out.println(findCount(arr));
		in.close();
	}

	private static int findCount(int[] arr) {
		int[] maxArr = new int[arr.length];
		maxArr[0] = arr[0];
		int count = 0;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]>maxArr[i-1]) {
				maxArr[i] = arr[i];
			}else {
				maxArr[i] = maxArr[i-1];
			}
		}

		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]*arr[j]<maxArr[j]) {
					count++;
				}
			}
		}
		return count;
	}
}
