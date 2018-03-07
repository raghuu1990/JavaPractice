package com.graph;

public class CycleUDG {
	public static void main(String args[]) {
		UndirectedGraph g1 = new UndirectedGraph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 0);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		if (g1.isCyclicUDG1())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");

		UndirectedGraph g2 = new UndirectedGraph(3);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		if (g2.isCyclicUDG1())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");
		
		
	 /*
       0.
       | \
       |  \
       1---2
     */
       int V = 3, E = 3;
       DisJointGraph graph = new DisJointGraph(V, E);

       // add edge 0-1
       graph.edge[0].src = 0;
       graph.edge[0].dest = 1;
      /* graph.edge[0].src = 1;
       graph.edge[0].dest = 0;         does not make any change, if src and des are same then cyclic*/

       // add edge 1-2
       graph.edge[1].src = 1;
       graph.edge[1].dest = 2;

       // add edge 0-2
       graph.edge[2].src = 0;
       graph.edge[2].dest = 2;

       if (graph.isCycle()) {
           System.out.println( "graph contains cycle" );
       }else {
           System.out.println( "graph doesn't contain cycle" );
       }
       
       if (graph.isCycleUsingRank()) {
           System.out.println( "graph contains cycle" );
       }else {
           System.out.println( "graph doesn't contain cycle" );
       }
	}
}