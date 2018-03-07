package com.node;

import java.util.HashSet;
import java.util.Set;

public class Node {
	public int data;
	public Node next;

	public Node() {
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node(int data) {
		this.data = data;
		this.next = null;
	}

	public Node(int data, Node node) {
		this.data = data;
		this.next = node;
	}

	public int length() {
		return length(this);
	}

	public static int length(Node head) {
		int length = 0;
		while (head != null) {
			head = head.next;
			length++;
		}
		return length;
	}

	public static Node getLinkedList(int size) {
		Node head = null;
		Node tail = null;
		for (int data = 1; data <= size; data++) {
			Node node = new Node(data);
			if (head == null) {
				head = tail = node;
			} else {
				tail.next = node;
				tail = tail.next;
			}
		}
		return head;
	}

	public static Node getLinkedList(int[] data) {
		Node head = null;
		Node tail = null;
		for (int i = 1; i <= data.length; i++) {
			Node node = new Node(data[i]);
			if (head == null) {
				head = tail = node;
			} else {
				tail.next = node;
				tail = tail.next;
			}
		}
		return head;
	}

	public void print() {
		print(this);
	}

	public static void print(Node node) {
		while (node != null) {
			System.out.print(node.data);
			node = node.next;
			if (node != null) {
				System.out.print(" ");
			}
		}
		System.out.println();
	}

	public static Node reverse(Node head) {
		Node curr = head;
		Node prev = null;
		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	@SuppressWarnings("unused")
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

	@SuppressWarnings("unused")
	private static Node reverseAltKNodes(Node head, int k) {
		Node curr = head;
		Node prev = null;

		int counter1 = 0;
		while (curr != null && counter1 < k) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			counter1++;
		}

		int counter2 = 0;
		while (curr != null && counter2 < k) {
			head.next = curr;
			head = head.next;
			curr = curr.next;
			counter2++;
		}

		if (curr != null) {
			head.next = reverseAltKNodes(curr, 4);
		}
		return prev;
	}
	
	public static Node removeDuplicates(Node head) {
        if(head==null){
            return head;
        }
        Set<Node> set = new HashSet<Node>();
        Node start = head;
        set.add(start);
        while(start.next!=null) {
            if(set.contains(start.next)){
                start.next=start.next.next;
            }else{
                set.add(start.next);
                start=start.next;
            }
        }
        return head;
    }
}