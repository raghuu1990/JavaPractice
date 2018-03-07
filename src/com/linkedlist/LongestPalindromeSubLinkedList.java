package com.linkedlist;

import java.util.ArrayList;
import java.util.Scanner;

import com.node.Node;

/*
http://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1

1
30
0 1 L 0 2 R  1 3 L 1 4 R  2 5 L 2 6 R  3 7 L 3 8 R  4 9 L 4 10 R  5 11 L 5 12 R  6 13 L 6 14 R  7 15 L 7 16 R  8 17 L 8 18 R  9 19 L 9 20 R  10 21 L 10 22 R  11 23 L 11 24 R  12 25 L 12 26 R  13 27 L 13 28 R  14 29 L 14 30 R  

Its Correct output is:
15 7 16 3 17 8 18 1 19 9 20 4 21 10 22 0 23 11 24 5 25 12 26 2 27 13 28 6 29 14 30
30 14 29 6 28 13 27 2 26 12 25 5 24 11 23 0 22 10 21 4 20 9 19 1 18 8 17 3 16 7 15

*/
public class LongestPalindromeSubLinkedList {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		ArrayList<Node> input = new ArrayList<Node>();
		for (int i = 0; i < T; i++) {
			Node head = null;
			Node end = null;
			int L = in.nextInt();
			for (int j = 0; j < L; j++) {
				Node node = new Node();
				node.data = in.nextInt();
				if (head == null) {
					head = node;
				} else {
					end.next = node;
				}
				end = node;
			}
			input.add(head);
		}
		for (int i = 0; i < input.size(); i++) {
			System.out.println(longestPalindromeSubLinkedList(input.get(i)));
		}
		in.close();
	}

	private static int longestPalindromeSubLinkedList(Node head) {
		Node node = head;
		int length = Node.length(node);
		
		int table[][] = new int[length][length];

		for (int a = 0; a < length; a++) {
			for (int b = 0; b < length; b++) {
				if (a == b) {
					table[a][b] = 1;
				} else {
					table[a][b] = 0;
				}
			}
		}

		int start = 0;
		int maxLength = 1;
		for (int c = 0; c < length - 1; c++) {
			if (node.data == node.next.data) {
				table[c][c + 1] = 2;
				maxLength = 2;
				start = c;
			}
			node = node.next;
		}

		node = head;
		for (int k = 3; k <= length; k++) {
			Node node1 = head;
			Node node2 = head;
			for (int i = 1; i < k; i++) {
				if (node2.next != null)
					node2 = node2.next;
			}

			for (int i = 0; i < length - k + 1; i++) {
				int j = i + k - 1;
				if (table[i + 1][j - 1]!=0 && node1.data == node2.data) {
					table[i][j] = k;
					if (k > maxLength) {
						start = i;
						maxLength = k;
					}
				}
				node1 = node1.next;
				node2 = node2.next;
			}

		}
		return maxLength;
	}
}