package com.hackerrank.weekofcode35;

import java.util.Arrays;

public class SetMaxSubSequenceSum {

	public static void main(String[] args) {

		int[] matrix2 = { -5, -8, -1, 2, -150 };
		System.out.print(Arrays.toString(matrix2));
		setMaxSubSequenceSum(matrix2);
		System.out.println(Arrays.toString(matrix2));

 		/*int[] matrix1 = { 1, 2, 3, -1, -2 };
		System.out.print(Arrays.toString(matrix1));
		setMaxSubSequenceSum(matrix1);
		System.out.println(Arrays.toString(matrix1));
		
		int[] matrix3 = { 1, 2, 3, -250, 100 };
		System.out.print(Arrays.toString(matrix3));
		setMaxSubSequenceSum(matrix3);
		System.out.println(Arrays.toString(matrix3));*/

	}

	private static void setMaxSubSequenceSum(int[] matrix) {
		int size = matrix.length;
		int maxSum = matrix[0], curr_max = 0, start = 0, end = 0, s = 0;

		for (int i = 0; i < size; i++) {
			if (matrix[i] < 0 && curr_max>0) {
				updateMatrix(matrix, curr_max, start, i - 1);
				start = i;
			}else if(matrix[i] < 0 && i!=0) {
				curr_max = matrix[i];
				start = i;
			}
			curr_max += matrix[i];
			/*if(curr_max>matrix[i]) {
				updateMatrix(matrix, curr_max, start, i-1);
				start=i;
			}*/
			if (maxSum < curr_max) {
				maxSum = curr_max;
				end = i;
			} else if (maxSum > curr_max && curr_max > matrix[i]) {
				//updateMatrix(matrix, curr_max, start, i);
				//start = i + 1;
			}

			if (curr_max < matrix[i]) {
				updateMatrix(matrix, curr_max, start, i-1);
				curr_max = matrix[i];
				start = i + 1;
				end = i;
			}
		}
		updateMatrix(matrix, curr_max, start,  matrix.length-1);
	}

	private static void updateMatrix(int[] matrix, int value, int startCol, int endCol) {
		if (startCol < 0 || endCol < 0 || startCol >= matrix.length || endCol >= matrix.length) {
			return;
		}
		for (int i = startCol; i <= endCol; i++) {
			if (matrix[i] < value) {
				matrix[i] = value;
			}
		}
	}
}