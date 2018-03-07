package com.trie;

import java.util.Scanner;

import com.node.TrieNode;

// https://www.hackerrank.com/challenges/no-prefix-set/problem

public class NoPrefixSet {
	public static TrieNode head = new TrieNode((char) 0);

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		boolean isBad = false;
		for (int i = 0; i < n; i++) {
			String input = in.next();
			if(addAndCheckIsPrefixExists(input)) {
				System.out.println("BAD SET");
				System.out.println(input);
				isBad = true;
				break;
			}
		}
		if(!isBad) {
			System.out.println("GOOD SET");
		}
		in.close();
	}

	private static boolean addAndCheckIsPrefixExists(String contact) {
		boolean isThisPrefix = true;
		// To check current add is prefix of existing.
		TrieNode curr = head;
		for (char c : contact.toCharArray()) {
			if (curr.childrens.containsKey(c)) {
				curr = curr.childrens.get(c);
				if(curr.isEnd) {
					return true;
				}
			} else {
				isThisPrefix = false;
				TrieNode node = new TrieNode(c);
				curr.childrens.put(c, node);
				curr = node;
			}
			
		}
		curr.isEnd = true;
		return isThisPrefix;
	}
}