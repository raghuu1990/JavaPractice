package com.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem

public class IceCreamParlor {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		String[] result = new String[t];
		for (int i = 0; i < t; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int[] arr = new int[b];
			for (int j = 0; j < b; j++) {
				arr[j] = in.nextInt();
			}
			result[i] = method(arr, a);
		}
		for (int i = 0; i < t; i++) {
			System.out.println(result[i]);
		}
		in.close();
	}

	private static String method(int[] arr, int a) {
		ArrayList<Node> nodes = new ArrayList<Node>();
		for (int i = 0; i < arr.length; i++) {
			nodes.add(new Node(i+1, arr[i]));
		}

		Collections.sort(nodes);

		int l = 0;
		int r = arr.length-1;

		while (l <= r) {
			if (a == (nodes.get(l).value + nodes.get(r).value)) {
				return Math.min(nodes.get(l).index, nodes.get(r).index) + " " + Math.max(nodes.get(l).index, nodes.get(r).index);
			} else if (a < (nodes.get(l).value + nodes.get(r).value)) {
				r--;
			} else {
				l++;
			}
		}
		return "";
	}

	static class Node implements Comparable<Node> {
		Integer index;
		Integer value;

		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return this.value.compareTo(o.value);
		}
	}
}