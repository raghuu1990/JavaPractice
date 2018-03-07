package com.hackerrank.worldcodesprint12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.hackerrank.com/contests/world-codesprint-12/challenges/red-knights-shortest-path/submissions/code/1304475331

public class RedKnightsShortestPath {
	private static int N_MAX;
	private static int[] X = { -2, -2, 0, 2, 2, 0 };
	private static int[] Y = { -1, 1, 2, 1, -1, -2 };

	private static String[] Z = { "UL", "UR", "R", "LR", "LL", "L" };

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int i_start = in.nextInt();
		int j_start = in.nextInt();
		int i_end = in.nextInt();
		int j_end = in.nextInt();
		printShortestPath(n, i_start, j_start, i_end, j_end);
		in.close();
	}

	public static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
		N_MAX = n;
		boolean[][] visited = new boolean[n][n];
		Queue<Move> queue = new LinkedList<Move>();
		Move first = new Move(i_start, j_start);
		queue.add(first);
		while (!queue.isEmpty()) {
			Move curr = queue.poll();
			if (visited[curr.X][curr.Y]) {
				continue;
			} else {
				visited[curr.X][curr.Y] = true;
			}
			for (int i = 0; i < 6; i++) {
				Move nextMove = getNextMove(curr, i);
				if (nextMove != null) {
					if (nextMove.X == i_end && nextMove.Y == j_end) {
						printPath(nextMove.path);
						return;
					} else {
						queue.add(nextMove);
					}
				}
			}
		}
		System.out.println("Impossible");
	}

	public static void printPath(LinkedList<String> path) {
		System.out.println(path.size());
		while (!path.isEmpty()) {
			System.out.print(path.poll() + " ");
		}

	}

	public static Move getNextMove(Move move, int index) {
		int x = move.X + X[index];
		int y = move.Y + Y[index];
		if (x < 0 || x >= N_MAX || y < 0 || y >= N_MAX) {
			return null;
		}
		LinkedList<String> path = new LinkedList<String>();
		path.addAll(move.path);
		path.add(Z[index]);
		return new Move(x, y, path);
	}
}

class Move {
	int Y;
	int X;
	LinkedList<String> path;

	public Move(int x, int y) {
		this.X = x;
		this.Y = y;
		this.path = new LinkedList<String>();
	}

	public Move(int x, int y, LinkedList<String> path) {
		this.X = x;
		this.Y = y;
		this.path = path;
	}
}