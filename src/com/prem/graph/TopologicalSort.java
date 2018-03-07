package com.prem.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Topological sort:
 *    sort in a way that least dependent will come first and most dependent in the last.
 *
 *    It uses DFS algorithm - Stack way
 */
public class TopologicalSort<T> {


  public List<Vertex<T>> topSort(Graph<T> graph){
    List<Vertex<T>> allVertices= new ArrayList<>(graph.getVertexList().values());
    List<Vertex<T>> visited= new ArrayList<>();

    List<Vertex<T>> result= new ArrayList<>();

    for(Vertex vertex: allVertices){
      if(!visited.contains(vertex)){
        dfsForTopSort(visited,result,vertex);
      }
    }
    return result;
  }
  public void dfsForTopSort(List<Vertex<T>> visited, List<Vertex<T>> result, Vertex<T> vertex){
    visited.add(vertex);
    for(Vertex v:vertex.getAdjacencyList()){
      if(!visited.contains(v)){
        dfsForTopSort(visited,result,v);
      }
    }
    result.add(vertex);
  }

  public static void main(String[] args) {

    Graph<Integer> graph = new Graph<>(true);
    graph.addEdge(1, 3);
    graph.addEdge(1, 2);
    graph.addEdge(3, 4);
    graph.addEdge(5, 6);
    graph.addEdge(6, 3);
    graph.addEdge(3, 8);
    graph.addEdge(8, 11);
    TopologicalSort topologicalSort= new TopologicalSort();
    List<Vertex<Integer>> result=topologicalSort.topSort(graph);
    for(int i=result.size()-1;i>=0;i--){
      System.out.println(result.get(i).getId());
    }
  }
}
