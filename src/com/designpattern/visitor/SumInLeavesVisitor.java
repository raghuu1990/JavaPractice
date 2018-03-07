package com.designpattern.visitor;

public class SumInLeavesVisitor extends TreeVis {
	int sum = 0;

	public int getResult() {
		return sum;
	}

	public void visitNode(TreeNode node) {
	}

	public void visitLeaf(TreeLeaf leaf) {
		sum += leaf.getValue();
	}
}