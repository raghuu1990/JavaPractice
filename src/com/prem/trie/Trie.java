package com.prem.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * TrieNode -> {char data, Map<char,TNode> children,boolean isEnd }
 * # get a root having null value and blank children map.
 */

public class Trie {

	private TrieNode root = new TrieNode((char) 0);

	/**
	 * Ex-> abc Take a temp crawlNode initialized with root trieNode check if
	 * root's children map contains 'a' if not contain create a new trieNode
	 * with value a and put in root's children map <a,new trieNode> if contains
	 * get key(a) value -> trieNode, set it to crawlNode
	 * and keep repeating until all abc feeded. set last character trienode
	 * isEnd value -> true
	 */

	public void insert(String word) {
		TrieNode crawl = root;

		for (char ch : word.toCharArray()) {
			Map<Character, TrieNode> children = crawl.getChildren();
			if (children.containsKey(ch)) {
				crawl = children.get(ch);
			} else {
				TrieNode next = new TrieNode(ch);
				children.put(ch, next);
				crawl = next;
			}
		}
		crawl.setEnd(true);
	}

	public void createSuffixTree(String word) {
		for (int i = 0; i < word.length(); i++) {
			TrieNode crawl = root;
			for (char ch : word.substring(i, word.length() - 1).toCharArray()) {
				Map<Character, TrieNode> children = crawl.getChildren();
				if (children.containsKey(ch)) {
					crawl = children.get(ch);
				} else {
					TrieNode temp = new TrieNode(ch);
					children.put(ch, temp);
					crawl = temp;
				}
				crawl.setEnd(true);
			}
		}
	}

	public String getMatchingPrefix(String input) {
		String prefix = "";
		TrieNode crawl = root;
		for (char ch : input.toCharArray()) {
			Map<Character, TrieNode> children = crawl.getChildren();
			if (children.containsKey(ch)) {
				prefix += ch;
				crawl = children.get(ch);
			} else {
				break;
			}
		}
		return prefix;
	}

	public boolean startsWith(String input) {
		TrieNode crawl = root;
		for (char ch : input.toCharArray()) {
			Map<Character, TrieNode> children = crawl.getChildren();
			if (children.containsKey(ch)) {
				crawl = children.get(ch);
			} else {
				return false;
			}
		}
		return true;
	}

	public List<String> getPrefixMatchingList(String prefix) {
		TrieNode crawl = root;
		List<String> result = new ArrayList<>();
		for (char ch : prefix.toCharArray()) {
			Map<Character, TrieNode> children = crawl.getChildren();
			if (children.containsKey(ch)) {
				TrieNode node = children.get(ch);
			} else {
				break;
			}
		}
		return result;
	}

	public boolean wordExist(String input) {
		TrieNode crawl = root;
		for (char ch : input.toCharArray()) {
			Map<Character, TrieNode> child = crawl.getChildren();
			if (!child.containsKey(ch)) {
				return false;
			} else {
				crawl = child.get(ch);
			}
		}
		return crawl.isEnd();
	}

	public boolean patternExist(String input) {
		if (input.endsWith("*")) {
			return getMatchingPrefix(input.substring(0, input.length() - 2)).length() > 0;
		}
		if (input.startsWith("*")) {
			input = input.substring(1, input.length() - 1);
		}
		if (input.contains("*")) {
			return getMatchingPrefix(input.split("_")[0]).length() > 0 && wordExist(input.split("_")[1]);
		}
		return wordExist(input);
	}

	/*
	 * public boolean deleteWord(TNode tNode,String input){
	 *  	TNode crawl = root;
	 * 		Map<Character,TNode> children= crawl.getChildren(); 
	 * 		if(input.length()>1) {
	 * 			 char ch=input.charAt(0); 
	 * 			 if (children.containsKey(ch)) {
	 * 				deleteWord(children.get(ch),input.substring(1,input.length()-1)); 
	 * 			 } 
	 * 		} else if(children.keySet().size()==1){
	 * 			 crawl=null; 
	 * 		} else if(input.length()==1 && crawl.isEnd()){
	 * 	 		crawl=null;
	 * 		}
	 * 		return false; 
	 * }
	 */

	/**
	 * if check word exist in try which we're gonna delete 
	 * 1. if doesn't exist then on traversing break and return false;
	 * 2. if exist there are two possibilities: last character's isEnd can be true/false
	 * if we want to delete ban in two cases below Ex -> 
	 * 1) b-> a -> n in this case isEnd -> true
	 * 2) b -> a -> n -> d in this case isEnd -> false 
	 * in second case we're not going to delete ban in first case we can delete only n to delete ban
	 *
	 * step 1: while traversing whether word exist or not we'll add each character in stack 
	 * step 2: if last character contains isEnd -> true we'll pop trieNode until it's children's size is 1 or it's children is
	 * empty(for last end node) so, here in ban n will be deleted but a's children size is 2, here it breaks
	 *
	 */

	public boolean deleteWord(TrieNode root, String input) {
		TrieNode crawl = root;
		Stack<TrieNode> nodeKeeper = new Stack<>();
		for (char ch : input.toCharArray()) {
			Map<Character, TrieNode> children = crawl.getChildren();
			if (children.containsKey(ch)) {
				nodeKeeper.push(children.get(ch));
				crawl = children.get(ch);
			} else {
				//return false;
				break;
			}
		}
		if (crawl.isEnd()) {
			while (true) {
				TrieNode lastNode = nodeKeeper.pop();
				if (lastNode.getChildren().size() == 1 || lastNode.getChildren().isEmpty()) {
					lastNode.getChildren().clear();
					// lastNode.setValue((char)0);
					lastNode = null;
				} else {
					break;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("abc");
		trie.insert("abcd");
		trie.insert("abcf");
		trie.insert("abcde");
		trie.insert("bcde");
		trie.insert("abcdefg");

		System.out.println();
		System.out.println(trie.getMatchingPrefix("abcf"));
		System.out.println(trie.getMatchingPrefix("abce"));
		System.out.println(trie.getMatchingPrefix("bcdefg"));
		System.out.println();
		System.out.println(trie.wordExist("abcd"));
		System.out.println(trie.wordExist("abcde"));
		System.out.println(trie.wordExist("cde"));
		System.out.println();
		System.out.println(trie.deleteWord(trie.root, "abcde"));
		System.out.println();
		System.out.println(trie.wordExist("abcf"));
		System.out.println(trie.wordExist("abcd"));
		System.out.println(trie.wordExist("abcde"));
		System.out.println(trie.wordExist("abcdef"));
		System.out.println();
		System.out.println(trie.patternExist("*ef"));
	}
}
