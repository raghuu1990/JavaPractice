package com.disjoint;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/kundu-and-tree/problem

public class KunduAndTree {
	public static int mod = 1000000007;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		RedBlackTreeSet set = new RedBlackTreeSet(n+1);
		int outPutCounter = 0;
		for (int i = 0; i < n; i++) {
			int A = in.nextInt();
			int B = in.nextInt();
			String C = in.next();
			//set.makePair(A, B, C);
		}

		//System.out.println(set.getRedNodes()%mod);
		in.close();
	}
}

class RedBlackTreeSet {
	int n;
	int [] size;
	int [] parent;
	
	public RedBlackTreeSet(int n) {
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
	
	public void makePair(int x, int y){
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