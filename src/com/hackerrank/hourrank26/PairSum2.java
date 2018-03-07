package com.hackerrank.hourrank26;

import java.io.*;
import java.util.*;

// https://www.hackerrank.com/contests/hourrank-26/challenges/pair-sums/problem

public class PairSum2 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		long[] sumArr = new long[n + 1];
		long[] sqrArr = new long[n + 1];
		for (int i = 0; i < n; i++) {
			sumArr[i + 1] = sumArr[i] + arr[i];
			sqrArr[i + 1] = sqrArr[i] + arr[i] * arr[i];
		}

		Node.xs = sumArr.clone();
		Arrays.sort(Node.xs);
		Node root = new Node(0, n + 1);

		// V(i,j) = (Sum_j-Sun_i)^2 - (sqr_j-sqr_i)
		// V(i,j) = (Sum_j^2-sqr_j) + (Sun_i^2+sqr_i) - 2*(Sun_i*Sum_j)
		long max = 0;
		for (int i = 0; i <= n; i++) {
			int idx = Arrays.binarySearch(Node.xs, sumArr[i]);
			long constant1 = sumArr[i] * sumArr[i] - sqrArr[i];
			long constant2 = sumArr[i] * sumArr[i] + sqrArr[i];
			max = Math.max(max, root.getBest(idx) + constant1);
			root.insert(0, n + 1, new Line(-2 * sumArr[i], constant2));
		}

		System.out.println(max / 2);
		in.close();
	}
}

class Node {
	static long[] xs;

	int l, r;
	Node left, right;
	Line best;

	public Node(int l, int r) {
		this.l = l;
		this.r = r;
		if (r - l > 1) {
			int m = (l + r) >> 1;
			left = new Node(l, m);
			right = new Node(m, r);
		}
	}

	long getBest(int idx) {
		long ret = (best == null ? Long.MIN_VALUE : best.eval(xs[idx]));
		if (r - l > 1) {
			ret = Math.max(ret, (idx < left.r ? left : right).getBest(idx));
		}
		return ret;
	}

	void insert(int ql, int qr, Line add) {
		if (l >= qr || ql >= r) {
			return;
		}
		if (!(ql <= l && r <= qr)) {
			left.insert(ql, qr, add);
			right.insert(ql, qr, add);
			return;
		}

		if (best == null) {
			best = add;
			return;
		}

		// int cl = compareLines(best, add, dirs[l]);
		int cl = Long.compare(best.eval(xs[l]), add.eval(xs[l]));
		int cr = Long.compare(best.eval(xs[r - 1]), add.eval(xs[r - 1]));
		if (cl >= 0 && cr >= 0) {
			return;
		}
		if (cl <= 0 && cr <= 0) {
			best = add;
			return;
		}

		// int cm = compareLines(best, add, dirs[left.r]);
		int cm = Long.compare(best.eval(xs[left.r]), add.eval(xs[left.r]));
		if (cm < 0) {
			Line tmp = add;
			add = best;
			best = tmp;
			cl = -cl;
			cr = -cr;
		}
		// cm >= 0
		if (cl > 0) {
			right.insert(ql, qr, add);
		} else {
			left.insert(ql, qr, add);
		}
	}
}

// f(x)= m*x + b
class Line {
	long m, b;

	public Line(long m, long b) {
		this.m = m;
		this.b = b;
	}

	long eval(long x) {
		return m * x + b;
	}
}