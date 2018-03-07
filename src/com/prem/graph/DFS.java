package com.prem.graph;

import java.util.List;

/**
 * @author lovebharti
 * Graph is traversed using graph.DFS using stack
 * Here recursion helping in stack behavior.
 *
 * Get first node print it, set it visited.
 * 		get first node's vertices one by one
 * 			and send each node to recursive traverse.
 *
 * 	before sending to traverse check if it's visited
 * 	if it's visited then it's cyclic graph
 */
public class DFS<T> {
	
	public void traverse(GNode<T> start){
		if(start!=null){
			//visit the node and mark it visited.
			System.out.println(start.getData());
			start.setVisited(true);

			//get node's adjacent vertices and traverse one by one
			List<GNode<T>> vertices= start.getVertices();
			if(vertices!=null && vertices.size()>0){
				for(GNode<T> node:vertices){
					//keep going in depth until all node is not visited.
					if(!node.isVisited()){
						traverse(node);
					}
					else{
						System.out.println("Graph is having cycle @ tree.Node:"+node.getData());
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		DFS<Integer> dfs= new DFS<Integer>();
		GNode<Integer> graph= new GNode<Integer>();
		GNode<Integer> startNode=graph.getIntegerGraph();
		dfs.traverse(startNode);
	}
}