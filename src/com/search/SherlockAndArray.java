package com.search;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		Map<Integer, int[]> map = new HashMap<Integer, int[]>();
		for (int i = 0; i < t; i++) {
			int a = in.nextInt();
			int[] arr = new int[a];
			for (int j = 0; j < a; j++) {
				arr[j] = in.nextInt();
			}
			map.put(i, arr);
		}

		for (int i = 0; i < t; i++) {
			System.out.println(method(map.get(i)));
		}
		in.close();
	}

	private static String method(int[] arr) {
		int l = arr.length;

		long sum = 0;
		for (int i = 0; i < l; i++) {
			sum += arr[i];
		}

		long sum1 = 0;
		for (int i = 0; i < l; i++) {
			sum -= arr[i];
			if (sum1 == sum) {
				return "YES";
			}
			sum1 += arr[i];
		}
		return "NO";
	}
}