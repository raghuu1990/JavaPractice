package com.search;

import java.util.Scanner;
import java.util.TreeSet;

// https://www.hackerrank.com/challenges/minimum-loss/problem

public class MinimumLoss {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] price = new long[n];
		for (int i = 0; i < n; i++) {
			price[i] = in.nextLong();
		}
		long result = minimumLoss(price);
		System.out.println(result);
		in.close();
	}

	static long minimumLoss(long[] price) {
		long min = Integer.MAX_VALUE;
		TreeSet<Long> treeSet = new TreeSet<Long>();
		treeSet.add(price[0]);
		for (int i = 1; i < price.length; i++) {
			if(treeSet.higher(price[i])!=null) {
				min = Math.min(Math.abs(treeSet.higher(price[i]) - price[i]), min);
			}
			treeSet.add(price[i]);
		}
		return min;
	}
}

class BBST{
	int data;
	int index;
	BBST left;
	BBST right;
	
	public BBST(int data, int index) {
		this.data = data;
		this.index = index;
	}
}