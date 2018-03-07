package com.DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/gridland-metro/problem

public class GridlandMetro {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int t = in.nextInt();

		HashMap<Integer, Train> trains = new HashMap<Integer, Train>();
		for (int i = 0; i < t; i++) {
			int r = in.nextInt();
			int c1 = in.nextInt();
			int c2 = in.nextInt();
			if (trains.containsKey(r)) {
				trains.get(r).addPair(c1, c2);
			} else {
				trains.put(r, new Train(r, c1, c2));
			}
		}

		Long total = (long) n * ((long) m);
		for (int row : trains.keySet()) {
			trains.get(row).updatePairs();
			List<Pair> pairs = trains.get(row).pairs;
			for (Pair pair : pairs) {
				total -= ((pair.end - pair.start) + 1);
			}
		}

		System.out.println(total + "");
		in.close();
	}
}

class Train {
	int row;
	ArrayList<Pair> pairs = new ArrayList<Pair>();

	public Train(int row, int c1, int c2) {
		this.row = row;
		pairs.add(new Pair(c1, c2));
	}

	public void addPair(int c1, int c2) {
		pairs.add(new Pair(c1, c2));
	}

	public void updatePairs() {
		Collections.sort(this.pairs);
		ArrayList<Pair> newPairs = new ArrayList<Pair>();
		int index = 0;
		for (int i = 0; i < pairs.size(); i++) {
			Pair pair = pairs.get(i);
			if (i != 0) {
				Pair lastPair = newPairs.get(index - 1);
				if (pair.end >= lastPair.start) {
					lastPair.start = Math.min(lastPair.start, pair.start);
					lastPair.end = Math.max(lastPair.end, pair.end);
				} else {
					newPairs.add(pair);
					index++;
				}
			} else {
				newPairs.add(pair);
				index++;
			}
		}
		pairs = newPairs;
	}
}

class Pair implements Comparable<Pair> {
	Integer start;
	Integer end;

	public Pair() {
	}

	public Pair(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Pair o) {
		return o.end.compareTo(this.end);
	}
}