package com;

import java.util.HashMap;
import java.util.Map;

public class LRU {
	static int capacity;
	static Map<Integer, Node> map;
	Node first;
	Node last;

	public LRU(int capacity) {
		this.capacity = capacity;
		map = new HashMap<Integer, Node>();
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			updateToTop(key);
			return map.get(key).data;
		}
		return -1;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			updateToTop(key);
			map.get(key).data = value;
		} else {
			map.put(key, new Node(value, key));
			updateToTop(key);
			capacity++;
			if (map.size() > capacity) {
				removeLast();
			}
		}
	}

	public void removeLast() {
		last.next.prev = null;
		map.remove(last.key);
		last = last.next;
		capacity--;
	}

	public void updateToTop(Integer key) {
		if (map.containsKey(key)) {

			Node node = map.get(key);

			node.prev.next = node.next;
			node.next.prev = node.prev;

			first.next = node;
			node.prev = first;
			first = node;

		}
	}
}

class Node {
	public int data;
	public int key;
	public Node next;
	public Node prev;

	public Node(int data, int key) {
		this.data = data;
	}
}
