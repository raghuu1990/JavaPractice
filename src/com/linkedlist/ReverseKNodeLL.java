package com.linkedlist;

import com.node.Node;

public class ReverseKNodeLL {
	public static void main(String[] args) {
		Node head = Node.getLinkedList(10);
		System.out.print("Input : ");
		head.print();
		head = reverseKNodes(head, 4);
		System.out.print("Output after reversing K nodes : ");
		head.print();

		head = Node.getLinkedList(10);
		head = reverseAltKNodes(head, 4);
		System.out.print("Output after reversing alternate K nodes : ");
		head.print();
	}

	private static Node reverseKNodes(Node head, int k) {
		Node curr = head;
		Node prev = null;

		int counter = 0;
		while (counter < k && curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			counter++;
		}

		// At Last, this point
		// prev is head of reversed ll 
		// curr/next is (k+1)th Node or head of remaining
		// head is now kth node or tail of k reversed list
		
		if (curr != null) {
			head.next = reverseKNodes(curr, k);
		}
		return prev;
	}

	private static Node reverseAltKNodes(Node head, int k) {
		Node curr = head;
		Node prev = null;
		
		int counter1 = 0;
		while(curr!=null && counter1<k) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			counter1++;
		}
		
		// Increment head and curr by k nodes
		int counter2 = 0;
		while(curr!=null && counter2<k) {
			head.next = curr;
			head = head.next;
			curr = curr.next;
			counter2++;
		}

		if(curr!=null) {
			head.next = reverseAltKNodes(curr, 4);
		}
		return prev;
	}
}