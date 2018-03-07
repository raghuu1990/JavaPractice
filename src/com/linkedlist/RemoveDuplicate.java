package com.linkedlist;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// https://www.hackerrank.com/challenges/30-linked-list-deletion/problem

public class RemoveDuplicate {
	public static Node insert(Node head, int data) {
		Node p = new Node(data);
		if (head == null)
			head = p;
		else if (head.next == null)
			head.next = p;
		else {
			Node start = head;
			while (start.next != null)
				start = start.next;
			start.next = p;

		}
		return head;
	}

	public static void display(Node head) {
		Node start = head;
		while (start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Node head = null;
		int T = sc.nextInt();
		while (T-- > 0) {
			int ele = sc.nextInt();
			head = insert(head, ele);
		}
		head = removeDuplicates(head);
		display(head);
		sc.close();
	}

	public static Node removeDuplicates(Node head) {
		if (head == null) {
			return head;
		}
		Set<Integer> set = new HashSet<Integer>();
		Node start = head;
		set.add(start.data);
		while (start.next != null) {
			if (set.contains(start.next.data)) {
				start.next = start.next.next;
			} else {
				set.add(start.next.data);
				start = start.next;
			}
		}
		return head;
	}
}

class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}