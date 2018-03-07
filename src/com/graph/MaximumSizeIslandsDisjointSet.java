package com.graph;

// http://www.geeksforgeeks.org/find-the-number-of-islands-set-2-using-disjoint-set/
// https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem

public class MaximumSizeIslandsDisjointSet {

	public static void main(String[] args) {
		int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
								  { 0, 1, 0, 0, 1 }, 
								  { 1, 0, 0, 1, 1 }, 
								  { 0, 0, 0, 0, 0 },
								  { 1, 0, 1, 0, 1 }
								};
		System.out.println(islandsCount(M));
	}

	private static int islandsCount(int[][] m) {
		int ROW = m.length;
		int COL = m[0].length;
		int nextRow[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int nextCol[] = { 0, 1, -1, -1, 1, 0, 1, -1 };
		DisJointSet set = new DisJointSet(ROW*COL);

		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if(m[i][j]==0) {
					continue;
				}
				for (int k = 0; k < 8; k++) {
					int x = i+nextRow[k];
					int y = j+nextCol[k];
					if(isSafe(m, x, y)) {
						set.union(i*COL+j, x*COL+y);
					}
				}
			}
		}

		int maxSize = 0;
		int islandCount = 0;
		int v[] = new int[ROW * COL];
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if (m[i][j] == 1) {
					int p = set.find(i * COL + j);
					if (v[p] == 0) {
						v[p]++;
						islandCount++;
					} else {
						v[p]++;
					}
					if (maxSize < v[p]) {
						maxSize = v[p];
					}
				}
			}
		}
		//System.out.println("MaxSize : " + maxSize);
		return islandCount;
	}

	private static boolean isSafe(int[][] m, int row, int col) {
		int ROW = m.length;
		int COL = m[0].length;

		if (row >= 0 && col >= 0 && row < ROW && col < COL && m[row][col] == 1) {
			return true;
		}
		return false;
	}
}