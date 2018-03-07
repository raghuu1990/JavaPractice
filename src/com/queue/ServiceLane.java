package com.queue;

import java.util.PriorityQueue;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/service-lane?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

public class ServiceLane {
	private static int MAX_WIDTH;
	private static PriorityQueue<Integer> minQueue;;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int T = in.nextInt();
		int[] width = new int[N];
		int[][] entryExit = new int[T][2];
		int[] result = new int[T];
		for (int i = 0; i < N; i++) {
			width[i] = in.nextInt();
		}
		
		for (int i = 0; i < T; i++) {
			entryExit[i][0] = in.nextInt();
			entryExit[i][1] = in.nextInt();
		}
		
		result = solve(width, entryExit);
		for (int i = 0; i < T; i++) {
			System.out.println(result[i]);
		}
		in.close();
	}

	private static int[] solve(int[] width, int[][] entryExit) {
		int[] result = new int[entryExit.length];
		for (int i = 0; i < entryExit.length; i++) {
			int start = entryExit[i][0];
			int end = entryExit[i][1];
			minQueue = new PriorityQueue<Integer>();
			for (int j = start; j <= end; j++) {
				minQueue.add(width[j]);
			}
			int r = minQueue.poll();
			if(r>MAX_WIDTH) {
				r=3;
			}
			result[i] = r;
		}
		return result;
	}
}