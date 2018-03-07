package com.disjoint;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/merging-communities/problem

public class MergingCommunities {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int c = in.nextInt();
		CommunitieSet set = new CommunitieSet(n+1);
		int outPut[] = new int[c];
		int outPutCounter = 0;
		for (int i = 0; i < c; i++) {
			String operation = in.next();
			if (operation.equalsIgnoreCase("M")) {
				int A = in.nextInt();
				int B = in.nextInt();
				set.mergeCommunitie(A, B);
			} else if (operation.equalsIgnoreCase("Q")) {
				int C = in.nextInt();
				outPut[outPutCounter] = set.getRank(C);
				outPutCounter++;
			}
		}

		for (int i = 0; i < outPutCounter; i++) {
			System.out.println(outPut[i]);
		}
		in.close();
	}
}

class CommunitieSet {
	int n;
	int [] size;
	int [] parent;
	
	public CommunitieSet(int n) {
		this.n = n;
		size = new int [this.n];
		parent = new int [this.n];
		for (int i = 0; i < this.n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
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
	
	public void mergeCommunitie(int x, int y){
		int px = getParent(x);
		int py = getParent(y);
		
		if(px==py) {
			return;
		}

		if(size[px]>size[py]) {
			parent[py] = px;
			size[px]+=size[py];
		}else if(size[py]>size[px]) {
			parent[px] = py;
			size[py]+=size[px];
		}else {
			parent[py] = px;
			size[px]+=size[py];
		}
	}
}