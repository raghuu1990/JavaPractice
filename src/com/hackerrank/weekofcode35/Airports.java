package com.hackerrank.weekofcode35;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

// https://www.hackerrank.com/contests/w35/challenges/airports/problem

public class Airports {
	static int MIN, MAX, d;

	static void add(int v, TreeMap<Integer, Integer> m) {
		Integer tn = m.get(v);
		if (tn == null)
			m.put(v, 1);
		else
			m.put(v, tn + 1);
	}

	static void remove(int v, TreeMap<Integer, Integer> m) {
		int tn = m.get(v);
		if (tn == 1)
			m.remove(v);
		else
			m.put(v, tn - 1);
	}

	static void add(int v, TreeMap<Integer, Integer> s, TreeMap<Integer, Integer> seg) {
		if (s.containsKey(v)) {
			s.put(v, s.get(v) + 1);
		} else {
			if (v < MIN) {
				MIN = v;
				Integer pos = s.higherKey(v + d - 1);
				Integer pos2;
				if (pos != null) {
					pos2 = s.lowerKey(pos);
					if (pos2 != null)
						remove(pos - pos2, seg);
				}
				while (pos != null) {
					pos2 = s.higherKey(pos);
					if (pos2 != null) {
						remove(pos2 - pos, seg);
					}
					s.remove(pos);
					pos = pos2;
				}
				if (MAX - MIN < d) {
					s.put(v, 1);
					pos = s.higherKey(v);
					if (pos != null)
						add(pos - v, seg);
				}
			} else if (v > MAX) {
				MAX = v;
				Integer pos = s.lowerKey(v - d + 1);
				Integer pos2;
				if (pos != null) {
					pos2 = s.higherKey(pos);
					if (pos2 != null)
						remove(pos2 - pos, seg);
				}
				while (pos != null) {
					pos2 = s.lowerKey(pos);
					if (pos2 != null) {
						remove(pos - pos2, seg);
					}
					s.remove(pos);
					pos = pos2;
				}
				if (MAX - MIN < d) {
					s.put(v, 1);
					pos = s.lowerKey(v);
					if (pos != null)
						add(v - pos, seg);
				}
			} else {
				Integer pos = s.higherKey(v);
				Integer pos2 = s.lowerKey(v);
				if (pos2 != null && pos != null)
					remove(pos - pos2, seg);
				if (pos != null && MAX - v < d)
					add(pos - v, seg);
				if (pos2 != null && v - MIN < d)
					add(v - pos2, seg);
				if (MAX - v < d && v - MIN < d) {
					add(v, s);
				}
			}
		}
	}

	static int[] airports(int[] x) {
		int n = x.length;
		int[] res = new int[n];
		TreeMap<Integer, Integer> s = new TreeMap<Integer, Integer>();
		TreeMap<Integer, Integer> seg = new TreeMap<Integer, Integer>();
		s.put(x[0], 1);
		MIN = x[0];
		MAX = x[0];
		for (int i = 1; i < n; ++i) {
			add(x[i], s, seg);
			res[i] = d;
			if (MAX - MIN >= d + d || s.size() == 0) {
				res[i] = 0;
				continue;
			}
			if (seg.size() > 0) {
				int kv = seg.lastKey();
				res[i] = Math.min(res[i], d + d - (MAX - MIN + kv));
			}
			Map.Entry<Integer, Integer> entry1 = s.firstEntry();
			Map.Entry<Integer, Integer> entry2 = s.lastEntry();
			int key1 = entry1.getKey();
			int key2 = entry2.getKey();
			if (key1 != MIN) {
				res[i] = Math.min(res[i], d - (key1 - MIN));
				res[i] = Math.min(res[i], d - (MAX - key2));
			} else if (s.size() > 1) {
				if (entry1.getValue() == 1)
					res[i] = Math.min(res[i], d - (s.higherKey(MIN) - MIN));
				if (entry2.getValue() == 1)
					res[i] = Math.min(res[i], d - (MAX - s.lowerKey(MAX)));
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			int n = in.nextInt();
			d = in.nextInt();
			int[] x = new int[n];
			for (int x_i = 0; x_i < n; x_i++) {
				x[x_i] = in.nextInt();
			}
			int[] result = airports(x);
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
			}
			System.out.println("");
		}
		in.close();
	}
}