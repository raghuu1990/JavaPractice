package com.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class WeightedGraph {
	static final int INF = Integer.MAX_VALUE;
	int V;
	LinkedList<AdjacencyListNode>[] adj;

	WeightedGraph(int V) {
		this.V = V;
		this.adj = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			this.adj[i] = new LinkedList<AdjacencyListNode>();
		}
	}

	public void addEdge(int u, int v, int w) {
		adj[u].add(new AdjacencyListNode(v, w));
	}

	private void topologicalSort(int v, boolean[] visited, Stack<Integer> stack) {
		visited[v] = true;
		Iterator<AdjacencyListNode> it = adj[v].listIterator();
		while (it.hasNext()) {
			AdjacencyListNode node = it.next();
			if (!visited[node.getV()]) {
				topologicalSort(node.getV(), visited, stack);
			}
		}
		stack.push(new Integer(v));
	}

	public void shortestPath(int s) {
		int[] dis = new int[V];
		boolean[] visited = new boolean[V];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < dis.length; i++) {
			dis[i] = INF;
			visited[i] = false;
		}

		for (int i = 0; i < dis.length; i++) {
			if (!visited[i]) {
				topologicalSort(0, visited, stack);
			}
		}

		dis[s] = 0;

		while (!stack.isEmpty()) {
			int u = stack.pop();
			if (dis[u] != INF) {
				Iterator<AdjacencyListNode> itr = adj[u].listIterator();
				while (itr.hasNext()) {
					AdjacencyListNode vNode = itr.next();
					int v = vNode.getV();
					if (dis[v] > dis[u] + vNode.getWeight()) {
						dis[v] = dis[u] + vNode.getWeight();
					}
				}
			}
		}

		for (int i = 0; i < dis.length; i++) {
			if (dis[i] != INF) {
				System.out.println("No path found");
			} else {
				System.out.println("Distance from " + s + " is " + dis[i]);
			}
		}

	}
}

class AdjacencyListNode {
	int v;
	int w;

	AdjacencyListNode(int v, int w) {
		this.v = v;
		this.w = w;
	}

	public int getWeight() {
		return w;
	}

	public int getV() {
		return v;
	}
}