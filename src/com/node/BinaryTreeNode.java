package com.node;

public class BinaryTreeNode {

	public TreeNode addNode(int data, TreeNode head) {
		TreeNode tempHead = head;

		if (tempHead == null) {
			head = tempHead = new TreeNode(data);
			return head;
		}

		TreeNode parent = null;
		while (tempHead != null) {
			parent = tempHead;
			if (tempHead.data < data) {
				tempHead = tempHead.right;
			} else {
				tempHead = tempHead.left;
			}
		}

		if (parent.data < data) {
			parent.right = new TreeNode(data);
		} else {
			parent.left = new TreeNode(data);
		}
		return head;
	}

	public int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public static void main(String args[]) {
		BinaryTreeNode binaryTree = new BinaryTreeNode();
		TreeNode head = null;
		head = binaryTree.addNode(10, head);
		head = binaryTree.addNode(15, head);
		head = binaryTree.addNode(5, head);
		head = binaryTree.addNode(7, head);
		head = binaryTree.addNode(19, head);
		head = binaryTree.addNode(20, head);
		head = binaryTree.addNode(-1, head);
		head = binaryTree.addNode(21, head);
		System.out.println(binaryTree.height(head));
	}
}