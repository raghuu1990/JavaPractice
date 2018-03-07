package com.problems;

import java.util.Scanner;

public class SellTicket {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println("Max revenue : " + maxRevenue(arr, m));
		in.close();
	}

	private static int maxRevenue(int[] arr, int m) {
		int revenue = 0;
		for (int i = 0; i < m; i++) {
			int maxIndex = getIndexOfMax(arr);
			if (maxIndex < 0)
				break;
			revenue += arr[maxIndex];
			arr[maxIndex]--;
		}
		return revenue;
	}

	private static int getIndexOfMax(int[] arr) {
		int max = 0;
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				index = i;
			}
		}
		return index;
	}
}