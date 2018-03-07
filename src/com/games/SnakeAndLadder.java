package com.games;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/the-quickest-way-up/problem

public class SnakeAndLadder {
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[] output = new int[t];
		for (int i = 0; i < t; i++) {
			int[] board = new int[100];
			boolean[] visited = new boolean[100];
			for (int v = 0; v < 100; v++) {
				visited[v] = false;
				board[v] = -1;
			}
			int l = in.nextInt();
			for (int j = 0; j < l; j++) {
				int a = in.nextInt();
				int b = in.nextInt();
				board[a - 1] = b - 1;
			}
			int s = in.nextInt();
			for (int k = 0; k < s; k++) {
				int a = in.nextInt();
				int b = in.nextInt();
				board[a - 1] = b - 1;
			}
			output[i] = getMinimumSteps(board, visited);
		}
		for (int i = 0; i < t; i++) {
			System.out.println(output[i]);
		}
		in.close();
	}

	public static class qNode {
		int position;
		int count;

		public qNode(int position, int count) {
			this.position = position;
			this.count = count;
		}
	}

	private static int getMinimumSteps(int[] board, boolean[] visited) {
		Queue<qNode> q = new LinkedList<qNode>();
		q.add(new qNode(0, 0));
		visited[0] = true;
		while (!q.isEmpty()) {
			qNode qn = q.poll();
			for (int i = 6; i > 0; i--) {
				int newPosition = qn.position + i;
				int newresult = qn.count + 1;

				if (newPosition >= 99) {
					return newresult;
				}
				if(visited[newPosition]==true) {
					continue;
				}
				visited[newPosition] = true;
				if (board[newPosition] != -1) {
					newPosition = board[newPosition];
					visited[newPosition] = true;
					if (newPosition >= 99) {
						return newresult;
					}
				}
				q.add(new qNode(newPosition, newresult));
			}
		}
		return -1;
	}
}