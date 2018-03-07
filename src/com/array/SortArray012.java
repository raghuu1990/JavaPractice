package com.array;

import java.util.Scanner;

public class SortArray012 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int [][] result = new int[t][];
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int[] c = new int[n];
			for (int j = 0; j < n; j++) {
				c[j] = in.nextInt();
			}
			result[i] = getSubArray(c);
		}
		for (int i = 0; i < t; i++) {
	    	for (int j = 0; j < result[i].length; j++) {
			    System.out.print(result[i][j] + " ");
		    }
		    System.out.println();
		}
		in.close();
	}

    private static int[] getSubArray(int[] arr) {
        int c_0 = 0;
        int c_1 = 0;
        int c_2 = 0;
        for (int i = 0; i < arr.length; i++) {
		    if(arr[i]==0){
		        c_0++;    
		    }
		    if(arr[i]==1){
		        c_1++;    
		    }
		    if(arr[i]==2){
		        c_2++;    
		    }
		}
		
		int c = 0;
		while(c_0>0){
		    arr[c]=0;
		    c_0--;
		    c++;
		}
		while(c_1>0){
		    arr[c]=1;
		    c_1--;
		    c++;
		}
		while(c_2>0){
		    arr[c]=2;
		    c_2--;
		    c++;
		}
		return arr;
    }
}