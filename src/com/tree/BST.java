package com.tree;

import java.util.Scanner;

import com.node.TreeNode;

public class BST {
	public static void main(String[] args) {
		TreeNode root = null;

		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			root = insert(root, in.nextInt());
		}
		in.close();

		/*
		 * int[] arr = { 8, 4, 9, 1, 2, 3, 6, 5 }; for (int i = 0; i < arr.length; i++)
		 * { root = insert(root, arr[i]); }
		 */

		// System.out.println(lca(root, 1, 2));

		System.out.println(checkBST(root));
	}

	public static TreeNode insert(TreeNode root, int value) {
		if (root == null) {
			TreeNode node = new TreeNode();
			node.data = value;
			return node;
		}

		if (value < root.data) {
			root.left = insert(root.left, value);
		} else if (value > root.data) {
			root.right = insert(root.right, value);
		}
		return root;
	}

	public static int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 0;
		}
		return 1 + Math.max(height(root.right), height(root.left));
	}

	public static TreeNode lca(TreeNode root, int v1, int v2) {
		while (root != null) {
			if ((v1 < root.data && v2 > root.data)
					|| (v1 > root.data && v2 < root.data || v1 == root.data || v2 == root.data)) {
				break;
			}
			if ((v1 < root.data && v2 < root.data)) {
				root = root.left;
			} else if ((v1 > root.data && v2 > root.data)) {
				root = root.right;
			}
		}
		return root;
	}

	public static boolean checkBST(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (min < root.data && root.data < max && checkBST(root.left, min, root.data)
				&& checkBST(root.right, root.data, max)) {
			return true;
		}
		return false;
	}

	public static boolean checkBST(TreeNode root) {
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
}