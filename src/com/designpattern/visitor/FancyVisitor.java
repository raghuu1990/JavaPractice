package com.designpattern.visitor;

public class FancyVisitor extends TreeVis {
	int sumEvenDepthTreeNodes = 0;
	int sumGreenLeafesNodes = 0;

	public int getResult() {
		return Math.abs(sumEvenDepthTreeNodes - sumGreenLeafesNodes);
	}

	public void visitNode(TreeNode node) {

		if (node.getDepth() % 2 == 0) {
			sumEvenDepthTreeNodes += node.getValue();
		}
	}

	public void visitLeaf(TreeLeaf leaf) {
		if (leaf.getColor().equals(Color.GREEN)) {
			sumGreenLeafesNodes += leaf.getValue();
		}
	}
}