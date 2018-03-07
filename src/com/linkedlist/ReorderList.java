package com.linkedlist;

import com.node.Node;

// 1->2->3->4->5->6->7->8->9->10 ==>  1->10->2->9->3->8->4->7->5->6
// O(n^2)

public class ReorderList {
	public static void main(String[] args) {
		Node head = Node.getLinkedList(10);
		head = reorderListByReverseReverse(head);
		head.print();
		
		head = Node.getLinkedList(10);
		head = reorderlist(head);
		head.print();
	}

	private static Node reorderListByReverseReverse(Node head) {
		int length = head.length();
		Node node = head;

		int i = 1;
		while (i < length) {
			node.next = Node.reverse(node.next);
			node = node.next;
			i++;
		}
		return head;
	}

	// O(n)
	private static Node reorderlist(Node head) {
		Node p = head;
		Node q = head.next; 
		while (q != null && q.next != null) {
			p = p.next;
			q = q.next.next;
		}
		q = p.next;
		p.next = null;

		// reverse from middle p to the end
		Node cur = null;
		while (q != null) {
			Node next = q.next;
			q.next = cur;
			cur = q;
			q = next;
		}
		// right half head is cur

		// merge the 2 lists
		p = head;
		q = cur;
		while (q != null) {
			Node leftNext = p.next;
			p.next = q;
			Node rightNext = q.next;
			q.next = leftNext;
			p = leftNext;
			q = rightNext;
		}
		return head;
	}
}