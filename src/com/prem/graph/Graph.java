package com.prem.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<T> {

  Map<Long, Vertex<T>> vertexList;
  Set<Edge<T>> edges;
  boolean isDirected;

  public Graph(boolean isDirected) {
    this.isDirected = isDirected;
    this.vertexList= new HashMap<>();
    this.edges= new HashSet<>();
  }

  public void addVertex(Vertex<T> vertex) {
    if (!vertexList.containsKey(vertex.getId())) {
      vertexList.put(vertex.getId(), vertex);
    }
    edges.addAll(vertex.getEdges());
  }

  public Vertex createVertex(long id) {
    if (!vertexList.containsKey(id)) {
      Vertex v = new Vertex(id);
      return v;
    } else {
      return vertexList.get(id);
    }
  }

  public Edge addEdge(long id1, long id2, int weight) {
    Vertex v1 = null;
    if (!vertexList.containsKey(id1)) {
      v1 = new Vertex(id1);
      vertexList.put(id1, v1);
    } else {
      v1 = vertexList.get(id1);
    }
    Vertex v2 = null;
    if (!vertexList.containsKey(id2)) {
      v2 = new Vertex(id2);
      vertexList.put(id2, v2);
    } else {
      v2 = vertexList.get(id2);
    }

    Edge edge = new Edge(v1, v2, weight);
    edges.add(edge);

    v1.addAdjacency(edge, v2);
    if (!this.isDirected) {
      v2.addAdjacency(edge, v1);
    }
    return edge;
  }


  public Vertex<T> getVertex(long id){
    return vertexList.get(id);
  }

  public Edge addEdge(long id1, long id2) {
    return addEdge(id1, id2, 0);
  }

  public int getDegree(){
    return edges.size();
  }

  public Map<Long, Vertex<T>> getVertexList() {
    return vertexList;
  }

  public void setVertexList(Map<Long, Vertex<T>> vertexList) {
    this.vertexList = vertexList;
  }

  public Set<Edge<T>> getEdges() {
    return edges;
  }

  public void setEdges(Set<Edge<T>> edges) {
    this.edges = edges;
  }

  public boolean isDirected() {
    return isDirected;
  }

  public void setDirected(boolean directed) {
    isDirected = directed;
  }
}