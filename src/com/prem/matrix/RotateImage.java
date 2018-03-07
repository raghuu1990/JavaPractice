package com.prem.matrix;

/**
 * Created by lovebharti on 10/10/16.
 */
public class RotateImage {
	public void rotate(int[][] matrix) {
		int rowPos = matrix.length - 1;
		int colPos = matrix[0].length - 1;

		for (int j = 0; j <= matrix.length / 2; j++) {
			for (int i = 0; i < matrix[0].length - 1; i++) {
				int temp = matrix[i][colPos - j];
				matrix[i][colPos - j] = matrix[j][i];
				temp = matrix[rowPos - j][colPos - i];
			}
		}
	}
}