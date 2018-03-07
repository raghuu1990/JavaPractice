package com.design.lru;

import java.util.HashMap;
import java.util.Map;

public class LRU {
	static int capacity;
	static Map<Integer, Node> map;
	static Node first;
	static Node last;

	public static void main(String[] args) {
		LRU cache = new LRU(2);
		cache.put(2, 1);
		cache.put(1, 1);
		cache.put(2, 3);
		cache.put(4, 1);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
	}

	public LRU(int capacity) {
		LRU.capacity = capacity;
		map = new HashMap<Integer, Node>();
	}

	public static int get(int key) {
		if (map.containsKey(key)) {
			updateToTop(key);
			return map.get(key).data;
		}
		return -1;
	}
	
	public static void delete(int key) {
		if (map.containsKey(key)) {
			deleteFromList(key);
			map.remove(key);
		}
	}

	public static void put(int key, int value) {
		if (map.containsKey(key)) {
			map.get(key).data = value;
			updateToTop(key);
		} else {
			map.put(key, new Node(value, key));
			updateToTop(key);
			if (map.size() > capacity) {
				int lastKey = last.key;
				removeLast();
				map.remove(lastKey);
			}
		}
	}

	public static void deleteFromList(int key) {
		if(map.size()==0) {
			return ;
		}
		Node node = map.get(key);
		if(node==first) {
			if(node.prev!=null) {
				first = node.prev;
				node.prev.next = null;
			}else {
				first = null;
				last = null;
			}
			return;
		}

		if(node==last) {
			removeLast();
			return;
		}
		
		if (node.next != null) {
			node.next.prev = node.prev;
		}
		if (node.prev != null) {
			node.prev.next = node.next;
		}
	}

	public static void removeLast() {
		if (map.size() == 1) {
			first = null;
			last = null;
		} else {
			if (last.next != null) {
				last.next.prev = null;
			}
			if (last.next != null) {
				last = last.next;
			}
		}
	}

	public static void updateToTop(Integer key) {
		Node node = map.get(key);
		if (first == null) {
			first = node;
			last = node;
			return;
		}
		if (first == node) {
			return;
		}

		if (node.prev != null) {
			node.prev.next = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		}

		if (last == node) {
			last = node.next;
		}

		node.next = null;
		first.next = node;
		node.prev = first;
		first = node;
	}
}

class Node {
	public int data;
	public int key;
	public Node next;
	public Node prev;

	public Node(int data, int key) {
		this.data = data;
		this.key = key;
	}
}