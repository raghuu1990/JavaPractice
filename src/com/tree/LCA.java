package com.tree;

import com.node.TreeNode;

public class LCA {

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
		int a = 7;
		int b = 4;
		TreeNode lca = findLCA(root, a, b);
		if(lca!=null) {
			System.out.println(lca.data);
		}else {
			System.out.println("LCA not found");
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
		} else if (left != null) {
			return left;
		} else if (right != null) {
			return right;
		}
		return null;
	}
/*
	private static int findLCA(Node root, int a, int b) {
		if(root==null) {
			return -1;
		}
		if(root.data==a) {
			return a;
		}
		if(root.data==b) {
			return b;
		}
		int left = findLCA(root.left, a, b);
		int right = findLCA(root.right, a, b);
		if(left!=-1 && right!=-1) {
			return root.data;
		}else {
			if(left!=-1) {
				return left;
			}else if(right!=-1){
				return right;
			}
		}
		return -1;
	}
*/
}