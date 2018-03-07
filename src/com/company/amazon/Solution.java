package com.company.amazon;

import java.util.Scanner;
public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner in =new Scanner(System.in);
        int n= in.nextInt();
        int m= in.nextInt();
        int a[] = new int[n];
        int sum = 0;
        for(int i=0;i<n;i++){
        	a[i] = in.nextInt();
            sum +=a[i];
        }
        if(sum<m){
            m=sum;
        }
        in.close();
        
        int index = 0;
        int result = 0;
        a= sort(a);
        for(int i=0;i<m;i++){
        	a = getMaxIndexOfArray(a);
            result += a[0];
        }
        System.out.println(result);
    }

    public static int[] sort(int[] input){     
        int temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(input[j] > input[j-1]){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
        return input;
    }
    
	private static int[] getMaxIndexOfArray(int[] a) {
		int max = 0;
		int index = 0;
		for(int i=0;i<a.length-1;i++){
        	if(a[i]>a[i+1]){
        		max= a[i];
        		index = i;
        	}
            else{
                int temp = a[i];
                a[i+1] = a[i];
                a[i]=  temp;
            }
        }
		return a;
	}
}