package com.hackerrank.rookierank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HeightAndTotalHeightOfABST {
	private static int max = 0;
	private static int maxSum = 0;
	static int[] heightAndTotalHeight(int[] arr) {
		Set<Integer> set = new HashSet<Integer>();
		Node head = new Node(arr[0]);
		set.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if(!set.contains(arr[i])) {
				insert(arr[i], head);
				set.add(arr[i]);
			}
		}
		setHeight(head);
		return new int[] { max, maxSum};
	}

	static void setHeight(Node head) {
		head.height = 0;
		if(head.left!=null) {
			setHeight(head.left);
			head.height = Math.max(head.height, head.left.height);
		}
		
		if(head.right!=null) {
			setHeight(head.right);
			head.height = Math.max(head.height, head.right.height);
		}
		if(head.right!=null || head.left!=null) {
			head.height++;
		}
		max = Math.max(max, head.height);
		maxSum+=head.height;
	}

	static void insert(int value, Node head) {
		if(head.value<value) {
			if(head.right==null) {
				head.right = new Node(value);
			}else {
				insert(value, head.right);
			}
		}else {
			if(head.left==null) {
				head.left = new Node(value);
			}else {
				insert(value, head.left);
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextInt();
		}
		
		int result[] = heightAndTotalHeight(arr);
		System.out.println(result[0]);
		System.out.println(result[1]);
		in.close();
	}
}

class Node {
	int value;
	int height;
	Node left;
	Node right;

	public Node(int value) {
		this.value = value;
	}
}