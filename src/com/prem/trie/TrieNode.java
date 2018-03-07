package com.prem.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	private char value;
	private boolean isEnd;
	private Map<Character, TrieNode> children;

	public TrieNode(char value) {
		this.value = value;
		children = new HashMap<>();
	}

	public Map<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(HashMap<Character, TrieNode> children) {
		this.children = children;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean end) {
		isEnd = end;
	}

	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}
}