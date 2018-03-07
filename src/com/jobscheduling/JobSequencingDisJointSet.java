package com.jobscheduling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// http://www.geeksforgeeks.org/job-sequencing-problem-set-1-greedy-algorithm/
// http://www.geeksforgeeks.org/job-sequencing-using-disjoint-set-union/

public class JobSequencingDisJointSet {
	public static void main(String args[]) {
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
		jobSequencingGreedy(jobs);  // 
		System.out.println();
		jobSequencingUsingDisJoint(jobs);
	}

	public static int findMaxDeadline(ArrayList<Job> arr) {
		int ans = Integer.MIN_VALUE;
		for (Job temp : arr) {
			ans = Math.max(temp.deadline, ans);
		}
		return ans;
	}

	public static void jobSequencingGreedy(ArrayList<Job> jobs) {
		Collections.sort(jobs, new Job());
		//Collections.sort(jobs);
		//Collections.reverse(jobs);
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
	public static void jobSequencingUsingDisJoint(ArrayList<Job> jobs) {
		Collections.sort(jobs, new Job());

		int maxDeadline = findMaxDeadline(jobs);
		DisjointSet disJointSet = new DisjointSet(maxDeadline);

		for (Job job : jobs) {
			// Find the maximum available free slot for this job (corresponding to its deadline)
			int availableSlot = disJointSet.find(job.deadline);

			// If maximum available free slot is greater than 0, then free slot available
			if (availableSlot > 0) {
				// This slot is taken by this job 'i' so we need to update the greatest free
				// slot. Note that, in merge, we make first parameter as parent of second parameter. 
				// So future queries for availableSlot will return maximum slot from set of "availableSlot - 1"
				disJointSet.union(disJointSet.find(availableSlot - 1), availableSlot);
				System.out.print(job.name + " ");
			}
		}
		System.out.println();
	}
}

class Job implements Comparable<Job>, Comparator<Job>{
	String name;
	int deadline;
	int profit;

	public Job() {
	}

	public Job(String name, int deadline, int profit) {
		this.name = name;
		this.deadline = deadline;
		this.profit = profit;
	}

	@Override
	public int compare(Job job1, Job job2) {
		if (job1.profit > job2.profit) {
			return -1;
		} 
		return 1;
	}
	
	@Override
	public int compareTo(Job job) {
		if (this.profit > job.profit) {
			return 1;
		}
		return -1;
	}
}

class DisjointSet {
	int parent[];

	DisjointSet(int n) {
		parent = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
	}

	int find(int s) {
		if (s == parent[s]) {
			return s;
		}
		return parent[s] = find(parent[s]);
	}

	void union(int u, int v) {
		parent[v] = u;
	}
}