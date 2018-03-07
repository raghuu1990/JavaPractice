package com.graph;

// http://www.geeksforgeeks.org/find-number-of-islands/

public class MaximumIslandsDFS {

	public static void main(String[] args) {
		int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
								  { 0, 1, 0, 0, 1 }, 
								  { 1, 0, 0, 1, 1 }, 
								  { 0, 0, 0, 0, 0 },
								  { 1, 0, 1, 0, 1 }
								};
		System.out.println("Number of islands is: " + islandsCount(M));
	}

	private static int islandsCount(int[][] m) {
		boolean[][] visited = new boolean[m.length][m[0].length];
		int count = 0;

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if (!visited[i][j] && m[i][j] == 1) {
					islandsCount(m, visited, i, j);
					count++;
				}
			}
		}
		return count;
	}

	private static void islandsCount(int[][] m, boolean[][] visited, int i, int j) {
		int nextRow[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int nextCol[] = { 0, 1, -1, -1, 1, 0, 1, -1 };

		visited[i][j] = true;
		for (int k = 0; k < 8; k++) {
			if (isSafe(m, visited, i + nextRow[k], j + nextCol[k])) {
				islandsCount(m, visited, i + nextRow[k], j + nextCol[k]);
			}
		}
	}

	private static boolean isSafe(int[][] m,  boolean[][] visited, int row, int col) {
		int ROW = m.length;
		int COL = m[0].length;

		if (row >= 0 && col >= 0 && row < ROW && col < COL && m[row][col] == 1 && !visited[row][col]) {
			return true;
		}
		return false;
	}
}