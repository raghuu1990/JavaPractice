package com.node;

// Circular LL

public class CLL {
	CNode head = null;
	CNode tail = null;

	public void addAtStart(int data) {
		CNode node = new CNode(data);
		if (head == null) {
			head = node;
			tail = node;
		} else {
			CNode temp = head;
			head = node;
			head.next = temp;
		}
		tail.next = head;
	}
}

class CNode {
	int data;
	CNode next;
	CNode prev;

	public CNode(int data) {
		this.data = data;
	}
}