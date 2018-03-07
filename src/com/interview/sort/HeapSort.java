package com.interview.sort;

/**
 * Heap Sort Given an array sort it using heap sort
 * 
 * Solution : First convert the original array to create the heap out of the
 * array Then move the max element to last position and do heapify to recreate
 * the heap with rest of the array element. Repeat this process
 * 
 * Time complexity O(nlogn)
 * 
 * Test cases Null array 1 element array 2 element array sorted array reverse
 * sorted array
 */
public class HeapSort {
	public static void main(String args[]) {
		int arr[] = { -1, 5, 8, 2, -6, -8, 11, 5 };
		sort(arr);
		print(arr);
	}

	public static void sort(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			heapAdd(arr, i);
		}

		for (int i = arr.length - 1; i > 0; i--) {
			swap(arr, 0, i);
			heapify(arr, i - 1);
		}
	}

	private static void heapAdd(int arr[], int end) {
		int i = end;
		while (i > 0) {
			if (arr[i] > arr[(i - 1) / 2]) {
				swap(arr, i, (i - 1) / 2);
				i = (i - 1) / 2;
			} else {
				break;
			}
		}
	}

	private static void heapify(int arr[], int end) {
		int i = 0;
		int leftIndex;
		int rightIndex;
		while (i <= end) {
			leftIndex = 2 * i + 1;
			if (leftIndex > end) {
				break;
			}
			rightIndex = 2 * i + 2;
			if (rightIndex > end) {
				rightIndex = leftIndex;
			}
			if (arr[i] >= Math.max(arr[leftIndex], arr[rightIndex])) {
				break;
			}
			if (arr[leftIndex] >= arr[rightIndex]) {
				swap(arr, i, leftIndex);
				i = leftIndex;
			} else {
				swap(arr, i, rightIndex);
				i = rightIndex;
			}
		}
	}

	private static void swap(int arr[], int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}