package com.company.cleartax;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class Parser {
	public static Node parse1(JsonObject input) {
		Node node = new Node();
		JsonElement lhs = input.get(Constants.LHS);
		if (lhs.isJsonObject()) {
			node.leftNode = parse1(lhs.getAsJsonObject());
		} else if (lhs.isJsonPrimitive()) {
			JsonPrimitive lhsPrimitive = lhs.getAsJsonPrimitive();
			if (lhsPrimitive.isNumber()) {
				node.leftValue = lhs.getAsInt();
			} else if (lhsPrimitive.isString()) {
				node.leftVariable = lhs.getAsString();
				node.isLeftVariable = true;
			}
		}

		node.operator = Operators.getOperator(input.get(Constants.OPERATION).getAsString());

		JsonElement rhs = input.get(Constants.RHS);
		if (rhs.isJsonObject()) {
			node.rightNode = parse1(rhs.getAsJsonObject());
		} else if (rhs.isJsonPrimitive()) {
			JsonPrimitive rhsPrimitive = rhs.getAsJsonPrimitive();
			if (rhsPrimitive.isNumber()) {
				node.rightValue = rhs.getAsInt();
			} else if (rhsPrimitive.isString()) {
				node.rightVariable = rhs.getAsString();
				node.isRightVariable = true;
			}
		}
		if (node.rightNode != null && (node.rightNode.isRightVariable || node.rightNode.isLeftVariable  )) {
			node.isRightVariable = true;
		}
		if (node.leftNode != null && (node.leftNode.isRightVariable || node.leftNode.isLeftVariable  )) {
			node.isLeftVariable = true;

		}
		return node;
	}
}