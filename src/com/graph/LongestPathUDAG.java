package com.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import com.node.Pair;

public class LongestPathUDAG {
	// http://www.geeksforgeeks.org/longest-path-undirected-tree/
	public static void main(String[] args) {
		UndirectedGraph g = new UndirectedGraph(10);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(2, 9);
		g.addEdge(2, 4);
		g.addEdge(4, 5);
		g.addEdge(1, 6);
		g.addEdge(6, 7);
		g.addEdge(6, 8);
		longestPathLength(g);
	}

	private static void longestPathLength(UndirectedGraph g) {
		Pair<Integer, Integer> v1 = farthestNodeBFS(g, 0);
		Pair<Integer, Integer> v2 = farthestNodeBFS(g, (Integer) v1.getValue());
		System.out.println(v1.getValue() + " -- " + v2.getValue() + " dis : " + v2.getKey());
	}

	private static Pair<Integer, Integer> farthestNodeBFS(UndirectedGraph g, int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[] dis = new int[g.V];
		for (int i = 0; i < g.V; i++) {
			dis[i] = -1;
		}
		q.add(v);
		dis[v] = 0;
		while (!q.isEmpty()) {
			int t = q.poll();
			Iterator<Integer> itr = g.adj[t].listIterator();
			while(itr.hasNext()) {
				int i = itr.next();
				if (dis[i] == -1) {
					dis[i] = dis[t] + 1;
					q.add(i);
				}
			}
		}
		int maxLength = 0;
		int maxIndex = 0;
		for (int i = 0; i < g.V; i++) {
			if (maxLength < dis[i]) {
				maxLength = dis[i];
				maxIndex = i;
			}
		}
		return new Pair<Integer, Integer>(maxLength, maxIndex);
	}
}