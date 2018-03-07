package com.disjoint;

public class DisJointSet {
	int n;
	int [] rank;
	int [] parent;
	
	public DisJointSet(int n) {
		this.n = n;
		rank = new int [this.n];
		parent = new int [this.n];
		for (int i = 0; i < this.n; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}
	
	public int find(int x){
		if(parent[x]!=x) {
			return find(parent[x]);
		}
		return x;
	}
	
	public int rank(int x){
		int px = find(x);
		return rank[px];
	}
	
	public void union(int x, int y){
		int px = find(x);
		int py = find(y);
		
		if(px==py) {
			return;
		}

		if(rank[px]>rank[py]) {
			parent[py] = px;
			rank[px]+=rank[py];
		}else if(rank[py]>rank[px]) {
			parent[px] = py;
			rank[py]+=rank[px];
		}else {
			parent[py] = px;
			rank[px]+=rank[py];
		}
	}
}