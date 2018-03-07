package com.stack;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianByPriorityQueue {
	private static PriorityQueue<Integer> highers = new PriorityQueue<Integer>(); // MinHash
	private static PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(Collections.reverseOrder()); // Maxhash

	/*
		private static PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(
			new Comparator<Integer>() {
		  		public int compare(Integer a, Integer b) {
		 			return -1 * a.compareTo(b); 
		  		} 
		 	}
		 );
	 */

	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[] input = new int[t];
		for (int i = 0; i < t; i++) {
			input[i] = in.nextInt();

		}
		for (int i = 0; i < t; i++) {
			add(input[i]);
			Double median = getMedian();
			System.out.println(median);
		}
		in.close();
	}

	public static void add(Integer data) {
		if (lowers.size() == 0 || data < lowers.peek()) {
			lowers.add(data);
		} else {
			highers.add(data);
		}
		balanceHeaps();
	}

	private static void balanceHeaps() {
		if (lowers.size() == highers.size()) {
			return;
		}
		PriorityQueue<Integer> bigger = lowers.size() > highers.size() ? lowers : highers;
		PriorityQueue<Integer> smaller = lowers.size() > highers.size() ? highers : lowers;

		while(bigger.size()-smaller.size()>=2) {
			smaller.add(bigger.poll());
		}
	}

	private static Double getMedian() {
		if (lowers.size() == highers.size()) {
			return ((double) lowers.peek())/2 + ((double) highers.peek()) / 2;
		} else if (lowers.size() < highers.size()) {
			return (double) highers.peek();
		} else {
			return (double) lowers.peek();
		}
	}
}