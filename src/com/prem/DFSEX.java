package com.prem;
import java.util.List;

import com.prem.graph.GNode;

/**
 * Created by lovebharti on 28/5/16.
 */
public class DFSEX {

  public static void main(String[] args) {
    GNode<Integer> gNode = new GNode<>();
    GNode<Integer> start=gNode.getCycledIntegerGraph();
    DFSEX ex= new DFSEX();
    ex.traverse(start);

  }

  public void traverse(GNode<Integer> node){
      if(node!=null){
        node.setVisited(true);
        System.out.println(node.getData());
        List<GNode<Integer>> vertices= node.getVertices();
        if(null!=vertices && vertices.size()>0){
          for(GNode<Integer> nodeToVisit: vertices) {
            if(nodeToVisit.isVisited()){
              System.out.println("loop");
              break;
            }
            traverse(nodeToVisit);
          }
        }
      }
  }
}
