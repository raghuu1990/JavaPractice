package com.maths;

import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/s10-spearman-rank-correlation-coefficient/problem

public class SpearmansRankCorrelationCoefficient {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		double[] X = new double[n];
		double[] Y = new double[n];
		for (int i = 0; i < n; i++) {
			X[i] = in.nextDouble();
		}

		for (int i = 0; i < n; i++) {
			Y[i] = in.nextDouble();
		}

		double result = spearmansRankCorrelationCoefficient(X, Y);
		System.out.println(Math.round(result * 1000) / 1000.0);
		in.close();
	}

	private static double spearmansRankCorrelationCoefficient(double[] x, double[] y) {
		int[] rank1 = getRanks(x);
		int[] rank2 = getRanks(y);
		
		double result= 0;
		for (int i = 0; i < rank2.length; i++) {
			result+=(rank2[i]-rank1[i])*(rank2[i]-rank1[i]);
		}
		result/=x.length;
		result/=(x.length*x.length)-1;
		result*=6;
		return 1-result;
	}
	
	public static int[] getRanks(double [] x) {
		Pair1[] list = new Pair1[x.length];
		for (int i = 0; i < x.length; i++) {
			list[i] = new Pair1(x[i], i);
		}
		
		Arrays.sort(list);
		
        int [] ranks = new int[x.length];
        int rank = 1;
        for (Pair1 p : list) {
            ranks[p.index] = rank++;
        }
        return ranks;
    }
}

class Pair1 implements Comparable<Pair1> {
	Double value;
	int index;

	public Pair1(Double value, int index) {
		this.value = value;
		this.index = index;
	}

	@Override
	public int compareTo(Pair1 o) {
		return this.value.compareTo(o.value);
	}
}