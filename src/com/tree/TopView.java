package com.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

import com.node.TreeNode;

class QNode {
	TreeNode node;
	int hd;

	public QNode(TreeNode n, int hd) {
		node = n;
		this.hd = hd;
	}
}

public class TopView {
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
		//Node root = new Node(1, null,new Node(2, null, new Node(5, new Node(3, null, new Node(4, null, null)), new Node(6, null, null))));
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, new TreeNode(6, null, new TreeNode(7, null, null)))), new TreeNode(3, null, null));
		topView1(root);
	}

	public static void topView1(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<QNode> queue = new LinkedList<QNode>();
		queue.add(new QNode(root, 0));
		HashSet<Integer> set = new HashSet<Integer>();
		TreeMap<Integer, TreeNode> output = new TreeMap<Integer, TreeNode>();

		while (!queue.isEmpty()) {
			QNode qnode = queue.poll();
			TreeNode node = qnode.node;
			Integer hd = qnode.hd;

			if (!set.contains(hd)) {
				set.add(hd);
				output.put(hd, node);
			}

			if (node.left != null) {
				queue.add(new QNode(node.left, hd - 1));
			}

			if (node.right != null) {
				queue.add(new QNode(node.right, hd + 1));
			}
		}

		Set<Integer> keys = output.keySet();
		for(int key : keys) {
			System.out.print(output.get(key).data+ " ");
		}
	}

	public static void topView(TreeNode root) {
		if (root == null) {
			return;
		}
		printLeft(root.left);
		System.out.print(root.data + " ");
		printRight(root.right);
	}

	private static void printLeft(TreeNode root) {
		if (root != null) {
			printLeft(root.left);
			System.out.print(root.data + " ");
		}
	}

	private static void printRight(TreeNode root) {
		if (root != null) {
			System.out.print(root.data + " ");
			printRight(root.right);
		}
	}
}