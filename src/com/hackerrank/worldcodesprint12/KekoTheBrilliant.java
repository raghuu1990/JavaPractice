package com.hackerrank.worldcodesprint12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class KekoTheBrilliant {
	static int N;
	static int result; 
	static int[] values;
	static boolean[] visited;
	static HashMap<Integer, HashSet<Integer>> mapping = new HashMap<>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		values = new int[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			values[i] = in.nextInt();
			mapping.put(i, new HashSet<Integer>());
		}
		int parent, child;
		for (int i = 0; i < n - 1; i++) {
			parent = in.nextInt() - 1;
			child = in.nextInt() - 1;
			mapping.get(parent).add(child);
			mapping.get(child).add(parent);
		}
		Node root = dfs(0);
		balance(root, false, root.data);
		System.out.println(result);
		in.close();
	}

	private static void balance(Node root, boolean lastChanged, int parent) {
		if(root==null) {
			return;
		}
		boolean changed = false;
		//boolean isBothChanged = true;
		boolean isParentHigherThanChild = false;
		if(root.childs!=null && root.childs.size()>0) {
			for(Node child : root.childs) {
				if(root.data>child.data) {
					changed = true;
					if(!changed) {
						//isBothChanged = false;
					}
					if(parent>child.data) {
						isParentHigherThanChild = true;
					}
				}
			}
		}
		if(changed) {
			result++;
			if(isParentHigherThanChild && !lastChanged) {
				result++;
			}
		}
		if(root.childs!=null && root.childs.size()>0) {
			for(Node child : root.childs) {
				balance(child, changed, root.data);
			}
		}
	}

	public static Node dfs(int u) {
		visited[u] = true;
		ArrayList<Node> childs = new ArrayList<>();
		for (Integer v : mapping.get(u)) {
			if (!visited[v]) {
				childs.add(dfs(v));
			}
		}
		Node node;
		if (childs.isEmpty())
			node = new Node(values[u]);
		else {
			node = new Node(values[u]);
			for (Node child : childs) {
				node.addChild(child);
			}
		}
		return node;
	}
}

class Node {
	int data;
	Node left;
	Node right;

	ArrayList<Node> childs;

	public Node(int data) {
		super();
		this.data = data;
		this.childs = new ArrayList<Node>();
	}

	public void addChild(Node child) {
		this.childs.add(child);
	}

	public Node(int data, ArrayList<Node> childs) {
		super();
		this.data = data;
		this.childs = childs;
	}
}