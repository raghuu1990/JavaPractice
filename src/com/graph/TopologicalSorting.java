package com.graph;

public class TopologicalSorting {
	/*
	 * 		 5     4
	 * 		/ \	  / \ 
	 * 	   *   * *   *
	 * 	   2    0    3 
	 * 	    \ 	    / 
	 * 		 \     /
	 *        *   *
	 * 		   	1
	 */
	
	// for DAG
	public static void main(String args[]) {
		DirectedGraph g = new DirectedGraph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        
        System.out.println("Topological sort of the given graph");
        g.topologicalSort();
        System.out.println();
        System.out.println("Topological sort using kahns");
        g.kahnsTopologicalSort();
        System.out.println();
        System.out.println("Topological sort print all");
        g.kahnsTopologicalSortAll();
	}
}