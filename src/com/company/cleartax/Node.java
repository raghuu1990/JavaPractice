package com.company.cleartax;

public class Node {
	Operators operator;
	Node leftNode;
	Node rightNode;

	boolean isLeftVariable;
	String leftVariable;

	boolean isRightVariable;
	String rightVariable;

	Integer rightValue;
	Integer leftValue;

	Integer sum;
	Integer rightSum;
	Integer leftSum;

	public void print(boolean isFirst) {
		if (this.leftNode != null) {
			if (!isFirst) {
				System.out.print("(");
			}
			this.leftNode.print(false);
			if (!isFirst) {
				System.out.print(")");
			}
		} else {
			if (this.isLeftVariable) {
				System.out.print(this.leftVariable);
			} else {
				System.out.print(this.leftValue);
			}
		}

		System.out.print(" " + this.operator.getValue() + " ");

		if (this.rightNode != null) {
			if (!isFirst) {
				System.out.print("(");
			}
			this.rightNode.print(false);
			if (!isFirst) {
				System.out.print(")");
			}
		} else {
			if (this.isRightVariable) {
				System.out.print(this.rightVariable);
			} else {
				System.out.print(this.rightValue);
			}
		}
	}

	public void solve() {
		if (this.leftNode != null) {
			this.leftNode.solve();
			this.leftSum = this.leftNode.sum;
		} else {
			this.leftSum = this.leftValue;
		}

		if (this.rightNode != null) {
			this.rightNode.solve();
			this.rightSum = this.rightNode.sum;
		} else {
			this.rightSum = this.rightValue;
		}
		this.sum = Operators.solve(this.leftSum, this.rightSum, this.operator);
	}

	public void solveRHS() {
		if (this.rightNode != null) {
			this.rightNode.solve();
			this.rightSum = rightNode.sum;
		} else {
			this.rightSum = this.rightValue;
		}
	}

	public Node reverse() {
		if (this.leftNode == null) {
			return this;
		}
		Node rhsNode = new Node();
		Node lhsNode = this.leftNode;

		if (this.rightNode == null) {
			rhsNode.leftValue = this.rightValue;
			this.rightValue = null;
		} else {
			rhsNode.leftNode = this.rightNode;
			this.rightNode = null;
		}
		
		while (true) {
			if (lhsNode.isLeftVariable && lhsNode.leftNode == null) {
				rhsNode.operator = Operators.getReverseOperation(lhsNode.operator);
				if (lhsNode.rightNode == null) {
					rhsNode.rightValue = lhsNode.rightValue;
					lhsNode.rightValue = null;
				} else {
					rhsNode.rightNode = lhsNode.rightNode;
				}
				lhsNode.rightNode = rhsNode;
				lhsNode.operator = Operators.EQUAL;
				return lhsNode;
			} else if (lhsNode.isLeftVariable) {
				rhsNode.operator = Operators.getReverseOperation(lhsNode.operator);
				if (lhsNode.rightNode == null) {
					rhsNode.rightValue = lhsNode.rightValue;
				} else {
					rhsNode.rightNode = lhsNode.rightNode;
				}
				Node newRhsNode = new Node();
				newRhsNode.leftNode = rhsNode;
				rhsNode = newRhsNode;
				lhsNode = lhsNode.leftNode;
			} else if (lhsNode.isRightVariable && lhsNode.rightNode == null) {
				if(lhsNode.operator == Operators.MULTIPLY || lhsNode.operator == Operators.ADD) {
					rhsNode.operator = Operators.getReverseOperation(lhsNode.operator);
					if (lhsNode.leftNode == null) {
						rhsNode.rightValue = lhsNode.leftValue;
					} else {
						rhsNode.rightNode = lhsNode.leftNode;
					}
				}else {
					rhsNode.operator = lhsNode.operator;
					if (lhsNode.leftNode == null) {
						rhsNode.rightValue = rhsNode.leftValue;
						rhsNode.leftValue = lhsNode.leftValue;
					} else {
						rhsNode.rightNode = rhsNode.leftNode;
						rhsNode.leftNode = lhsNode.leftNode;
					}
				}
				
				lhsNode.leftVariable = lhsNode.rightVariable;
				lhsNode.rightVariable = null;
				lhsNode.isRightVariable = false;
				lhsNode.isLeftVariable = true;
				lhsNode.rightNode = rhsNode;
				lhsNode.operator = Operators.EQUAL;
				return lhsNode;
			} else {
				if(lhsNode.operator == Operators.MULTIPLY || lhsNode.operator == Operators.ADD) {
					rhsNode.operator = Operators.getReverseOperation(lhsNode.operator);
					if (lhsNode.leftNode == null) {
						rhsNode.rightValue = lhsNode.leftValue;
					} else {
						rhsNode.rightNode = lhsNode.leftNode;
					}
				}else {
					rhsNode.operator = lhsNode.operator;
					if (lhsNode.leftNode == null) {
						rhsNode.rightValue = rhsNode.leftValue;
						rhsNode.leftValue = lhsNode.leftValue;
					} else {
						rhsNode.rightNode = rhsNode.leftNode;
						rhsNode.leftNode = lhsNode.leftNode;
					}
				}
				Node newRhsNode = new Node();
				newRhsNode.leftNode = rhsNode;
				rhsNode = newRhsNode;
				lhsNode = lhsNode.rightNode;
			}
		}
	}
}
