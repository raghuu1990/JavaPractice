package com.array;

import java.util.Arrays;

public class RearrangePositiveNegative {

	// complexity O(n)
	public static void main(String[] args) {
		int arr1[] = { 1, 2, 3, -4, -1, 4 };
		int arr2[] = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };
		int arr3[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};

		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arrange1(arr1)));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arrange1(arr2)));
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.toString(arrange1(arr3)));
	}

	// if order does not matter
	public static int[] arrange1(int arr[]) {
		int n = arr.length;
		int i = -1, temp = 0;
		for (int j = 0; j < n; j++) {
			if (arr[j] < 0) {
				i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int pos = i + 1, neg = 0;

		while (pos < n && neg < pos && arr[neg] < 0) {
			temp = arr[neg];
			arr[neg] = arr[pos];
			arr[pos] = temp;
			pos++;
			neg += 2;
		}
		return arr;
	}

	public static int[] arrange(int[] arr) {
		int negIndex = -1;
		int posIndex = -1;

		for (int count = 0; count < arr.length; count++) {
			if (count % 2 == 0) { // even place , set negative
				negIndex = nextNegativeIndex(arr, negIndex);
				if (negIndex == -1) {
					break;
				}
				if (negIndex == count) {
					continue;
				}
				int temp = arr[negIndex];
				for (int j = negIndex; j > count; j--) {
					arr[j] = arr[j - 1];
				}
				arr[count] = temp;
			} else { // odd place , set positive
				posIndex = nextPositiveIndex(arr, posIndex);
				if (negIndex == -1) {
					break;
				}
				if (posIndex == count) {
					continue;
				}
				int temp = arr[posIndex];
				for (int j = posIndex; j > count; j--) {
					arr[j] = arr[j - 1];
				}
				arr[count] = temp;
			}
		}
		return arr;
	}

	private static int nextNegativeIndex(int[] arr, int j) {
		for (int i = j + 1; i < arr.length; i++) {
			if (arr[i] < 0) {
				return i;
			}
		}
		return -1;
	}

	private static int nextPositiveIndex(int[] arr, int j) {
		for (int i = j + 1; i < arr.length; i++) {
			if (arr[i] >= 0) {
				return i;
			}
		}
		return -1;
	}
}
