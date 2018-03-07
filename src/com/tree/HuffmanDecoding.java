package com.tree;

import java.util.Scanner;

import com.node.HuffmanNode;

// https://www.hackerrank.com/challenges/tree-huffman-decoding/problem

/*	
			{ϕ,5}
	 	 0 /     \ 1
		{ϕ,2}   {A,3}
	   0/   \1
	 {B,1}  {C,1}

*/
public class HuffmanDecoding {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HuffmanNode node = new HuffmanNode('ϕ', 5,
				new HuffmanNode('ϕ', 2, new HuffmanNode('B', 1), new HuffmanNode('C', 1)), new HuffmanNode('A', 3));
		// String str = in.nextLine();
		String str = "1001011";
		decode(node, str);
		in.close();
	}

	private static void decode(HuffmanNode node, String str) {
		char[] chars = str.toCharArray();
		HuffmanNode currNode = node;
		for (int i = 0; i < chars.length; i++) {
			int ch = chars[i] - 48;
			if (ch == 1) {
				currNode = currNode.right;
			} else {
				currNode = currNode.left;
			}
			if (currNode.right == null && currNode.left == null) {
				System.out.print(currNode.data);
				currNode = node;
			}
		}
	}
}