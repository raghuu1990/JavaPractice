package com.search;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class CountLuck {
	private static String OOPS = "Oops!";
	private static String SPACE = ".";
	private static String START = "M";
	private static String END = "*";
	private static String FOREST = "X";
	private static String IMPRESSED = "Impressed";
	
	private static int[][] moves = {{-1, 0, 0, 1}, {0, -1, 1, 0}};

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			in.nextInt();
			String[] matrix = new String[n];
			for (int j = 0; j < n; j++) {
				matrix[j] = in.next();
			}
			int k = in.nextInt();
			String result = countLuck(matrix, k);
			System.out.println(result);
		}
		in.close();
	}
	
	static String countLuck(String[] input, int k) {
		int n = input.length;
		int m = input[0].length();
		int start_i = 0;
		int start_j = 0;
		String [][] matrix = new String [n][m];
		boolean [][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String str = input[i];
			for (int j = 0; j < m; j++) {
				if(START.equalsIgnoreCase(str.charAt(j)+"")) {
					start_i = i;
					start_j = j;
				}
				matrix[i][j] = str.charAt(j)+"";
			}
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(start_i, start_j, 0));
		visited[start_i][start_j] = true;
		while(!queue.isEmpty()) {
			Node pre = queue.poll();
			if(END.equalsIgnoreCase(matrix[pre.i][pre.j])) {
				if(pre.k==k) {
					return IMPRESSED;
				}else {
					return OOPS;
				}
			}
			List<Node> tempList = new LinkedList<Node>();
			for (int i = 0; i < 4; i++) {
				int new_i = pre.i+ moves[0][i];
				int new_j = pre.j+ moves[1][i];
				if(new_i>=0 &&  new_j >=0 && new_i<n &&  new_j<m && !visited[new_i][new_j]) {
					visited[new_i][new_j] = true;
					if(!FOREST.equalsIgnoreCase(matrix[new_i][new_j])) {
						tempList.add(new Node(new_i, new_j, pre.k));
					}
				}
			}
			if(tempList.size()>1) {
				for (Node node : tempList) {
					node.k++;
				}
			}
			if(!tempList.isEmpty()) {
				queue.addAll(tempList);
			}
		}
		return OOPS;
	}
}

class Node{
	int i;
	int j;
	int k;
	
	Node(int i, int j){
		this.i = i;
		this.j = j;
		this.k = 0;
	}
	Node(int i, int j, int k){
		this.i = i;
		this.j = j;
		this.k = k;
	}
}
