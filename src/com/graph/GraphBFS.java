package com.graph;

public class GraphBFS {

	/*
	 * 		 1----2---3
	 * 		/	   \   \
	 * 	   0---7 	8---4   9---10
	 * 	    \ 	    |  / 
	 * 		 \      | /
	 *        5-----6 
	 */
	
	public static void main(String args[]) {
		UndirectedGraph g = new UndirectedGraph(11);
		g.addEdge(0, 1);
		g.addEdge(0, 5);
		g.addEdge(0, 7);
		g.addEdge(1, 2);
		g.addEdge(2, 8);
		g.addEdge(6, 8);
		g.addEdge(2, 3);
		g.addEdge(4, 3);
		g.addEdge(4, 6);
		g.addEdge(4, 8);
		g.addEdge(9, 10);

		// For non connected graphs
		g.BFS();
		
		System.out.println();
		
		// For connected graphs
		g.BFS(0);
	}
}