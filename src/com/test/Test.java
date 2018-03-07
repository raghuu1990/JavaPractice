package com.test;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		for (int i = 0; i < args.length; i++) {
			String str = in.nextLine();
		}
		
		int[] arr = { -20, 1, -40, 20, 30, 40, -20, 200, -100 };
		System.out.println(getMaxSum(arr));
	}

	public static int getMaxSum(int[] arr) {
		int maxSum = 0;
		int currSum = 0;

		for (int i = 0; i < arr.length; i++) {
			currSum += arr[i];
			if (currSum < 0) {
				currSum = 0;
			}

			if (maxSum < currSum) {
				maxSum = currSum;
			}
		}
		return maxSum;
	}
	
	public static void print(String str) {
		for (int i = 0; i < str.length(); i++) {
			if(i%2==0) {
				System.out.print(str.charAt(i));
			}
		}
		System.out.print(" ");
		for (int i = 0; i < str.length(); i++) {
			if(i%2==0) {
				System.out.print(str.charAt(i));
			}
		}
	}
}
