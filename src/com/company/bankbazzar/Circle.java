package com.company.bankbazzar;

import java.util.Scanner;

public class Circle {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int d = in.nextInt();
		in.nextLine();
		int [] r = new int [n];
		int [] c = new int [n];
		for(int i=0; i<n ;i++){
			r[i] = in.nextInt();
		}
		for(int i=0; i<n ;i++){
			c[i] = in.nextInt();
		}
		count(n,d,r,c);
		in.close();
	}


	private static void count(int n, int d, int[] r, int[] c) {
		int ans[] =  new int [n];
		
		for (int i = 0; i < n; i++) {
			int minCost = 0;
			int radius = 0;
			int k = 0;
			boolean isMatched = false;
			for (int j = 0; j < n; j++) {
				if(r[j]+r[i]>=d){
					if(!isMatched){
						minCost = c[j];
						radius = r[j];
						k = j;
						isMatched = true;
					}else{
						if(c[j]<=minCost){
							if(c[j]<minCost){
								minCost = c[j];
								k=j;
								radius = r[j];
							}else if(c[j]==minCost && r[j] > radius){
								minCost = c[j];
								k=j;
								radius = r[j];
							}
						}
					}
				}
			}
			if(isMatched){
				ans[i] = k+1;
			}else{
				ans[i] = 0;
			}
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(ans[i]);
			System.out.print(" ");
		}
	}

}
