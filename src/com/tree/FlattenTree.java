package com.tree;

import java.util.Stack;

import com.node.TreeNode;

// Flatten Tree as preOrder
public class FlattenTree {
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
	 * 	1 - 2 - 5 - 3 - 4 - 6
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
	 *   1 - 2 - 4 - 5 - 6 - 7 - 3       
	 */

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1, null,
				new TreeNode(2, null, new TreeNode(5, new TreeNode(3, null, new TreeNode(4, null, null)), new TreeNode(6, null, null))));
		TreeNode.printPreOrder(root1);
		System.out.println();
		TreeNode node1 = flattenTree(root1);
		TreeNode.printInOrder(node1);
		System.out.println();
		
		TreeNode root2 = new TreeNode(1,
				new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, new TreeNode(6, null, new TreeNode(7, null, null)))),
				new TreeNode(3, null, null));
		
		
		TreeNode.printPreOrder(root2);
		System.out.println();
		TreeNode node2 = flattenTree(root2);
		TreeNode.printInOrder(node2);
	}

	private static TreeNode flattenTree(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		
		while(node!=null || !stack.isEmpty()) {
			if(node.right!=null) {
				stack.push(node.right);
			}
			if(node.left!=null) {
				node.right = node.left;
				node.left = null;
			}else if(!stack.isEmpty()){
				node.right = stack.pop();
			}
			node= node.right;
		}
		return root;
	}
}