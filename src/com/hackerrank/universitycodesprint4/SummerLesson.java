package com.hackerrank.universitycodesprint4;

import java.util.Scanner;

public class SummerLesson {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int arr[] = new int[m];
		for (int i = 0; i < n; i++) {
			arr[in.nextInt()]++; 
		}
		for (int i = 0; i < m; i++) {
			System.out.print(arr[i]+" ");
		}
		in.close();
	}
}
