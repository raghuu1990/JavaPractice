package com.search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/knightl-on-chessboard/problem

public class KnightLOnAChessboard {
	static int n;
	static int[][] result;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		result = new int[n][n];
		solve();

		for (int a = 1; a < n; a++) {
			for (int b = 1; b < n; b++) {
				System.out.print(b == n - 1 ? result[a][b] : result[a][b] + " ");
			}
			System.out.println();
		}
		in.close();
	}

	private static void solve() {
		for (int a = 1; a < n; a++) {
			for (int b = 1; b < n; b++) {
				if (b >= a) {
					result[a][b] = solve(a, b);
					result[b][a] = result[a][b];
				}
			}
		}
	}

	private static int solve(int a, int b) {
		boolean[][] visited = new boolean[n][n];
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(0, 0, 0));
		visited[0][0] = true;
		int[][] path = getNextStep(a, b);

		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			for (int i = 0; i < 8; i++) {
				int x1 = pair.x + path[i][0];
				int y1 = pair.y + path[i][1];
				if (x1 == n - 1 && y1 == n - 1) {
					return pair.c + 1;
				}
				if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < n && !visited[x1][y1]) {
					visited[x1][y1] = true;
					queue.add(new Pair(x1, y1, pair.c + 1));
				}
			}
		}
		return -1;
	}

	private static int[][] getNextStep(int a, int b) {
		int[][] path = new int[8][2];
		path[0][0] = a;
		path[0][1] = b;
		path[1][0] = a;
		path[1][1] = -b;
		path[2][0] = -a;
		path[2][1] = b;
		path[3][0] = -a;
		path[3][1] = -b;
		path[4][0] = b;
		path[4][1] = a;
		path[5][0] = b;
		path[5][1] = -a;
		path[6][0] = -b;
		path[6][1] = a;
		path[7][0] = -b;
		path[7][1] = -a;
		return path;
	}
}

class Pair {
	int x = 0;
	int y = 0;
	int c = 0;

	public Pair(int x, int y, int c) {
		this.x = x;
		this.y = y;
		this.c = c;
	}
}