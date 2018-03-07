package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.node.DNode;

/*
Time Complexity: O(n^2) in worst case. For a skewed tree, printGivenLevel() takes O(n) time
where n is the number of nodes in the skewed tree.
So time complexity of printLevelOrder() is O(n) + O(n-1) + O(n-2) + .. + O(1) which is O(n^2).

Time Complexity: O(n) using queue
*/

public class LevelOrder {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		ArrayList<DNode> input = new ArrayList<DNode>();
		for (int i = 0; i < T; i++) {
			DNode root = null;
			DNode node = null;
			int L = in.nextInt();
			for (int j = 0; j < L; j++) {
				int a = in.nextInt();
				int b = in.nextInt();
				String s = in.next();

				if (root == null) {
					node = new DNode(a);
					root = node;
				} else {
					node = root.getNode(root, a, s);
				}
				if (s.equalsIgnoreCase("R")) {
					node.right = new DNode(b);
				} else {
					node.left = new DNode(b);
				}
			}
			input.add(root);
		}
		for (int i = 0; i < input.size(); i++) {
			//printLevelOrder(input.get(i));
			printLevelOrderUsingQueue(input.get(i));
			System.out.println();
		}
		in.close();
	}

	public static void printLevelOrder(DNode root) {
		int h = DNode.height(root);
		int i;
		for (i = 1; i <= h; i++) {
			printGivenLevel(root, i);
		}
	}

	public static void printGivenLevel(DNode root, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.print(root.data + " ");
		} else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	public static void printLevelOrderUsingQueue(DNode root) {
		Queue<DNode> queue = new LinkedList<DNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			DNode tempNode = queue.poll();
			System.out.print(tempNode.data + " ");
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}
	
	public static void printLevelOrderUsingQueueRtoL(DNode root) {
		Queue<DNode> queue = new LinkedList<DNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			DNode tempNode = queue.poll();
			System.out.print(tempNode.data + " ");
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}
		}
	}
	
	public ArrayList<ArrayList<Integer>> levelOrder(DNode A) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> list = new ArrayList<Integer>(); 
        Queue<DNode> queue = new LinkedList<DNode>();
		queue.add(A);
		DNode empty = new DNode(0);
		queue.add(empty);
		
		while (!queue.isEmpty()) {
			DNode tempNode = queue.poll();
			if(tempNode.data==0) {
				result.add(list);
				list = new ArrayList<Integer>();
				if(!queue.isEmpty()) {
					queue.add(empty);
				}
				continue;
			}
			list.add(tempNode.data);
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
		return result;
    }
}
