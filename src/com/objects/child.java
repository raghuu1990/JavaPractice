package com.objects;

public class child {
	parent p;

	public parent getP() {
		return p;
	}

	public void setP(parent p) {
		this.p = p;
	}

	child() {
		System.out.println("constructor child");
	}

	public void print() {
		p.print();
		System.out.println("print child");
	}

	public static void main(String[] args) {
		child c = new child();
	}

}
