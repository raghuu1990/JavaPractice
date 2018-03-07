package com.prem.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
   long id;
   private List<Vertex<T>> adjacencyList= new ArrayList<>();
   private List<Edge<T>> edges= new ArrayList<>();
   boolean isVisited;

  public Vertex(long data){
    this.id=data;
  }

  public void addAdjacency(Edge edge,Vertex vertex){
    adjacencyList.add(vertex);
    edges.add(edge);
  }

  public List<Vertex<T>> getAdjacencyList() {
    return adjacencyList;
  }

  public void setAdjacencyList(List<Vertex<T>> adjacencyList) {
    this.adjacencyList = adjacencyList;
  }

  public List<Edge<T>> getEdges() {
    return edges;
  }

  public void setEdges(List<Edge<T>> edges) {
    this.edges = edges;
  }

  public long getId(){
    return id;
  }

  @Override
  public boolean equals(Object o) {
    Vertex other= (Vertex) o;
    return other.getId()==this.getId();
  }

  @Override
  public int hashCode() {
    int result =(int) this.id;
    return result;
  }

  public void setId(long id) {
    this.id = id;
  }

  public boolean isVisited() {
    return isVisited;
  }

  public void setVisited(boolean visited) {
    isVisited = visited;
  }
}