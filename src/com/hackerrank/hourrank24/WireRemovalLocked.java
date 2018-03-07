package com.hackerrank.hourrank24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// https://www.hackerrank.com/contests/hourrank-24/challenges/wire-removal

public class WireRemovalLocked {
	static int prob = 0;
	static boolean[] visited;
	static HashMap<Integer, ArrayList<Integer>> mapping = new HashMap<>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		visited = new boolean[n + 1];

		for (int i = 1; i <= n; ++i) {
			visited[i] = false;
			mapping.put(i, new ArrayList<Integer>());
		}

		for (int i = 0; i < n - 1; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			mapping.get(x).add(y);
			mapping.get(y).add(x);
		}
		Node root = dfs(1);
		Double result = solve(root, n);
		System.out.printf("%.10f", result);
		in.close();
	}

	private static double solve(Node root, int n) {
		double result = 0;
		int childCount = 0;
		for (Node child : root.childs) {
			result+=solve(child, n);
			childCount++;
		}
		root.childCount = childCount;
		result+=(((double)root.distance/(double)prob)*(n-root.childCount-1));
		return result;
	}

	private static Node dfs(int u) {
		Node emptyNode = new Node(0, 0);
		int distance = 0;
		visited[u] = true;
		Queue<Node> queue = new LinkedList<Node>();
		Node root = new Node(u, distance);
		queue.add(root);
		queue.add(emptyNode);
		distance++;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(node.value==0) {
				distance++;
				if(!queue.isEmpty()) {
					queue.add(emptyNode);
				}
				continue;
			}
			ArrayList<Integer> childs = mapping.get(node.value);
			for (int i : childs) {
				if(!visited[i]) {
					visited[i] = true;
					Node child = new Node(i, distance);
					node.childs.add(child);
					queue.add(child);
					prob+=distance;
				}
			}
			
		}
		return root;
	}
}

class Node {
	int value;
	int childCount = 0;
	int distance;
	List<Node> childs;

	public Node(int value, int distance) {
		this.value = value;
		this.distance = distance;
		this.childs = new ArrayList<Node>();
	}
}