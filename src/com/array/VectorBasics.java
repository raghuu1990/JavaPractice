package com.array;

import java.util.ArrayList;
import java.util.Vector;

public class VectorBasics {
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		v.add(0);
		v.addElement(null);

		int i = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(i);
		arr.add(null);
	}
}