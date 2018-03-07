package com.linkedlist;

import com.utils.StringUtils;

import java.util.ArrayList;
import java.util.Scanner;

/*
http://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1

1
30
0 1 L 0 2 R  1 3 L 1 4 R  2 5 L 2 6 R  3 7 L 3 8 R  4 9 L 4 10 R  5 11 L 5 12 R  6 13 L 6 14 R  7 15 L 7 16 R  8 17 L 8 18 R  9 19 L 9 20 R  10 21 L 10 22 R  11 23 L 11 24 R  12 25 L 12 26 R  13 27 L 13 28 R  14 29 L 14 30 R  

Its Correct output is:
15 7 16 3 17 8 18 1 19 9 20 4 21 10 22 0 23 11 24 5 25 12 26 2 27 13 28 6 29 14 30
30 14 29 6 28 13 27 2 26 12 25 5 24 11 23 0 22 10 21 4 20 9 19 1 18 8 17 3 16 7 15

*/
public class BinaryTreeToDLL {
	static DNode head;
	static DNode pre;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		ArrayList<DNode> input = new ArrayList<DNode>();
		for (int i = 0; i < T; i++) {
			DNode root = null;
			DNode node = null;
			int L = in.nextInt();
			for (int j = 0; j < L; j++) {
				int a = in.nextInt();
				int b = in.nextInt();
				String s = in.next();

				if (root == null) {
					node = new DNode(a);
					root = node;
				} else {
					node = root.getNode(root, a, s);
				}
				if (s.equalsIgnoreCase("R")) {
					node.right = new DNode(b);
				} else {
					node.left = new DNode(b);
				}
			}
			input.add(root);
		}
		for (int i = 0; i < input.size(); i++) {
			head = null;
			BToDLL(input.get(i));
			DNode.printForward(head);
			DNode.printBackward(head);
		}
		in.close();
	}

	public static DNode BToDLL(DNode root) {
		BToDLL1(root);
		//BToDLL2(root);
		return head;
	}

	public static void BToDLL2(DNode root) {
		if (root == null) {
			return;
		}
		BToDLL2(root.left);
		if (head == null) {
			head = root;
			pre = root;
		} else {
			root.left = pre;
			pre.right = root;
			pre = pre.right;
		}
		BToDLL2(root.right);
	}

	public static DNode BToDLL1(DNode root) {
		DNode node = null;
		if (root == null) {
			return head;
		} else {
			node = new DNode(root.data);
		}

		if (root.left != null) {
			DNode temp = BToDLL(root.left);
			DNode rightMost = DNode.getTail(temp);
			node.left = rightMost;
			rightMost.right = node;
		}

		if (root.right != null) {
			DNode temp = BToDLL(root.right);
			DNode leftMost = DNode.getHead(temp);
			node.right = leftMost;
			leftMost.left = node;
		}

		if (head == null) {
			head = node;
		}
		return node;
	}

	public static class DNode {
		public int data;
		public DNode left = null;
		public DNode right = null;

		public DNode() {
		}

		public DNode(int data) {
			this.data = data;
		}

		public DNode(DNode left, int data) {
			this.data = data;
			this.left = left;
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

		private DNode getNode(DNode root, int data, String mustEmpty) {
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
			if (head == null) {
				return null;
			}
			DNode prev = head.left;
			while (head.right != null) {
				prev = head;
				DNode temp = head.right;
				head.right = head.left;
				head.left = temp;
				head = temp;
			}
			head.right = prev;
			head.left = null;
			return head;
		}
	}
}