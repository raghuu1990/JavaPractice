package com.linkedlist;

import java.util.Scanner;

import com.node.Node;

public class SegregateEvenOddNodes {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			Node head = null;
			Node end = null;
			int L = in.nextInt();
			for (int j = 0; j < L; j++) {
				Node node = new Node();
				node.data = in.nextInt();
				if (head == null) {
					head = node;
				} else {
					end.next = node;
				}
				end = node;
			}
			segregateEvenOddNodes(head);
		}
		in.close();
	}

	private static void segregateEvenOddNodes(Node head) {
		Node evenHead = null;
		Node oddHead = null;
		Node evenEnd = null;
		Node oddEnd = null;

		while (head != null) {
			Node node = new Node(head.data);
			if (head.data % 2 == 0) {
				if (evenHead == null) {
					evenHead = node;
				} else {
					evenEnd.next = node;
				}
				evenEnd = node;
			} else {
				if (oddHead == null) {
					oddHead = node;
				} else {
					oddEnd.next = node;
				}
				oddEnd = node;
			}
			head = head.next;
		}
		if (evenHead == null) {
			oddHead.print();
		} else {
			evenEnd.next = oddHead;
			evenHead.print();
		}
		System.out.println();
	}
}