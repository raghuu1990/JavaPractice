package com.queue;

import java.util.HashMap;
import java.util.PriorityQueue;

public class SortNoByFrequency {
	public static void main(String[] args) {
		int[] names = {8,5,5,5,5,1,1,1,4,4,3,3};
		//int[] names = {3,1,2,2,4};
		customSort(names);
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
	}

	static class Node implements Comparable<Node> {
		int freq;
		int value;

		public Node(int v, int f) {
			super();
			this.freq = f;
			this.value = v;
		}

		@Override
		public int compareTo(Node node) {
			if (this.freq < node.freq) {
				return -1;
			} else if (this.freq > node.freq) {
				return 1;
			}
			return this.value <= node.value ? -1 : 1;
		}
	}

	static void customSort(int[] arr) {
		PriorityQueue<Node> maxHeap = new PriorityQueue<Node>();
		HashMap<Integer, Node> hashMap = new HashMap<Integer, Node>();
		for (Integer str : arr) {
			if (hashMap.containsKey(str)) {
				hashMap.get(str).freq += 1;
			} else {
				Node node = new Node(str, 1);
				hashMap.put(str, node);
			}
		}

		for (Integer name : hashMap.keySet()) {
			maxHeap.add(hashMap.get(name));
		}

		int i = 0;
		while(!maxHeap.isEmpty()) {
			Node node = maxHeap.poll();
			for (int j = 0; j < node.freq && i<arr.length ; i++, j++) {
				arr[i] = node.value;
			}
		}
	}
}