package com.prem.android;

public class Test2 {
	/* IMPORTANT: Multiple classes and nested static classes are supported */
	// class Test2 {
	public static void main(String args[]) throws Exception {
		// Scanner s = new Scanner(System.in);
		/*
		 * int rows = s.nextInt(); int cols = s.nextInt();
		 */
		int rows = 4;
		int cols = 4;

		int matrix[][] = new int[rows][cols];
		boolean[][] visited = new boolean[rows][cols];
		int[][] arr = { { 1, 1, 0, 0 }, { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 1, 0, 0, 0 } };

		/*
		 * for(int j=0;j<rows;j++){ for(int i=0;i<cols;i++){
		 * matrix[j][i]=s.nextInt(); } }
		 */

		int max = Integer.MIN_VALUE;
		for (int j = 0; j < rows; j++) {
			for (int i = 0; i < cols; i++) {
				if (!visited[j][i] && matrix[j][i] == 1) {
					max = Math.max(max, dfs(matrix, visited, j, i));
				}
			}
		}
		System.out.println(max);

	}

	public static int dfs(int[][] matrix, boolean[][] visited, int j, int i) {
		visited[j][i] = true;
		int[][] around = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 } };
		int count = 0;
		for (int k = 0; k < around.length; k++) {
			int newX = j + around[k][0];
			int newY = i + around[k][1];
			if (newX < 0 || newY < 0 || newX >= matrix.length || newY >= matrix[0].length || visited[newX][newY]
					|| matrix[newX][newY] == 0)
				continue;
			count += dfs(matrix, visited, newY, newX);
		}
		return count + 1;
	}
}