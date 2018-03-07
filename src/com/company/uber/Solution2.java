package com.company.uber;

import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[k];
		for (int i = 0; i < k; i++) {
			arr[i] = in.nextInt();
		}
		long result = getMinTimeRequired(n, arr);
		System.out.println(result);
		in.close();
	}

	public static long getMinTimeRequired(int n, int jobs[]) {
		long job_min = 0;
		long job_max = 0;
		for (int i = 0; i < jobs.length; i++) {
			job_min = Math.min(job_min, jobs[i]);
			job_max = Math.max(job_max, jobs[i]);
		}

		job_max = n * job_max;
		long result = job_max;

		while (job_min <= job_max) {
			long mid = (job_min + job_max) / 2;
			if (isPossibleInThisTime(mid, n, jobs)) {
				result = Math.min(result, mid);
				job_max = mid - 1;
			} else {
				job_min = mid + 1;
			}
		}
		return result;
	}

	public static boolean isPossibleInThisTime(long timeToFinishJobs, long n, int jobs[]) {
		long noOfA = 0;

		for (int i = 0; i < jobs.length; i++) {
			if (jobs[i] <= timeToFinishJobs) {
				noOfA += timeToFinishJobs / jobs[i];
			}
		}

		if (noOfA >= n) {
			return true;
		}
		return false;
	}
}