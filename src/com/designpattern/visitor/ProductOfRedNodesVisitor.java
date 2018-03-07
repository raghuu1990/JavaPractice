package com.designpattern.visitor;

public class ProductOfRedNodesVisitor extends TreeVis {
	long product = 1;
	public static int MOD = 1000000007;

	public int getResult() {
		return (int) product;
	}

	public void visitNode(TreeNode node) {
		if (node.getColor().equals(Color.RED)) {
			product = (product * node.getValue()) % MOD;
		}
	}

	public void visitLeaf(TreeLeaf leaf) {
		if (leaf.getColor().equals(Color.RED)) {
			product = (product * leaf.getValue()) % MOD;
		}
	}
}