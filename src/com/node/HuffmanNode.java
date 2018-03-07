package com.node;

public class HuffmanNode {
	public int frequency;
	public char data;
	public HuffmanNode left = null;
	public HuffmanNode right = null;

	public HuffmanNode() {
	}
	
	public HuffmanNode(char data, int frequency) {
		super();
		this.frequency = frequency;
		this.data = data;
	}
	
	public HuffmanNode(char data, int frequency, HuffmanNode left, HuffmanNode right) {
		super();
		this.frequency = frequency;
		this.data = data;
		this.left = left;
		this.right = right;
	}
}