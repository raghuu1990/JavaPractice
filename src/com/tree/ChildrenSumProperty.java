package com.tree;

import com.node.TreeNode;

// https://www.geeksforgeeks.org/convert-an-arbitrary-binary-tree-to-a-tree-that-holds-children-sum-property/

public class ChildrenSumProperty {
/*

	   50
      /  \     
     /    \
    7      2
   / \     /\
  /   \   /  \
 3     5 1   30
 			  \
 			   1
 	   50
      /  \     
     /    \
    19     31
   / \     /\
  /   \   /  \
 14    5 1   30
 			   \
               30
*/

	public static void main(String args[]) {
		TreeNode head = new TreeNode(50);
		head.left = new TreeNode(7, new TreeNode(3), new TreeNode(5));
		head.right = new TreeNode(2, new TreeNode(1), new TreeNode(30, new TreeNode(1)));
		createChildSumtree(head);
		TreeNode.printInOrder(head);
	}
	
	private static int createChildSumtree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return root.data;
		}

		int sum1 = createChildSumtree(root.left);
		int sum2 = createChildSumtree(root.right);
		if (root.data < sum1 + sum2) {
			root.data = sum1 + sum2;
		} else if (root.data > sum1 + sum2) {
			int increment = root.data - sum1 - sum2;
			incrementChild(root, increment);
		}
		return root.data;
	}

	private static void incrementChild(TreeNode root, int increment) {
		if (root == null || (root.left == null && root.right == null)) {
			return;
		}
		if (root.left != null) {
			root.left.data = root.left.data + increment;
			incrementChild(root.left, increment);
		} else {
			root.right.data = root.right.data + increment;
			incrementChild(root.right, increment);
		}
	}
}