package com.tree;

import com.node.TreeNode;

public class CommonAncestor {
	
	private static boolean is_a = false;
	private static boolean is_b = false;
	
	/*
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
		TreeNode ca = commonAncestor(root, 4, 3);
		if(ca!=null && is_a && is_b) {
			System.out.println(ca.data);
		}else {
			System.out.println("NA");
		}
	}
	
	public static TreeNode commonAncestor(TreeNode root, int a, int b) {
		if(root==null) {
			return null;
		}
		if(root.data==a) {
			is_a = true;
			return root;
		}
		if(root.data==b) {
			is_b = true;
			return root;
		}
		
		TreeNode left = commonAncestor(root.left, a, b);
		TreeNode right = commonAncestor(root.right, a, b);
		
		if(left!=null && right!=null) {
			return root;
		}else if(left!=null){
			return left;
		}else{
			return right;
		}
	}
}
