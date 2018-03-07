package com.disjoint;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// https://www.hackerrank.com/challenges/maximum-cost-queries/problem

public class SuperMaximumCostQueries {
	public static int mod = 1000000007;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		TreeSet set = new TreeSet(n + 1);
		long[] output = new long[q];
		for (int i = 0; i < n - 1; i++) {
			int U = in.nextInt();
			int V = in.nextInt();
			int W = in.nextInt();
			set.makePair(U, V, W);
		}

		HashMap<Integer, Long> pathCostCount = set.processPathCostCount();
		for (int i = 0; i < q; i++) {
			int L = in.nextInt();
			int R = in.nextInt();
			output[i] = getFromMap(pathCostCount, R)-getFromMap(pathCostCount, L-1);
		}
		for (int i = 0; i < q; i++) {
			System.out.println(output[i]);
		}
		in.close();
	}
	
	private static long getFromMap(HashMap<Integer, Long> pathCostCount, int key) {
		if(!pathCostCount.containsKey(key)) {
			return pathCostCount.get(pathCostCount.size());
		}
		return pathCostCount.get(key);
	}
}

class TreeSet {
	public static int mod = 1000000007;
	int n;
	int maxWeight = 0;
	int[] parent;
	int[][] weight;

	HashMap<Integer, Long> pathCostCount;

	public TreeSet(int n) {
		this.n = n;
		weight = new int[this.n][this.n];
		parent = new int[this.n];
		for (int i = 0; i < this.n; i++) {
			parent[i] = i;
		}
	}

	public HashMap<Integer, Long> processPathCostCount() {
		processWeightMatrix();
		int max = 0;
		pathCostCount = new HashMap<Integer, Long>();
		for (int i = 1; i < parent.length; i++) {
			for (int j = 1; j < parent.length; j++) {
				if (i < j) {
					max = Math.max(max, weight[i][j]);
					if (pathCostCount.containsKey(weight[i][j]%mod)) {
						pathCostCount.put(weight[i][j]%mod, pathCostCount.get(weight[i][j]%mod) + 1);
					} else {
						pathCostCount.put(weight[i][j]%mod, 1l);
					}
				}
			}
		}
		pathCostCount.put(0, 0l);
		if(!pathCostCount.containsKey(1)) {
			pathCostCount.put(1, 0l);
		}
		for (int i = 2; i <= max; i++) {
			if (pathCostCount.containsKey(i)) {
				pathCostCount.put(i, pathCostCount.get(i) + pathCostCount.get(i-1));
			} else {
				pathCostCount.put(i, pathCostCount.get(i-1));
			}
		}
		return pathCostCount;
	}

	private void processWeightMatrix() {
		for (int i = 1; i < parent.length; i++) {
			for (int j = 1; j < parent.length; j++) {
				if (i < j) {
					weight[i][j] = getMaxPathWeight(i, j);
				}
			}
		}
	}

	public int getMaxPathWeight(int u, int v) {
		if (u == v) {
			return 0;
		}
		int c = getCommonParent(u, v);

		int maxCost = 0;
		while (c != v) {
			int pv = parent[v];
			maxCost = Math.max(maxCost, weight[Math.max(v, pv)][Math.min(v, pv)]);
			if (pv == c) {
				break;
			}
			v = pv;
		}

		while (c != u) {
			int pu = parent[u];
			maxCost = Math.max(maxCost, weight[Math.max(u, pu)][Math.min(u, pu)]);
			if (pu == c) {
				break;
			}
			u = pu;
		}
		return maxCost;
	}

	public int getCommonParent(int u, int v) {
		Set<Integer> s = new HashSet<Integer>();

		s.add(v);
		while (v != parent[v]) {
			s.add(parent[v]);
			v = parent[v];
		}

		if (s.contains(u)) {
			return u;
		}
		while (u != parent[u]) {
			if (s.contains(parent[u])) {
				return parent[u];
			}
			u = parent[u];
		}
		return -1;
	}

	public void makePair(int u, int v, int w) {
		maxWeight = Math.max(maxWeight, w);
		weight[Math.max(u, v)][Math.min(u, v)] = w;

		if (parent[u] != u) {
			parent[v] = u;
		} else {
			parent[u] = v;
		}
	}
}