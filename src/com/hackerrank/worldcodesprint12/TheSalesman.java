package com.hackerrank.worldcodesprint12;

import java.util.PriorityQueue;
import java.util.Scanner;

// https://www.hackerrank.com/contests/world-codesprint-12/challenges/the-salesman

public class TheSalesman {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            int[] x = new int[n];
            for(int j = 0; j < n; j++){
                x[j] = in.nextInt();
            }
            int result = minimumTime(x);
            System.out.println(result);
        }
        in.close();
    }
    
    public static int minimumTime(int[] x) {
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    	for (int i = 0; i < x.length; i++) {
    		pq.add(x[i]);
		}
    	
    	int sum = 0;
    	int a = pq.poll();
    	while(!pq.isEmpty()) {
    		int b = pq.poll();
    		sum+=Math.abs(a-b);
    		a = b;
    	}
		return sum;
    }
}