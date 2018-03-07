package com.trie;

import com.node.TrieNode;

// https://www.geeksforgeeks.org/pattern-searching-using-trie-suffixes/

public class PatternSearching {
	public static TrieNode head = new TrieNode((char) 0);
	
	public static void main(String args[]) {
		String txt = "geeksforgeeks.org";
		addAll(txt);

		TrieNode node;
		String str = "ee";
		
		node = find(str);
		System.out.println("Search for 'ee' : "+getIndexes(node, str.length())+" : "+node.count);

		str = "geek";
		node = find(str);
		System.out.println("Search for 'geek' : "+getIndexes(node, str.length())+" : "+node.count);

		str = "quiz";
		node = find(str);
		System.out.println("Search for 'quiz' : "+getIndexes(node, str.length())+" : "+node.count);
		
		str = "forgeeks";
		node = find(str);
		System.out.println("Search for 'forgeeks' : "+getIndexes(node, str.length())+" : "+node.count);
	}
	
	private static String getIndexes(TrieNode node, int sub) {
		StringBuffer sb = new StringBuffer();
		if(node.indexes!=null) {
			for (Integer i : node.indexes) {
				sb.append(i-sub+1+" ");
			}
		}
		return sb.toString();
	}

	private static void addAll(String text) {
		for (int i = 0; i < text.length(); i++) {
			add(text.substring(i), i);
		}
	}

	private static void add(String text, int index) {
		TrieNode curr = head;
		for (char c : text.toCharArray()) {
			if (curr.childrens.containsKey(c)) {
				curr = curr.childrens.get(c);
			} else {
				TrieNode node = new TrieNode(c);
				curr.childrens.put(c, node);
				curr = node;
			}
			curr.indexes.add(index++);
			curr.count++;
		}
		curr.isEnd = true;
	}

	private static TrieNode find(String pattern) {
		TrieNode curr = head;
		for (char c : pattern.toCharArray()) {
			if (curr.childrens.containsKey(c)) {
				curr = curr.childrens.get(c);
			} else {
				return new TrieNode((char) 0);
			}
		}
		return curr;
	}
}