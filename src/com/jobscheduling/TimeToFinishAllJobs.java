package com.jobscheduling;

import java.util.Scanner;

// http://www.geeksforgeeks.org/find-minimum-time-to-finish-all-jobs-with-given-constraints/

public class TimeToFinishAllJobs {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int T = in.nextInt();
		int J = in.nextInt();
		int[] jobs = new int[J];
		for (int i = 0; i < jobs.length; i++) {
			jobs[i] = in.nextInt();
		}
		System.out.println(getMinTimeRequired(A, T, jobs));
		in.close();
	}

	public static int getMinTimeRequired(int A, int T, int jobs[]) {
		int job_min = 0;
		int job_max = 0;
		int longestJob = Integer.MIN_VALUE;
		for (int i = 0; i < jobs.length; i++) {
			job_max += jobs[i];
			longestJob = Math.max(longestJob, jobs[i]);
		}

		int result = job_max;
		// Binary Search
		while (job_min <= job_max) {
			int mid = (job_min + job_max) / 2;
			if (isPossibleInThisTime(mid, A, jobs) && mid >= longestJob) {
				result = Math.min(result, mid);
				job_max = mid - 1;
			} else {
				job_min = mid + 1;
			}
		}
		return (result * T);
	}

	public static boolean isPossibleInThisTime(int timeToFinishJobs, int A, int jobs[]) {
		int noOfA = 1;
		int currAssigneeTime = 0;

		for (int i = 0; i < jobs.length;) {
			if (currAssigneeTime + jobs[i] > timeToFinishJobs) {
				currAssigneeTime = 0;
				noOfA++;
			} else {
				currAssigneeTime += jobs[i];
				i++;
			}
		}

		if (noOfA <= A) {
			return true;
		}
		return false;
	}
}