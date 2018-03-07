package com.clone;

public class Class1 implements Cloneable {
	private int i;

	public static void main(String[] args) {
		Class1 c1 = new Class1();
		try {
			Class1 c2 = (Class1) c1.clone();
			System.out.println(c1 == c2);
			System.out.println(c1.hashCode() == c2.hashCode());
			System.out.println(c1.equals(c2));
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
