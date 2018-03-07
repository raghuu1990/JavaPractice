package com.tree;

import java.util.LinkedList;
import java.util.Queue;
import com.node.Node;
import com.node.TreeNode;

// https://www.interviewbit.com/problems/convert-sorted-list-to-binary-search-tree/

public class SortedListToBinarySearchTree {

	public static void main(String[] args) {
		Node root = Node.getLinkedList(5);
		TreeNode tree = sortedListToBST(root);
		System.out.println(tree.data);
	}

	public static TreeNode sortedListToBST(Node a) {
	    Node listRoot = a;
		TreeNode root = new TreeNode(a.data);
		a = a.next;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(a!=null) {
			TreeNode curr = queue.poll();
			TreeNode left = new TreeNode(a.data);
			curr.left = left;
			queue.add(left);
			a = a.next;
			if(a!=null) {
				TreeNode right = new TreeNode(a.data);
				curr.right = right;
				queue.add(right);
				a = a.next;
			}
		}
		fillPreOrder(listRoot, root);
		return root;
	}
	
	public static Node fillPreOrder(Node a, TreeNode root) {
		if(root.left!=null) {
			a = fillPreOrder(a, root.left);
		}
		root.data = a.data;
		a = a.next;
		if(root.right!=null) {
			a = fillPreOrder(a, root.right);
		}
		return a;
	}
}