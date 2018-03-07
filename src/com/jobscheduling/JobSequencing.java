package com.jobscheduling;

import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing {

	public static void main(String[] args) {
		ArrayList<Job> jobs = new ArrayList<Job>();
		jobs.add(new Job("a", 2, 100));
		jobs.add(new Job("b", 1, 19));
		jobs.add(new Job("c", 2, 27));
		jobs.add(new Job("d", 1, 25));
		jobs.add(new Job("e", 3, 15));
		
		/*
		jobs.add(new Job("e", 5, 15));
		jobs.add(new Job("f", 4, 15));
		*/
		jobSequencing(jobs);
	}

	public static void jobSequencing(ArrayList<Job> jobs) {
		// Collections.sort(jobs, new Job());
		Collections.sort(jobs);
		Collections.reverse(jobs);
		int l = jobs.size();
		int[] slots = new int[l];
		boolean isUsed[] = new boolean[l];

		for (int i = 0; i < l; i++) {
			isUsed[i] = false;
		}

		for (int i = 0; i < l; i++) {
			for (int j = Math.min(l, jobs.get(i).deadline) - 1; j >= 0; j--) {
				if (isUsed[j] == false) {
					slots[j] = i;
					isUsed[j] = true;
					break;
				}
			}
		}

		for (int i = 0; i < l; i++) {
			if (isUsed[i]) {
				System.out.print(jobs.get(slots[i]).name + " ");
			}
		}
	}
}