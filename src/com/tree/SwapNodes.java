package com.tree;

import java.util.Scanner;

import com.node.TreeNode;

// https://www.hackerrank.com/challenges/swap-nodes-algo
public class SwapNodes {
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		TreeNode[] arr = new TreeNode[N];
		arr[0] = new TreeNode(1);
		for (int i = 1; i <= N; i++) {
			TreeNode curr = arr[i-1];
			int a = in.nextInt();
			int b = in.nextInt();
			if(a==-1) {
				curr.left = null;
			}else {
				curr.left = new TreeNode(a);
				arr[a-1] = curr.left;
			}
			if(b==-1) {
				curr.right = null;
			}else {
				curr.right = new TreeNode(b);
				arr[b-1] = curr.right;
			}
		}
		
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int j = in.nextInt();
			int h = height(arr[0]);
			for (int m = 1; m*j < h; m++) {
				swap(arr[0], j*m, 0);
			}
			print(arr[0]);
			System.out.println();
		}
		in.close();
	}

	private static int height(TreeNode node) {
		if(node==null) {
			return 0;
		}
		return Math.max(height(node.right), height(node.left))+1;
	}

	private static void swap(TreeNode root, int n, int h) {
		if(root == null) {
			return ;
		}
		if(n-1==h) {
			TreeNode temp = root.right;
			root.right = root.left;
			root.left = temp;
			return;
		}
		swap(root.left, n, h+1);
		swap(root.right, n, h+1);
	}

	private static void print(TreeNode root) {
		if(root==null) {
			return;
		}
		print(root.left);
		System.out.print(root.data+" ");
		print(root.right);
	}
}