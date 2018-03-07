package com.sort;

public class CountSort {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 7, 4, 3, 6, 5, 8, 6, 9, 4, 3, 0, 0 };
		print(arr);
		countSort(arr, 10);
		print(arr);
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void countSort(int[] arr, int k) {
		int[] output = new int[arr.length];
		int[] count = new int[k];

		for (int i = 0; i < k; i++) {
			count[i] = 0;
		}

		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}

		for (int i = 1; i < k; i++) {
			count[i] += count[i - 1];
		}

		for (int i = 0; i < arr.length; ++i) {
			count[arr[i]]--;
			output[count[arr[i]]] = arr[i];
		}

		for (int i = 0; i < arr.length; ++i) {
			arr[i] = output[i];
		}
	}
}