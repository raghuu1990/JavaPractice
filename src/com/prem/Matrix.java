package com.prem;

public class Matrix {

	int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
	int b[][] = { { 10, 11, 12 }, { 13, 14, 15 }, { 16, 17, 18 } };

	public static void main(String[] args) {
		Matrix matrix = new Matrix();
		int sum[][] = matrix.sum(matrix.a, matrix.b);
		matrix.display(sum);

		System.out.println("After transponsing sum");
		sum = matrix.transpose(sum);
		matrix.display(sum);

	}

	public int[][] sum(int a[][], int b[][]) {
		int[][] c = new int[a.length][a.length];

		for (int row = 0; row < a.length; row++) {
			for (int col = 0; col < a.length; col++) {
				c[row][col] = a[row][col] + b[row][col];
			}
		}
		return c;
	}

	public int[][] transpose(int a[][]) {
		for (int row = 0; row < a.length; row++) {
			for (int col = 0; col < a.length && row != col; col++) {
				int temp = a[row][col];
				a[row][col] = a[col][row];
				a[col][row] = temp;
			}
		}
		return a;
	}

	public void display(int a[][]) {
		for (int row = 0; row < a.length; row++) {
			for (int col = 0; col < a.length; col++) {
				System.out.print(a[row][col] + "  ");
			}
			System.out.println();
		}
	}

}