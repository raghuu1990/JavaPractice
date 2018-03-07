package com.jobscheduling;

import java.util.ArrayList;
import java.util.Collections;

// https://www.geeksforgeeks.org/greedy-algorithms-set-1-activity-selection-problem/

public class ActivitySelection {

	static void printMaxActivities(ArrayList<Activitiy> arr, int n) {
		Collections.sort(arr);
		System.out.println("Following activities are selected n");

		int i = 0;
		System.out.println("(" + arr.get(i).start + ", " + arr.get(i).finish + "), ");

		for (int j = 1; j < n; j++) {
			if (arr.get(j).start >= arr.get(i).finish) {
				System.out.println("(" + arr.get(j).start + ", " + arr.get(j).finish + "), ");
				i = j;
			}
		}
	}

	// Driver program
	public static void main(String[] args) {
		ArrayList<Activitiy> arr = new ArrayList<Activitiy> ();
		arr.add(new Activitiy(5, 9));
		arr.add(new Activitiy(1, 2));
		arr.add(new Activitiy(3, 4));
		arr.add(new Activitiy(0, 6));
		arr.add(new Activitiy(5, 7));
		arr.add(new Activitiy(8, 9));
		int n = arr.size();
		printMaxActivities(arr, n);
	}
}

class Activitiy implements Comparable<Activitiy>{
	Integer start;
	Integer finish;

	public Activitiy(Integer start, Integer finish) {
		this.start = start;
		this.finish = finish;
	}

	@Override
	public int compareTo(Activitiy act) {
		return this.finish.compareTo(act.finish);
	}
};