package com.tree;

import com.node.TreeNode;

public class PrintKthDistanceNodes {

	/*
	 * 1 
	 *  \ 
	 *   2
	 *    \ 
	 *     5 
	 *    / \ 
	 *   3   6 
	 *    \ 
	 *     4
	 * 
	 *		1 
	 *	   / \ 
	 *    2   3
	 *   / \ 
	 *  4   5 
	 *       \ 
	 *        6 
	 *         \ 
	 *          7
	 */

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, new TreeNode(6, null, new TreeNode(7, null, null)))),
				new TreeNode(3, null, null));
		int k = 2;
		int value = 5;
		kDistanceNodes(root, k, value, -1);
	}

	private static int kDistanceNodes(TreeNode root, int k, int value, int h) {
		if (root == null) {
			return -1;
		}

		if (root.data == value) {
			h = 0;
			printKthDistanceNodes(root, k);
			return h;
		}

		int leftH = kDistanceNodes(root.left, k, value, -1);
		int rightH = kDistanceNodes(root.right, k, value, -1);

		if (leftH > -1) {
			h = ++leftH;
			if (h == k) {
				System.out.println(root.data);
			} else if (h < k) {
				printKthDistanceNodes(root.right, k - h - 1);
			}
		} else if (rightH > -1) {
			h = ++rightH;
			if (h == k) {
				System.out.println(root.data);
			} else if (h < k) {
				printKthDistanceNodes(root.left, k - h - 1);
			}
		}
		return h;
	}

	private static void printKthDistanceNodes(TreeNode root, int k) {
		if (root == null || k < 0) {
			return;
		}
		if (k == 0) {
			System.out.println(root.data);
			return;
		}
		printKthDistanceNodes(root.right, k - 1);
		printKthDistanceNodes(root.left, k - 1);
	}
}