package com.linkedlist;

import com.node.Node;

public class ReverseLL {
	public static void main(String[] args) {
		Node head = Node.getLinkedList(10);
		head = reverseLL(head);
		head.print();
	}

	public static Node reverseLL(Node head) {
		Node prev = null;
		while (head != null) {
			Node next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
}