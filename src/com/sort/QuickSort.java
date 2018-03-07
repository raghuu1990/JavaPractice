package com.sort;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 5, 3, 9, 1, 0, 8 };
		//int[] arr = { 1, 2, 3, 4, 5, 6 };
		quickSort(arr, 0, arr.length-1);
		print(arr);

		int[] arr1 = { 5, 3, 9, 1, 0, 8 };
		for (int i = 0; i < arr.length; i++) {
			System.out.print(quickSelect(arr1, i)+" ");
		}
	}

	public static void quickSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		int pivot = partitionLow(arr, left, right);
		quickSort(arr, left, pivot - 1);
		quickSort(arr, pivot + 1, right);
	}

	public static int quickSelect(int arr[], int k) {
		int left = 0;
		int right = arr.length - 1;
		while (true) {
			int pivot = partitionHigh(arr, left, right);
			if (pivot == k) {
				return arr[pivot];
			}
			if (pivot > k) {
				right = pivot - 1;
			} else {
				left = pivot + 1;
			}
		}
	}

	public static int partitionLow(int[] arr, int low, int high) {
		int pivot = low;
		low++;
		while (low < high) {
			while (arr[low] < arr[pivot] && low < high) {
				low++;
			}
			while (arr[high] > arr[pivot]) {
				high--;
			}
			if (arr[low] > arr[high] && low < high) {
				swap(arr, low, high);
			}
		}
		if (arr[pivot] > arr[high]) {
			swap(arr, high, pivot);
		}
		return high;
	}
	
	public static int partitionHigh(int[] arr, int low, int high) {
		int pivot = high;
		high--;
		while (low < high) {
			while (arr[low] < arr[pivot]) {
				low++;
			}
			while (arr[high] > arr[pivot] && high > 0) {
				high--;
			}
			if (arr[low] > arr[high] && low < high) {
				swap(arr, low, high);
			}
		}
		if (arr[pivot] < arr[low]) {
			swap(arr, low, pivot);
		}
		return low;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}