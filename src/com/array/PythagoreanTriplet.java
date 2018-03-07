package com.array;

import java.util.Arrays;
import java.util.Scanner;

public class PythagoreanTriplet {
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		String [] result = new String[t];
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int [] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = in.nextInt();
			}
			result[i]= pythagoreanTriplet(arr); 
		}
		for (int i = 0; i < result.length; i++) {
		    System.out.println(result[i]);
		}
		in.close();
	}

	private static String pythagoreanTriplet(int[] arr) {
		int l = arr.length;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] * arr[i];
		}
		Arrays.sort(arr);
		for (int i = l - 1; i > 1; i--) {
			int j = 0;
			int k = i - 1;
			while (j < k && j < i) {
				if ((arr[j] + arr[k]) == arr[i]) {
					return "Yes";
				} else if ((arr[j] + arr[k])<arr[i]) {
					j++;
				} else {
					k--;
				}
			}
		}
		return "No";
	}
}