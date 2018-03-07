package com.search;

public class SearchInRotetedArray {
	public static void main(String[] args) {
		// int [] arr = {0,1,2};
		// int [] arr = {1,2,3,4,5,6,7,8,9};
		int[] arr = { 10, 11, 12, 13, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// int [] arr = {10,11,12,13,14,15,16,17,18,19,20,1,2,3,4,5,6,7,8,9};

		System.out.println(getIndex(arr, 12));

		for (int i = 0; i < arr.length + 1; i++) {
			// System.out.println(getIndex(arr,i));
		}
	}

	public static int binarySearch(int[] arr, int no) {
		int min = 0;
		int max = arr.length - 1;

		while (min <= max) {
			int mid = (min + max) / 2;
			if (arr[mid] == no) {
				return mid;
			} else if (arr[mid] < no) {
				min = mid + 1;
			} else if (arr[mid] > no) {
				max = mid - 1;
			}
		}
		return -1;
	}

	public static int getChangeindex(int[] arr, int no) {
		int min = 0;
		int max = arr.length - 1;
		while (min <= max) {
			int mid = (min + max) / 2;
			if (arr[min] < arr[mid]) {

			} else if (arr[mid] < arr[max]) {

			}
		}
		return -1;
	}

	public static int getIndex(int[] arr, int no) {
		int min = 0;
		int max = arr.length - 1;
		while (min <= max) {
			int mid = (min + max) / 2;
			if (arr[mid] == no) {
				return mid;
			} else if (arr[mid] < no) {
				min = mid + 1;
			} else if (arr[mid] > no) {
				max = mid - 1;
			}
		}
		return -1;
	}
}