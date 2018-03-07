package com.node;

import com.utils.StringUtils;

public class DNode {
	public int data;
	public DNode left = null;
	public DNode right = null;

	public DNode() {
	}

	public DNode(int data) {
		this.data = data;
		left = right = null;
	}

	public DNode(DNode left, int data) {
		this.data = data;
		this.left = left;
		this.right = null;
	}

	public DNode(int data, DNode right) {
		this.data = data;
		this.right = right;
	}

	public DNode(DNode left, int data, DNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public static DNode getLinkedList(int k) {
		DNode head = new DNode(1);
		DNode prev = head;
		for (int i = 2; i <= k; i++) {
			 DNode node  = new DNode(i);
			 node.left = prev;
			 prev.right = node;
			 prev = node;
		}
		return head;
	}

	
	public DNode getNode(DNode root, int data, String mustEmpty) {
		if (root == null) {
			return null;
		}
		if (root.data == data) {
			if (mustEmpty.equalsIgnoreCase("R") && root.right == null
					|| mustEmpty.equalsIgnoreCase("L") && root.left == null || StringUtils.isEmpty(mustEmpty)) {
				return root;
			}
		}
		DNode right = getNode(root.right, data, mustEmpty);
		DNode left = getNode(root.left, data, mustEmpty);
		if (right != null) {
			if (mustEmpty.equalsIgnoreCase("R") && right.right == null
					|| mustEmpty.equalsIgnoreCase("L") && right.left == null || StringUtils.isEmpty(mustEmpty)) {
				return right;
			}
		}
		if (left != null) {
			if (mustEmpty.equalsIgnoreCase("R") && left.right == null
					|| mustEmpty.equalsIgnoreCase("L") && left.left == null || StringUtils.isEmpty(mustEmpty)) {
				return left;
			}
		}
		return null;
	}

	public static DNode getHead(DNode node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	public static DNode getTail(DNode node) {
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}

	public static void printForward(DNode node) {
		if (node == null) {
			return;
		}
		node = getHead(node);
		while (node != null) {
			System.out.print(node.data);
			System.out.print(" ");
			node = node.right;
		}
		System.out.println();
	}

	public static void printBackward(DNode node) {
		if (node == null) {
			return;
		}
		node = getTail(node);
		while (node != null) {
			System.out.print(node.data);
			System.out.print(" ");
			node = node.left;
		}
		System.out.println();
	}

	public void print() {
		DNode node = this;
		while (node != null) {
			System.out.print(node.data);
			System.out.print(" ");
			node = node.right;
		}
	}

	public static DNode reverse(DNode head) {
		DNode curr = head;
		DNode prev = head!=null?head.left:head;
		while (curr!= null) {
			DNode temp = curr.right;
			curr.right = prev;
			if(prev!=null) {
				curr.left = prev.left;
				prev.left = curr;
			}
			prev = curr;
			curr = temp;
		}
		return prev;
	}

	public static Node reverseSingly(Node head) {
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

	public static int height(DNode root) {
		if (root == null){
			return 0;
		} else {
			int lheight = height(root.left);
			int rheight = height(root.right);

			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}
}