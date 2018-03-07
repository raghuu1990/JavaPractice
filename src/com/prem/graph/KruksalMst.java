package com.prem.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.prem.disjointset.DisjointS;
import com.prem.disjointset.DsNode;

/**
 * Kruskal algorithm is used to find out the minimum spanning tree
 *
 * Disjoint set data structure can be used easily for this algorithm
 *
 * 1. Sort all edges as per cost
 * 2. use makeSet of disjoint set and feed each vertex from the graph.
 * 3. now start to take smaller edge one by one from the sorted edge list.
 *    take both vertices from edge and put it in single disjoint set
 *    by union
 *    if both vertices parents are same, no need of union coz they are in same
 *    in disjoint set.
 * 4. while doing union add edge in the result set.
 * 5. from output of edge result set connect each edge you'll find the minimum spanning tree.
 */
public class KruksalMst {

  public List<Edge> getMST(Graph graph){
    List<Edge> edges= new ArrayList(graph.getEdges());
    List<Vertex> vertices=new ArrayList(graph.getVertexList().values());
    List<Edge> resultList= new ArrayList<Edge>();
    //sort all edge as per their weight
    Collections.sort(edges,new EdgeComparator());

    DisjointS disjointSet= new DisjointS();

    //make seperate set for all vertices
    for(Vertex vertex:vertices){
      disjointSet.makeSet(vertex.getId());
    }

    //for each edge from smallest weight
    //put both vertices of edge in a single set of disjoint
    for(Edge edge:edges){
      DsNode root1= disjointSet.findSet(edge.getFrom().getId());
      DsNode root2= disjointSet.findSet(edge.getTo().getId());
      //if both vertices parent are same then already have in disjoint
      //whose weight is smaller
      if(root1==root2) continue;
      else{
          disjointSet.union(root1.getData(),root2.getData());
          resultList.add(edge);
      }
    }
    return resultList;
  }

  public static void main(String[] args) {
    Graph<Integer> graph = new Graph<>(false);
    graph.addEdge(1, 2, 4);
    graph.addEdge(1, 3, 1);
    graph.addEdge(2, 5, 1);
    graph.addEdge(2, 6, 3);
    graph.addEdge(2, 4, 2);
    graph.addEdge(6, 5, 2);
    graph.addEdge(6, 4, 3);
    graph.addEdge(4, 7, 2);
    graph.addEdge(3, 4, 5);
    graph.addEdge(3, 7, 8);

    KruksalMst kmst= new KruksalMst();
    List<Edge> edges=kmst.getMST(graph);
    for(Edge edge:edges){
      System.out.println(edge.getFrom().getId()+","+edge.getTo().getId());
    }
  }
}
