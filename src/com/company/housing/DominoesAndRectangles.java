package com.company.housing;

import java.util.Scanner;

public class DominoesAndRectangles {

	 // A{n}=3A{n-1}+3A{n-2}-A{n-3}   n>4, A{0} = 1, A{1} = 2, A{2} = 9
			 
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int t  = in.nextInt();
		int a[] = new int[t];
		int max = 0;
		for (int i=0;i<t;i++) {
			 int n = in.nextInt();
			 a[i] = n;
			 if(n>max){
				 max=n;
			 }
		}

		long c = 4;
		int mod = 1000000007;
		int dp[] = new int[1000000];
		
		dp[0] = 1; dp[1] = 2; dp[2] = 9; dp[3] = 32;
		for(int i = 4; i <= max; i++) {
			c =  ((c + dp[i-3] * 4)%mod); 
			dp[i] = (int) ((dp[i-1] * 2 + dp[i-2] * 5 + c)%mod); 
		}

		for (int i=0;i<t;i++) {
			System.out.println(dp[a[i]]);
		}
	}
}

