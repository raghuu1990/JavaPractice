package com.graph;

public class DisJointSet {
	int n;
	int [] rank;
	int [] parent;
	
	public DisJointSet(int n) {
		this.n = n;
		rank = new int [n];
		parent = new int [n];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}
	
	public int find(int x){
		if(parent[x]!=x) {
			return find(parent[x]);
		}
		return x;
	}
	
	public void union(int x, int y){
		int px = find(x);
		int py = find(y);

		if(px==py) {
			return;
		}

		if(rank[px]>rank[py]) {
			parent[py] = px;
		}else if(rank[py]>rank[px]) {
			parent[px] = py;
		}else {
			parent[py] = px;
			rank[px]++;
		}
	}
}