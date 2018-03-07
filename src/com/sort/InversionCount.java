package com.sort;

import java.util.Scanner;

public class InversionCount {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			int[] output = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
				output[i] = arr[i];
			}
			long result = mergeSort(arr, output, 0, arr.length - 1);
			System.out.println(result);
		}
		in.close();
	}

	private static long mergeSort(int[] arr, int[] outPut, int low, int high) {
		if (low >= high) {
			return 0;
		}
		long count = 0;
		int mid = low + ((high - low) / 2);
		count += mergeSort(outPut, arr, low, mid);
		count += mergeSort(outPut, arr,  mid + 1, high);
		count += mergeArrays(arr, outPut, low, mid + 1, high);
		return count;
	}

	private static long mergeArrays(int[] arr, int[] outPut, int low, int mid, int high) {
		int leftStart = low;
		int leftEnd = mid-1;
		int rightStart = mid;
		int rightEnd = high;
		int index = low;

		long count = 0;
		while (leftStart <= leftEnd && rightStart <= rightEnd) {
			if (outPut[leftStart] <= outPut[rightStart]) {
				arr[index] = outPut[leftStart];
				leftStart++;
				index++;
			} else {
				arr[index] = outPut[rightStart];
				count+= rightStart-index;
				rightStart++;
				index++;
				
			}
		}

		for (int i = leftStart; i <= leftEnd; i++) {
			arr[index] = outPut[leftStart];
			leftStart++;
			index++;
		}

		for (int i = rightStart; i <= rightEnd; i++) {
			arr[index] = outPut[rightStart];
			rightStart++;
			index++;
		}
		return count;
	}
}
