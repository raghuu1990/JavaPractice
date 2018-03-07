package com.linkedlist;

import com.node.Node;

public class RemoveEveryKthNode {

	public static void main(String[] args) {
		Node head = Node.getLinkedList(10);
		head = delete(head,4);
		head.print();
	}

	public static Node delete(Node head, int k) {
		if (head == null || k < 2) {
			return null;
		}
		Node node = head;
		for (int i = 1; i < k; i++) {
			if (node.next == null) {
				return head;
			}
			if (i == k - 1) {
				node.next = node.next.next;
			}
			node = node.next;
		}
		delete(node, k);
		return head;
	}
}