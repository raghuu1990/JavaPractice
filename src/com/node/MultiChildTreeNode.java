package com.node;

import java.util.ArrayList;
import java.util.List;

public class MultiChildTreeNode{
	int data;
	public List<MultiChildTreeNode> list;
	public MultiChildTreeNode(Integer data) {
		this.data = data;
		list = new ArrayList<MultiChildTreeNode>();
	}
}