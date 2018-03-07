package com.basics;

import java.text.DecimalFormat;
import java.util.Scanner;

public class PlusMinusPrecision {

	public static String Precision(double num, int n, int precision){
		DecimalFormat myFormatter = new DecimalFormat("0.000");
		if(num==0){
			return myFormatter.format(0);
		}
		return myFormatter.format(num/n);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n  = in.nextInt();
		int positive = 0;
		int negative = 0;
		int zero = 0;
		for (int i=0;i<n;i++) {
			int a = in.nextInt();
			if(a>0){
				positive++;
			}else if(a<0){
				negative++;
			}else {
				zero++;
			}
		}
		System.out.println(Precision(positive, n, 3));
		System.out.println(Precision(negative, n, 3));
		System.out.println(Precision(zero, n, 3));
	}
}
