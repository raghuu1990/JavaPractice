package com.designpattern.visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Visitor {
	public static Tree solve() {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		int [] value = new int[t];
		Color [] color = new Color[t];
		DisJointSet set = new DisJointSet(t);

		for (int i = 0; i < t; i++) {
			value[i] = in.nextInt();
		}
		
		for (int i = 0; i < t; i++) {
			int c = in.nextInt();
			if(c==0) {
				color[i] = Color.RED;
			}else if(c==1) {
				color[i] = Color.GREEN;
			}
		}

		for (int i = 0; i < t-1; i++) {
			int u = in.nextInt();
			int v = in.nextInt();
			set.union(u-1, v-1);
		}
		in.close();

		List<Tree> treeNodes = new ArrayList<Tree>();
		for (int i = 0; i < t; i++) {
			if(set.isLeaf[i]) {
				treeNodes.add(new TreeLeaf(value[i], color[i], set.findDepth(i)));
			}else {
				treeNodes.add(new TreeNode(value[i], color[i], set.findDepth(i)));
			}
		}
		
		int rootIndex;
		for (rootIndex = 0; rootIndex < t; rootIndex++) {
			if(set.isRoot(rootIndex)) {
				break;
			}
		}
		
		linkNodes(treeNodes, set, rootIndex);
		return treeNodes.get(rootIndex);
	}

	private static void linkNodes(List<Tree> treeNodes, DisJointSet set, int index) {
		HashSet<Integer> childs = set.childMap.get(index);
		if(childs!=null && childs.size()>0) {
			for (int child : childs) {
				linkNodes(treeNodes, set, child);
				((TreeNode) treeNodes.get(index)).addChild(treeNodes.get(child));
			}
		}
	}

	public static void main(String[] args) {
		Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
		ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
		FancyVisitor vis3 = new FancyVisitor();

		root.accept(vis1);
		root.accept(vis2);
		root.accept(vis3);

		int res1 = vis1.getResult();
		int res2 = vis2.getResult();
		int res3 = vis3.getResult();

		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
	}
}

class DisJointSet{
	int [] parent;
	boolean isLeaf[];
	HashMap<Integer, HashSet<Integer>> childMap;
	
	public DisJointSet(int n) {
		parent = new int[n];
		isLeaf = new boolean[n];
		childMap = new HashMap<Integer, HashSet<Integer>>();
		for(int i = 0; i < n; i++) {
			parent[i] = i;
			isLeaf[i] = true;
		}
	}
	
	public void union(int u, int v) {
		parent[v] = u;
		isLeaf[u] = false;
		if(childMap.containsKey(u)) {
			HashSet<Integer> childs = childMap.get(u);
			childs.add(v);
			childMap.put(u, childs);
		}else {
			HashSet<Integer> childs = new HashSet<Integer>();
			childs.add(v);
			childMap.put(u, childs);
		}
	}
	
	public int findParent(int i) {
		if(parent[i]==i) {
			return i;
		}
		return parent[i];
	}
	
	public int findDepth(int i) {
		int depth = 0;
		while(parent[i]!=i) {
			i = parent[i];
			depth++;
		}
		return depth;
	}
	
	public boolean isRoot(int i) {
		if(parent[i]==i) {
			return true;
		}
		return false;
	}
}