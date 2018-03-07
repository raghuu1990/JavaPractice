package com.prem.graph;

public class Edge<T> {
  private Vertex<T> from;
  private Vertex<T> to;
  private int cost;
  private boolean isDirected;

  public Edge(Vertex from, Vertex to){
    this.from=from;
    this.to=to;
  }

  public Edge(Vertex from, Vertex to, boolean isDirected, int cost){
    this.from=from;
    this.to=to;
    this.isDirected= isDirected;
    this.cost=cost;
  }

  public Edge(Vertex from, Vertex to, int cost){
    this.from=from;
    this.to=to;
    this.cost=cost;
  }

  @Override
  public boolean equals(Object o) {
      String edgeStr1=this.from.getId()+"-"+this.to.getId();
      Edge edge2=(Edge)o;
      String edgeStr2= edge2.from.getId()+"-"+edge2.to.getId();
    if(isDirected){
      return edgeStr1.equals(edgeStr2);
    }
    else{
      String edgeStr2Reverse=edge2.to.getId()+"-"+edge2.from.getId();
      return edgeStr1.equals(edgeStr2)||edgeStr1.equals(edgeStr2Reverse);
    }
  }

  @Override
  public int hashCode() {
    int result=(int)(this.getFrom().getId()*31+this.getTo().getId()*31+this.getCost()*31);
    return result;
  }


  public Vertex<T> getFrom() {
    return from;
  }

  public void setFrom(Vertex<T> from) {
    this.from = from;
  }

  public Vertex<T> getTo() {
    return to;
  }

  public void setTo(Vertex<T> to) {
    this.to = to;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  public boolean isDirected() {
    return isDirected;
  }

  public void setDirected(boolean directed) {
    isDirected = directed;
  }

}
