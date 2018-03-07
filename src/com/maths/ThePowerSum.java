package com.maths;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/the-power-sum/problem

public class ThePowerSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		System.out.println(findPowerSum(a, b));
		in.close();
	}

	public static int findPowerSum(int a, int b) {
		List<Integer> nos = getPowerList(a, b);
		return findSumCombinations(nos, 0, 0, a);
	}

	public static int findSumCombinations(List<Integer> nos, int index, int sumTillNow, int sum) {
		int count = 0;
		if (sumTillNow > sum || index == nos.size()) {
			return 0;
		}
		int current = nos.get(index);
		if ((sumTillNow + current) == sum) {
			++count;
		}else {
			count += findSumCombinations(nos, index + 1, sumTillNow + current, sum);
			count += findSumCombinations(nos, index + 1, sumTillNow, sum);
		}
		return count;
	}

	public static List<Integer> getPowerList(int a, int b) {
		List<Integer> nos = new ArrayList<Integer>();
		for (int i = 1; Math.pow(i, b) <= a; i++) {
			nos.add((int) Math.pow(i, b));
		}
		return nos;
	}
}