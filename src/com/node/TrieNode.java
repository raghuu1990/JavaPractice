package com.node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TrieNode {
	public int count = 0;
	public boolean isEnd;
	public Character value;
	public Set<Integer> indexes;
	public HashMap<Character, TrieNode> childrens;

	public TrieNode(char value) {
		this.value = value;
		indexes = new HashSet<Integer>();
		childrens = new HashMap<Character, TrieNode>();
	}
}