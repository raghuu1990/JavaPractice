package com.company.cleartax;

public enum Operators {

	ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/"), EQUAL("=");

	private String value;

	private Operators(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public static String getAirthmeticSign(String param) {
		Operators response = null;
		for (Operators operator : Operators.values()) {
			if (operator.toString().equalsIgnoreCase(param)) {
				response = operator;
				break;
			}
		}
		return response.getValue();
	}

	public static Operators getOperator(String param) {
		Operators response = null;
		for (Operators operator : Operators.values()) {
			if (operator.toString().equalsIgnoreCase(param)) {
				response = operator;
				break;
			}
		}
		return response;
	}
	
	public static Operators getReverseOperation(Operators operator) {
		if(operator.equals(Operators.ADD)) {
			return Operators.SUBTRACT;
		}else if(operator.equals(Operators.SUBTRACT)) {
			return Operators.SUBTRACT;
		}else if(operator.equals(Operators.MULTIPLY)) {
			return Operators.DIVIDE;
		}else if(operator.equals(Operators.DIVIDE)) {
			return Operators.MULTIPLY;
		}
		return null;
	}

	public static Integer solve(Integer lhs, Integer rhs, Operators operator) {
		if (operator.equals(Operators.ADD)) {
			return lhs + rhs;
		} else if (operator.equals(Operators.SUBTRACT)) {
			return lhs - rhs;
		} else if (operator.equals(Operators.MULTIPLY)) {
			return lhs * rhs;
		} else if (operator.equals(Operators.DIVIDE)) {
			return lhs / rhs;
		}
		return null;
	}
}