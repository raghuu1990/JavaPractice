package com.prem.util;

public class CodeUtil {
	public static void display2dMatrix(int[][] matrix) {
		for (int j = 0; j < matrix.length; j++) {
			for (int i = 0; i < matrix[0].length; i++) {
				System.out.print(matrix[j][i] + " | ");
			}
			System.out.println();
		}
	}

	public static void display2dMatrix(boolean[][] matrix) {
		for (int j = 0; j < matrix.length; j++) {
			for (int i = 0; i < matrix[0].length; i++) {
				if (matrix[j][i]) {
					System.out.print("T | ");
				} else {
					System.out.print("F | ");
				}
			}
			System.out.println();
		}
	}

	public static void displayArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " | ");
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}