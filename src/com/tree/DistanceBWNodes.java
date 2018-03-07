package com.tree;

import com.node.TreeNode;

public class DistanceBWNodes {

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
	 *		 1 
	 *	    / \ 
	 *     2   3
	 *    / \ 
	 *   4   5 
	 *  /     \ 
	 * 8       6 
	 *          \ 
	 *           7
	 */

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1,
				new TreeNode(2, new TreeNode(4, new TreeNode(8, null, null), null), new TreeNode(5, null, new TreeNode(6, null, new TreeNode(7, null, null)))),
				new TreeNode(3, null, null));
		int a = 8;
		int b = 3;
		int d = distanceBWNodes(root, a, b);
		System.out.println(d);
	}

	private static int distanceBWNodes(TreeNode root, int a, int b) {
		if (root == null) {
			return -1;
		}
		if (a == b) {
			return 0;
		}
		TreeNode lca = findLCA(root, a, b);
		if (lca == null) {
			return -1;
		}
		if (lca.data == a) {
			return distance(lca, b);
		} else if (lca.data == b) {
			return distance(lca, a);
		} else {
			return distance(lca, a) + distance(lca, b);
		}
	}

	private static TreeNode findLCA(TreeNode root, int a, int b) {
		if (root == null) {
			return null;
		}
		if (root.data == a || root.data == b) {
			return root;
		}
		TreeNode left = findLCA(root.left, a, b);
		TreeNode right = findLCA(root.right, a, b);
		if (left != null && right != null) {
			return root;
		} else {
			if (left != null) {
				return left;
			} else if (right != null) {
				return right;
			}
		}
		return null;
	}

	private static int distance(TreeNode root, int data) {
		if (root == null) {
			return -1;
		}
		if (root.data == data) {
			return 0;
		}
		int rd = distance(root.right, data);
		if (rd > -1) {
			return rd + 1;
		}
		int ld = distance(root.left, data);
		if (ld > -1) {
			return ld + 1;
		}
		return -1;
	}
}