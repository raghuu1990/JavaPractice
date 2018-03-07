package com.node;

import com.utils.StringUtils;

public class TreeNode {
	public int data;
	public TreeNode left = null;
	public TreeNode right = null;

	public TreeNode() {
	}

	public TreeNode(int data) {
		this.data = data;
		left = right = null;
	}

	public TreeNode(TreeNode left, int data) {
		this.data = data;
		this.left = left;
		right = null;
	}

	public TreeNode(int data, TreeNode right) {
		this.data = data;
		this.right = right;
	}

	public TreeNode(int data, TreeNode left, TreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public TreeNode(TreeNode left, int data, TreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public TreeNode getNode(TreeNode root, int data, String mustEmpty) {
		if (root == null) {
			return null;
		}
		if (root.data == data) {
			if (mustEmpty.equalsIgnoreCase("R") && root.right == null
					|| mustEmpty.equalsIgnoreCase("L") && root.left == null || StringUtils.isEmpty(mustEmpty)) {
				return root;
			}
		}
		TreeNode right = getNode(root.right, data, mustEmpty);
		TreeNode left = getNode(root.left, data, mustEmpty);
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

	public static int height(TreeNode root) {
		if (root == null){
			return 0;
		} else {
			int lheight = height(root.left);
			int rheight = height(root.right);
			return Math.max(lheight, rheight)+1;
		}
	}
	
	public static void printPreOrder(TreeNode root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+ " ");
		printPreOrder(root.left);
		printPreOrder(root.right);
	}
	
	public static void printInOrder(TreeNode root) {
		if(root==null) {
			return;
		}
		printInOrder(root.left);
		System.out.print(root.data+ " ");
		printInOrder(root.right);
	}
	
	public static void printPostOrder(TreeNode root) {
		if(root==null) {
			return;
		}
		printPostOrder(root.left);
		printPostOrder(root.right);
		System.out.print(root.data+ " ");
	}
}