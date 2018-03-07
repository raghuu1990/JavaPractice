package com.search;

public class BinarySearch {
	public static void main(String[] args) {
		int arr[] = { 0, 2, 4, 5, 7, 9, 12, 15, 20 };
		System.out.println(ceilIndex(arr, 0, 0, 0));
		System.out.println(ceilIndex(arr, 0, 1, 0));
		System.out.println(ceilIndex(arr, 0, 1, 2));
		System.out.println(ceilIndex(arr, 0, 2, 4));
		System.out.println(ceilIndex(arr, 0, 3, 5));
		System.out.println(ceilIndex(arr, 0, 4, 7));
		System.out.println(ceilIndex(arr, 0, 5, 9));
		System.out.println(ceilIndex(arr, 0, 6, 12));
		System.out.println(ceilIndex(arr, 0, 6, 12));
		System.out.println(ceilIndex(arr, 0, 7, 25));
		System.out.println(ceilIndex(arr, 0, 8, 20));

		final int arr1[] = { 1, 2, 4, 5, 7, 8 };
		System.out.println(search(arr1, -1));
		System.out.println(search(arr1, 1));
		System.out.println(search(arr1, 7));
		System.out.println(search(arr1, 2));
	}

	// Index of next higher, if not last, No duplicate and sorted
	public static int ceilIndex(int arr[], int low, int high, int value) {
		while (low < high) {
			int mid = low + ((high - low) / 2);
			if (arr[mid] >= value) {
				high = mid;
			} else {
				low = mid;
			}
		}
		return high;
	}
	
	public static int search(int arr[], int value) {
		int low = 0;
		int high = arr.length - 1;
		int mid;
		while (low <= high) {
			mid = low + ((high - low) / 2);
			if (arr[mid] == value) {
				return mid;
			} else if (arr[mid] < value) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
	
	// Index of next higher
	static int indexOfFirstHigher(int[] arr, int ran) {
		int low = 0;
		int high = arr.length - 1;
		int mid = (high + low) / 2;
		
		while (true && mid<arr.length) {
			if (arr[mid] >= ran && (mid - 1 == -1 || arr[mid - 1] < ran)) {
				break;
			}
			if (arr[mid] > ran) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
			mid = (high + low) / 2;
		}
		if(mid>=arr.length) {
			return -1;
		}
		return mid;
	}
}