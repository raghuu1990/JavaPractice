package com.graph;

public class CycleDG {
	/*
	 * 		 1 -- 2 -- 3
	 * 		/	   \ 	\
	 * 	   0 -- 7 	8 -- 4
	 * 	   \ 	    | 	 / 
	 * 		5 ____ 	6 __/
	 */
	public static void main(String args[]) {
		/*DirectedGraph g = new DirectedGraph(9);
		g.addEdge(0, 1);
		g.addEdge(0, 5);
		g.addEdge(0, 7);
		g.addEdge(1, 2);
		g.addEdge(5, 6);
		g.addEdge(2, 8);
		g.addEdge(6, 8);
		g.addEdge(2, 3);
		g.addEdge(4, 3);
		g.addEdge(4, 6);
		g.addEdge(4, 8);*/
		
		DirectedGraph g = new DirectedGraph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		if (g.isCyclicDG1()) {
			System.out.println("graph contains cycle");
		} else {
			System.out.println("graph doesn't contain cycle");
		}
		
		if (g.isCyclicDGColor()) {
			System.out.println("graph contains cycle");
		} else {
			System.out.println("graph doesn't contain cycle");
		}
	}
}