package com.maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/s10-interquartile-range/problem

public class InterquartileRange {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Pair> pairs = new ArrayList<Pair>();

		for (int i = 0; i < n; i++) {
			pairs.add(new Pair(in.nextInt()));
		}

		int freqSum = 0;
		for (int i = 0; i < n; i++) {
			int freq = in.nextInt();
			freqSum += freq;
			pairs.get(i).freq = freq;
		}

		Collections.sort(pairs);
		int start = 0;
		for (int i = 0; i < n; i++) {
			Pair pair = pairs.get(i);
			pair.start = start;
			int end = start + pair.freq - 1;
			pair.end = end;
			start = end + 1;
		}

		int q1StartIndex = 0;
		int q1EndIndex = (freqSum / 2) - 1;
		int q3StartIndex = (freqSum + 1) / 2;
		int q3EndIndex = freqSum - 1;

		if ((q1EndIndex - q1StartIndex) % 2 == 0) {
			q1StartIndex = (q1EndIndex + q1StartIndex) / 2;
			q1EndIndex = -1;
		} else {
			q1StartIndex = (q1EndIndex + q1StartIndex) / 2;
			q1EndIndex = q1StartIndex + 1;
		}

		if ((q3EndIndex - q3StartIndex) % 2 == 0) {
			q3StartIndex = (q3EndIndex + q3StartIndex) / 2;
			q3EndIndex = -1;
		} else {
			q3StartIndex = (q3EndIndex + q3StartIndex) / 2;
			q3EndIndex = q3StartIndex + 1;
		}

		double Q1 = 0;
		double Q3 = 0;

		for (int i = 0; i < pairs.size(); i++) {
			Pair pair = pairs.get(i);
			if (q1StartIndex >= pair.start && q1StartIndex <= pair.end) {
				Q1 = pair.value;
			}

			if (q1EndIndex != -1 && q1EndIndex >= pair.start && q1EndIndex <= pair.end) {
				Q1 = ((double) (Q1 + pair.value)) / 2;
			}

			if (q3StartIndex >= pair.start && q3StartIndex <= pair.end) {
				Q3 = pair.value;
			}

			if (q3EndIndex != -1 && q3EndIndex >= pair.start && q3EndIndex <= pair.end) {
				Q3 = ((double) (Q3 + pair.value)) / 2;
			}
		}

		System.out.printf("%.1f", Q3 - Q1);
		in.close();
	}
}

class Pair implements Comparable<Pair> {
	Integer value;
	int start;
	int end;
	int freq;

	public Pair(int value) {
		this.value = value;
	}

	@Override
	public int compareTo(Pair pair) {
		return this.value.compareTo(pair.value);
	}
}