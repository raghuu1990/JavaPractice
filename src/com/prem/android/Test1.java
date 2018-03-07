package com.prem.android;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// int n = Integer.parseInt(in.nextLine());
		// int m = Integer.parseInt(in.nextLine());
		int rows = 4;
		int cols = 4;
		int[][] matrix = { { 1, 1, 0, 0 }, { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 1, 0, 0, 0 } };

		// int[][] arr = new int[n][m];
		boolean[][] visited = new boolean[4][4];

		/*
		 * for (int i = 0; i < n; i++) { String[] input = in.nextLine().split(
		 * " "); for (int j = 0; j < input.length; j++) { arr[i][j] =
		 * Integer.parseInt(input[j]); } }
		 */
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (!visited[i][j] && matrix[i][j] == 1) {
					max = Math.max(max, dfs(matrix, visited, i, j));
				}
			}
		}
		in.close();
		System.out.println(max);
	}

	public static int dfs(int[][] matrix, boolean[][] visited, int i, int j) {

		visited[i][j] = true;
		int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 } };
		int count = 0;
		for (int k = 0; k < dir.length; k++) {
			int newX = i + dir[k][0];
			int newY = j + dir[k][1];
			if (isValid(newX, newY, visited, matrix))
				continue;
			count += dfs(matrix, visited, newX, newY);
		}
		return count + 1;

	}

	public static boolean isValid(int newX, int newY, boolean[][] visited, int[][] matrix) {
		return newX < 0 || newY < 0 || newX >= matrix.length || newY >= matrix[0].length || visited[newX][newY]
				|| matrix[newX][newY] == 0;
	}

}
