package com.prem.graph;

import java.util.HashMap;
import java.util.Map;

import com.interview.graph.BinaryMinHeap;

/**
 *
 * From single source node finds shortest paths
 *      to all other nodes in the graph, producing a shortest-path tree.
 *
 *  # graph should be -> directed or undirected but having non-negative weight
 *  # Implementation using min priority queue :: O(|E|+|V|log|V|)
 *  This shortest path algorithm is widely used in network routing protocols
 */
public class Dijkstra<T> {

  public Map<Vertex<T>,Integer> shortPath(Graph<T> graph, Vertex<T> source){
    BinaryMinHeap<Vertex<T>> minHeap = new BinaryMinHeap<>();
    Map<Vertex<T>, Integer> distance = new HashMap<>();
    Map<Vertex<T>, Vertex<T>> parents = new HashMap<>();

    for(Vertex v:graph.getVertexList().values()){
      minHeap.add(Integer.MAX_VALUE,v);
    }

    minHeap.decrease(source,0);
    distance.put(source,0);
    parents.put(source, null);

    while(!minHeap.empty()){
      BinaryMinHeap<Vertex<T>>.Node currentMin=minHeap.extractMinNode();
      Vertex<T> current=currentMin.getKey();
      distance.put(current, currentMin.getWeight());
      for(Edge<T> edge:current.getEdges()){
        Vertex<T> adjacent= getAdjacent(edge, current);

        if(!minHeap.containsData(adjacent)){
          continue;
        }

        int newDistance= currentMin.getWeight()+edge.getCost();
        if (newDistance < minHeap.getWeight(adjacent)) {
          minHeap.decrease(adjacent,newDistance);
          parents.put(adjacent, current);
        }
      }
    }
      return distance;
  }

  public Vertex<T> getAdjacent(Edge<T> edge, Vertex<T> current){
     return edge.getFrom().getId()==current.getId()? edge.getTo():edge.getFrom();
  }

  public static void main(String args[]){
    Graph<Integer> graph = new Graph<>(false);
        /*graph.addEdge(0, 1, 4);
        graph.addEdge(1, 2, 8);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 9);
        graph.addEdge(4, 5, 10);
        graph.addEdge(2, 5, 4);
        graph.addEdge(1, 7, 11);
        graph.addEdge(0, 7, 8);
        graph.addEdge(2, 8, 2);
        graph.addEdge(3, 5, 14);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 8, 6);
        graph.addEdge(6, 7, 1);
        graph.addEdge(7, 8, 7);*/

    graph.addEdge(1, 2, 5);
    graph.addEdge(2, 3, 2);
    graph.addEdge(1, 4, 9);
    graph.addEdge(1, 5, 3);
    graph.addEdge(5, 6, 2);
    graph.addEdge(6, 4, 2);
    graph.addEdge(3, 4, 3);
    Dijkstra<Integer> dijkstra = new Dijkstra();
    Vertex<Integer> sourceVertex= graph.getVertex(1);
    Map<Vertex<Integer>,Integer> distance = dijkstra.shortPath(graph, sourceVertex);
    for(Vertex<Integer> vertex:distance.keySet()){
      System.out.println(vertex.getId()+":"+distance.get(vertex));
    }
  }
}
