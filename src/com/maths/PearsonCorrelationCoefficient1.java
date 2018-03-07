package com.maths;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/s10-pearson-correlation-coefficient/problem

public class PearsonCorrelationCoefficient1 {

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

		double result = pearsonCorrelationCoefficient1(X, Y);
		System.out.println(Math.round(result*1000)/1000.0);
		in.close();
	}

	private static double pearsonCorrelationCoefficient1(double[] x, double[] y) {
		double sd1 = 0;
		double mean1 = mean(x);
		for (int i = 0; i < x.length; i++) {
			sd1 = (sd1 * i + ((x[i] - mean1) * (x[i] - mean1))) / (i + 1);
		}
		sd1 = Math.sqrt(sd1);

		double sd2 = 0;
		double mean2 = mean(y);
		for (int i = 0; i < y.length; i++) {
			sd2 = (sd2 * i + ((y[i] - mean2) * (y[i] - mean2))) / (i + 1);
		}
		sd2 = Math.sqrt(sd2);

		double p = 0;
		for (int i = 0; i < y.length; i++) {
			p += (x[i] - mean1) * (y[i] - mean2);
		}

		p /= sd1;
		p /= sd2;
		p /= x.length;

		return p;
	}

	public static double mean(double[] arr) {
		double mean = 0;
		for (int i = 0; i < arr.length; i++) {
			mean = (mean * i + arr[i]) / (i + 1);
		}
		return mean;
	}
}
