package com.linkedlist;

import com.node.Node;

public class NthNodeFromLast {
	private static Node result;

	public static void main(String[] args) {
		Node head = Node.getLinkedList(10);
		nthNodeFromLast(head, 7);
		if(result!=null) {
			System.out.println(result.data);
		}else {
			System.out.println("Not Found");
		}
	}

	public static int nthNodeFromLast(Node head, int n) {
		int j = 0;
		if(head==null) {
			return j;
		} else {
			j = nthNodeFromLast(head.next, n)+1;
			if(j==n) {
				result = head;
			}
		}
		return j;
	}
}