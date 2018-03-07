package com.queue;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ElectionWinner {
	public static void main(String[] args) {
		String[] names = new String[10];
		names[0] = "aaa";
		names[1] = "aaa";
		names[2] = "aab";
		names[3] = "aab";
		names[4] = "ddd";
		names[5] = "ffff";
		names[6] = "ffff";
		names[7] = "ffff";
		names[8] = "sss";
		names[9] = "ssss";

		System.out.println(electionWinner(names));
	}

	private static String electionWinner(String[] names) {
		PriorityQueue<Node> maxHeap = new PriorityQueue<Node>(Collections.reverseOrder());
		HashMap<String, Node> hashMap = new HashMap<String, Node>();
		for (String str : names) {
			if (hashMap.containsKey(str)) {
				hashMap.get(str).freq += 1;
			} else {
				Node node = new Node(str, 1);
				hashMap.put(str, node);
			}
		}

		for (String name : hashMap.keySet()) {
			maxHeap.add(hashMap.get(name));
		}
		return maxHeap.poll().name;
	}
	
	static class Node implements Comparable<Node> {
		int freq;
		String name;

		public Node(String s, int f) {
			super();
			this.freq = f;
			this.name = s;
		}

		@Override
		public int compareTo(Node node) {
			if (this.freq > node.freq) {
				return 1;
			} else if (this.freq < node.freq) {
				return -1;
			}
			return this.name.compareToIgnoreCase(node.name) > 0 ? 1 : -1;
		}
	}
}

