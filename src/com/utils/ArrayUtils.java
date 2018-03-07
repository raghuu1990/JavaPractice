package com.utils;

public class ArrayUtils {
	public static int getNoOfZeroInArray(int arr[]) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				count++;
			}
		}
		return count;
	}

	public static int[] shiftRight(int[] array) {
		int length = array.length;
		int temp = array[length - 1];
		for (int i = length - 1; i > 0; i--) {
			array[i] = array[i - 1];
		}
		array[0] = temp;
		return array;
	}

	public static void print(int[] array) {
		int length = array.length;
		System.out.print(array[0]);
		if (length > 1) {
			for (int index = 1; index < length; index++) {
				System.out.print(",");
				System.out.print(array[index]);
			}
		}
	}
	
	public static int[] getArray(int size) {
		int [] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i]=i+1;
		}
		return arr;
	}

	public static int[] getReverseArray(int size) {
		int[] arr = new int[size];
		for (int i = size + 1; i > 0; i++) {
			arr[i - 1] = i;
		}
		return arr;
	}
}