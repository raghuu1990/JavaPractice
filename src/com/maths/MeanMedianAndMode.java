package com.maths;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/s10-basic-statistics/problem

public class MeanMedianAndMode {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] input = new int[n];

		for (int i = 0; i < n; i++) {
			input[i] = in.nextInt();
		}
		mean(input);
		median(input);
		mode(input);
		in.close();
	}

	public static void mean(int[] input) {
		double mean = 0;
		for (int i = 0; i < input.length; i++) {
			mean = (mean * i + input[i]) / (i + 1);
		}
		System.out.println(mean);
	}

	public static void median(int[] input) {
		Arrays.sort(input);
		double median = 0;
		int mid = input.length / 2;
		if (input.length % 2 == 1) {
			median = input[mid];
		} else if (input.length == 2) {
			median = (input[0] + input[1]) / 2;
		} else {
			median = ((double) (input[mid] + input[mid - 1])) / 2;
		}
		System.out.println(median);
	}

	public static void mode(int[] input) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < input.length; i++) {
			if (map.containsKey(input[i])) {
				map.put(input[i], map.get(input[i]) + 1);
			} else {
				map.put(input[i], 1);
			}
		}

		int freq = 0;
		int minMod = Integer.MAX_VALUE;
		for (int i : map.keySet()) {
			if (map.get(i) > freq) {
				freq = map.get(i);
				minMod = i;
			} else if (map.get(i) == freq) {
				minMod = Math.min(minMod, i);
			}
		}
		System.out.println(minMod);
	}
	
	private static double median(int [] array, int start, int end) {
        if ((end - start) % 2 == 0) { // odd
            return (array[(end + start) / 2]);
        } else { // even
            int value1 = array[(end + start) / 2];
            int value2 = array[(end + start) / 2 + 1];
            return (value1 + value2) / 2.0;
        }
    }
}