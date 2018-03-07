package com.tree;

import java.util.ArrayList;
import java.util.Arrays;
import com.node.MultiChildTreeNode;

// https://www.interviewbit.com/problems/largest-distance-between-nodes-of-a-tree/

public class MaximumDistance {
	public static void main(String[] args) {
		/*ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(-1);
		A.add(0);
		A.add(0);
		A.add(1);
		A.add(2);
		A.add(1);
		A.add(5);
		*/
		
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(-1, 0, 0, 1, 0, 4, 5, 5, 5, 6, 8, 7, 10, 2, 2, 1, 12, 6, 13, 1, 16, 1, 2, 14, 5, 7, 13, 18, 26, 24, 16, 3, 21, 7, 3, 0, 32, 13, 19, 13, 1, 25, 38, 32, 3, 41, 13, 6, 14, 12, 38, 20, 13, 19, 5, 4, 22, 9, 21, 9, 55, 53, 61, 0, 55, 27, 20, 11, 51, 50, 48, 53, 42, 9, 48, 17, 38, 27, 0, 36, 51, 26, 33, 5, 22, 67, 15, 78, 28, 65, 69, 14, 24, 28, 9, 27, 18, 59, 28, 40));
		solve(A);
		System.out.println(maxDis);
	}
	
	private static int maxDis = 0;
	public static int solve(ArrayList<Integer> A) {
		MultiChildTreeNode root = createTree(A);
		maxDistance(root);
		return maxDis;
    }

	public static int maxDistance(MultiChildTreeNode root) {
		if(root==null) {
			return 0;
		}
		int max = 0;
		int secondMax = 0;
		for (int i = 0; i < root.list.size(); i++) {
			int dis = maxDistance(root.list.get(i))+1;
			if(dis>=max) {
				secondMax = max;
				max = dis;
			}else if(dis>=secondMax) {
				secondMax = dis;
			}
		}
		maxDis = Math.max(max+secondMax, maxDis);
		return max;
	}

	private static MultiChildTreeNode createTree(ArrayList<Integer> a) {
		ArrayList<MultiChildTreeNode> treeNodes = new ArrayList<MultiChildTreeNode>();
		for (int i = 0; i < a.size(); i++) {
			treeNodes.add(new MultiChildTreeNode(i));
		}
		for (int i = 1; i < a.size(); i++) {
			treeNodes.get(a.get(i)).list.add(treeNodes.get(i));
		}
		return treeNodes.get(0);
	}
}