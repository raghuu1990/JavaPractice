package com.prem.tree;

public class Node {
	int data;
	Node rc;
	Node lc;
	Node next;
	int height;

	public Node() {
	}

	public Node(int data) {
		this.data = data;
		this.rc = null;
		this.lc = null;
	}
}