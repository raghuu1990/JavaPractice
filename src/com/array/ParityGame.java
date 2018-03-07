package com.array;

import java.util.Scanner;

public class ParityGame {
	static int smallestSizeSubsequence(int n, int[] A) {
		int sum = 0;
		boolean hasOdd = false;
		for (int i = 0; i < n; i++) {
			sum += A[i];
			if (A[i] % 2 != 0) {
				hasOdd = true;
			}
		}
		if (sum % 2 == 0) {
			return 0;
		} else if (hasOdd) {
			if(n==1){
				return -1;
			}
			return 1;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] A = new int[n];
		for (int A_i = 0; A_i < n; A_i++) {
			A[A_i] = in.nextInt();
		}
		int result = smallestSizeSubsequence(n, A);
		in.close();
		System.out.println(result);
	}
}
