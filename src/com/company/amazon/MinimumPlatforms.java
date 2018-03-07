package com.company.amazon;

import java.util.*;

class Time {
	int start;
	int end;
	int size;

	public Time(int start, int end, int size) {
		this.start = start;
		this.end = end;
		this.size = size;
	}

}

// http://practice.geeksforgeeks.org/problems/minimum-platforms/0
public class MinimumPlatforms {
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int[] result = new int[T];
		for (int i = 0; i < T; i++) {
			int N = in.nextInt();
			Time[] trains = new Time[N];
			for (int j = 0; j < N; j++) {
				Time train = new Time(0, 0, 0);
				trains[j] = train;
				trains[j].start = in.nextInt();
			}
			for (int j = 0; j < N; j++) {
				trains[j].end = in.nextInt();
			}
			result[i] = getMaxNumber(trains);
		}

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		in.close();
	}

	public static int getMaxNumber(Time[] trains) {
		int max_time = 24 * 60;
		
		Time[] time = new Time[max_time];

		for (int i = 0; i < max_time; i++) {
			time[i] = new Time(i, i + 1, 0);
		}

		int max = 1;
		for (int i = 0; i < trains.length; i++) {
			int start = (trains[i].start / 100) * 24 + (trains[i].start % 100);
			int end = (trains[i].end / 100) * 24 + (trains[i].end % 100);
			for (int j = start; j < end - 1; j++) {
				time[j].size++;
				if (time[j].size > max) {
					max = time[j].size;
				}
			}
		}
		return max;
	}

	public static int getMaxNumber2(Time[] trains) {
		int arr[] = new int[trains.length];
		int dep[] = new int[trains.length];

		for (int i = 0; i < trains.length; i++) {
			arr[i] = trains[i].start;
			dep[i] = trains[i].end;
		}
		Arrays.sort(arr);
		Arrays.sort(dep);
		int platforms = 1;
		int result = 1;
		int j = 0;
		for (int i = 1; i < trains.length && j < trains.length;) {
			if (arr[i] < dep[j]) {
				platforms++;
				i++;
				if (result < platforms) {
					result = platforms;
				}
			} else {
				platforms--;
				j++;
			}
		}
		return result;
	}
}