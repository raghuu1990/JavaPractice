package com.sort;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
		int n = arr.length;
		radixSort(arr, n);
		print(arr);
	}

	public static void countSort(int arr[], int n, int exp) {
		int output[] = new int[n];
		int count[] = new int[10];
		Arrays.fill(count, 0);

		for (int i = 0; i < n; i++) {
			count[(arr[i] / exp) % 10]++;
		}

		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}

		for (int i = n - 1; i >= 0; i--) {
			count[(arr[i] / exp) % 10]--;
			output[count[(arr[i] / exp) % 10]] = arr[i];
		}

		for (int i = 0; i < n; i++) {
			arr[i] = output[i];
		}
	}

	public static void radixSort(int arr[], int n) {
		int m = getMax(arr, n);
		for (int exp = 1; m / exp > 0; exp *= 10) {
			countSort(arr, n, exp);
		}
	}

	public static int getMax(int arr[], int n) {
		int mx = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > mx)
				mx = arr[i];
		return mx;
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}