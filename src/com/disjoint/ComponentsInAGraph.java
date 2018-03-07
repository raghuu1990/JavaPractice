package com.disjoint;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/merging-communities/problem

public class ComponentsInAGraph {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ComponentSet set = new ComponentSet(2*n+1);
		for (int i = 0; i < n; i++) {
			int A = in.nextInt();
			int B = in.nextInt();
			set.merge(A, B);
		}

		System.out.print(set.getMin()+" "+set.getMax());
		in.close();
	}
}

class ComponentSet {
	int n;
	int [] size;
	int [] parent;
	
	public ComponentSet(int n) {
		this.n = n;
		size = new int [this.n];
		parent = new int [this.n];
		for (int i = 0; i < this.n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}
	
	public int getMax() {
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < ((parent.length/2)+1); i++) {
			int p = getParent(i);
			if(size[p]!=1) {
				max = Math.max(max, size[p]);
			}
		}
		return max;
	}

	public int getMin() {
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < ((parent.length/2)+1); i++) {
			int p = getParent(i);
			if(size[p]!=1) {
				min = Math.min(min, size[p]);
			}
		}
		return min;
	}

	public int getParent(int x){
		if(parent[x]!=x) {
			return getParent(parent[x]);
		}
		return x;
	}
	
	public int getRank(int x){
		int px = getParent(x);
		return size[px];
	}
	
	public void merge(int x, int y){
		int px = getParent(x);
		int py = getParent(y);
		
		if(px==py) {
			return;
		}

		parent[py] = px;
		size[px]+=size[py];
	}
}