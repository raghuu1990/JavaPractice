package com.random;

public class RandomCountrySelectionByPopluation {
	public static void main(String args[]) {
		// int arr[] = { 5, 5, 2, 3, 7, 1 };
		int arr[] = { 1, 2, 4, 9, 17, 32 };
		for (int i = 0; i < 10; i++) {
			System.out.println(getRandom(arr) + " ");
		}
	}

	public static int getRandom(int[] arr) {
		int sum[] = new int[arr.length];
		sum[0] = arr[0];
		int n = arr[0];
		for (int i = 1; i < sum.length; i++) {
			sum[i] = sum[i - 1] + arr[i];
			n += arr[i];
		}

		// 1 to n-1
		int ran = (int) (Math.random() * n + 1);
		System.out.print(ran+" ");
		
		return indexOfFirstHigher(sum, ran);
	}

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