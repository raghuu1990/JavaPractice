package com.interview.tree;

// http://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/

public class AddGreaterValueNodeToEveryNode {

	public static void main(String args[]) {
		BinaryTree bt = new BinaryTree();
		Node root = null;
		root = bt.addNode(10, root);
		root = bt.addNode(5, root);
		root = bt.addNode(20, root);
		root = bt.addNode(15, root);
		root = bt.addNode(25, root);

		MaxValue maxValue = new MaxValue();
		maxValue.val = 0;
		add(root, maxValue);
		TreeTraversals tt = new TreeTraversals();
		tt.inOrder(root);
	}

	public static void add(Node root, MaxValue maxValue) {
		if (root == null) {
			return;
		}
		add(root.right, maxValue);
		root.data += maxValue.val;
		maxValue.val = root.data;
		add(root.left, maxValue);
	}
}

class MaxValue {
	int val;
}