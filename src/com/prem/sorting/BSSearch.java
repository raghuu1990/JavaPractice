package com.prem.sorting;

/**
 * Created by lovebharti on 17/8/16.
 */
public class BSSearch {

	public int search(int[] arr, int data) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;

			if (arr[mid] == data) {
				return mid;
			}

			if (arr[mid] < arr[high]) {
				if (data > arr[mid] && data <= arr[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else {
				if (data >= arr[low] && data < arr[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		BSSearch search = new BSSearch();
		int arr2[] = { 18, 21, 1, 2, 5, 6, 7, 8, 10, 15 };
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(search.search(arr2, arr2[i]));
		}
	}

}
