package com.company.goldman;

import java.util.Scanner;

public class GoldMan2 {
	public static boolean[] primes;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			int m = in.nextInt();
			arr[i] = m;
		}
		int k = in.nextInt();
		String r = getOutcomeOfTheFeat(arr, k);
		System.out.println(r);
		in.close();
	}

	private static String getOutcomeOfTheFeat(int[] weights, int marginOfError) {
		int sum = 0;
		for (int i = 0; i < weights.length; i++) {
			sum+=weights[i];
		}
		
		int rightSum = 0;
		int leftSum = sum+weights.length;
		
		int mindiff = Integer.MAX_VALUE;
		int diff = Math.abs(leftSum-rightSum);
		
		if((diff)<=marginOfError) {
			if(diff<mindiff) {
				mindiff = diff;
			}
		}

		for (int i = weights.length-1; i>=0 ; i--) {
			rightSum+=weights[i];
			leftSum -= (weights[i]+1);
			
			diff = Math.abs(leftSum-rightSum);
			if((diff)<=marginOfError) {
				if(diff<mindiff) {
					mindiff = diff;
				}
			}
		}
		
		if(mindiff==0) {
			return "Perfectly Balanced";
		}else if (mindiff<=marginOfError) {
			return "Balanced within "+mindiff;
		}else {
			return "Not Balanced";
		}
	}
}
