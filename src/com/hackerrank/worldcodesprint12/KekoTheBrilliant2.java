package com.hackerrank.worldcodesprint12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class KekoTheBrilliant2 {
	static int n;
	static int[] input, depth;
	static List<Integer>[] graph;
	static Comparator<Integer> comparator = new Comparator<Integer>() {
		public int compare(Integer a, Integer b) {
			return input[a] == input[b] ? (depth[a] == depth[b] ? a - b : -(depth[a] - depth[b])) : -(input[a] - input[b]);
		}
	};

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		input = new int[n];
		depth = new int[n];
		graph = new List[n];

		for (int i = 0; i < n; ++i) {
			input[i] = in.nextInt();
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < n - 1; ++i) {
			int u = in.nextInt() - 1, v = in.nextInt() - 1;
			graph[u].add(v);
			graph[v].add(u);
		}

		dfs(0, -1);
		System.out.println(n - balance(0, -1).size());
		in.close();
	}

	static void dfs(int current, int parent) {
		if (parent != -1) {
			depth[current] = depth[parent] + 1;
		}
		for (int child : graph[current]) {
			if (child != parent) {
				dfs(child, current);
			}
		}
	}

	static TreeSet<Integer> balance(int current, int parent) {
		List<TreeSet<Integer>> bSetList = new ArrayList<TreeSet<Integer>>();

		TreeSet<Integer> bSet = null;

		for (int child : graph[current]) {
			if (child == parent) {
				continue;
			}
			if (bSet == null) {
				bSet = balance(child, current);
			} else {
				TreeSet<Integer> tempSet = balance(child, current);
				if (tempSet.size() > bSet.size()) {
					bSetList.add(bSet);
					bSet = tempSet;
				} else {
					bSetList.add(tempSet);
				}
			}
		}
		if (bSet == null) {
			bSet = new TreeSet<Integer>(comparator);
			bSet.add(current);
		} else {
			for (TreeSet<Integer> tSet : bSetList) {
				bSet.addAll(tSet);
			}
			Integer replace = bSet.ceiling(current);
			if (replace != null) {
				bSet.remove(replace);
			}
			bSet.add(current);
		}
		return bSet;
	}
}