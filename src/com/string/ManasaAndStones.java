package com.string;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// https://www.hackerrank.com/challenges/manasa-and-stones
	
public class ManasaAndStones {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		String[] result = new String[t];
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			result[i] = transformation(n, a, b);
		}
		for (int i = 0; i < t; i++) {
			System.out.println(result[i]);
		}
		in.close();
	}

	private static String transformation(int n, int a, int b) {
		Set<Integer> result = new TreeSet<Integer>();
		shortestTransformation(n-1, a, b, 0, result);
		String resultString = new String();
		for(Integer r : result) {
			resultString +=r;
			resultString+=" ";
		}
		return resultString;
	}
	
	private static Set<Integer> shortestTransformation(int n, int a, int b, int sum, Set<Integer> result) {
		for(int i = 0; i<=n; i++) {
			for(int j = 0; j<=n; j++) {
				if((i+j)==n) {
					result.add((a*i)+(b*j));
				}
			}
		}
		return result;
	}
	
	private static Set<Integer> shortestTransformation1(int n, int a, int b, int sum, Set<Integer> result) {
		if(n==0) {
			result.add(sum);
			return result;
		}
		shortestTransformation(n-1, a, b, sum+a, result);
		shortestTransformation(n-1, a, b, sum+b, result);
		return result;
	}
}