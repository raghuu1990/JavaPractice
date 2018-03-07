package com.prem.sorting;

import java.util.Arrays;

import com.prem.util.CodeUtil;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 5, 3, 9, 1, 0, 8 };
		QuickSort sort = new QuickSort();
		//sort.quickSort(arr,0,arr.length-1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(sort.quickSelect(arr, i));
		}
		System.out.println(Arrays.toString(arr));
	}

	public void quickSort(int[] arr, int low, int high) {
		if (low >= high)
			return;
		// find pivot position, element at pivot position is sorted i.e. smaller
		// elements on left side and
		// larger on right side.
		int pivot = partition(arr, low, high);
		// element at pivot position is at right place
		// sort before pivot position
		quickSort(arr, low, pivot - 1);
		// sort after pivot position
		quickSort(arr, pivot + 1, high);
	}

	public int quickSelect(int arr[], int k) {
		int low = 0;
		int high = arr.length - 1;
		while (true) {
			int pivot = partition(arr, low, high);
			if (pivot == k) {
				return arr[pivot];
			}
			if (pivot > k) {
				high = pivot - 1;
			} else {
				low = pivot + 1;
			}
		}
	}

	public int partition(int[] arr, int low, int high) {
		int pivot = low;
		low++;
		while (low < high) {
			while (arr[low] < arr[pivot] && low < high) { // low should not exceed high i.e. {5,1,2,3} AOBException
				low++;
			}
			while (arr[high] > arr[pivot]) { // it'll not go AOBException maximum happen high and pivot can meet
				high--;
			}
			if (arr[low] > arr[high] && low < high) { // swap if element at low is greater than element at high
				CodeUtil.swap(arr, low, high);
			}
		}
		if (arr[pivot] > arr[high]) {
			CodeUtil.swap(arr, high, pivot);
		}
		return high;
	}
}