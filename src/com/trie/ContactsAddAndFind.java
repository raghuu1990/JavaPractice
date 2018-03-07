package com.trie;

import java.util.Scanner;

import com.node.TrieNode;

// https://www.hackerrank.com/challenges/contacts/problem

public class ContactsAddAndFind {
	public static TrieNode head = new TrieNode((char) 0);

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int outPut[] = new int[n];
		int outputCounter = 0;
		for (int i = 0; i < n; i++) {
			String operation = in.next();
			String contact = in.next();
			if (operation.equalsIgnoreCase("add")) {
				add(contact);
			} else if (operation.equalsIgnoreCase("find")) {
				outPut[outputCounter] = find(contact);
				outputCounter++;
			}
		}

		for (int i = 0; i < outputCounter; i++) {
			System.out.println(outPut[i]);
		}
		in.close();
	}

	private static void add(String contact) {
		TrieNode curr = head;
		for (char c : contact.toCharArray()) {
			if (curr.childrens.containsKey(c)) {
				curr = curr.childrens.get(c);
			} else {
				TrieNode node = new TrieNode(c);
				curr.count++;
				curr.childrens.put(c, node);
				curr = node;
			}
			curr.count++;
		}
		curr.isEnd = true;
	}

	private static int find(String contact) {
		TrieNode curr = head;
		for (char c : contact.toCharArray()) {
			if (curr.childrens.containsKey(c)) {
				curr = curr.childrens.get(c);
			} else {
				return 0;
			}
		}
		return curr.count;
	}
}