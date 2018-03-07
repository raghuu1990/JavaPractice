package com.prem.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.prem.linkedlist.LNode;
import com.prem.linkedlist.Ll;

public class MergeKList {

    public LNode merge(List<LNode> list){
      PriorityQueue<LNode> minHeap = new PriorityQueue(list.size(),new LNodeComparator());
      for (LNode node : list) {
        if (node != null) {
          minHeap.add(node);
          node=node.next;
        }
      }
      LNode head = new LNode(-1);
      LNode temp=head;
      while(!minHeap.isEmpty()){
        LNode min=minHeap.poll();
        temp.next=min;
        temp=temp.next;
        if(min.next!=null) minHeap.offer(min.next);
      }
      return head.next;
    }

  public static void main(String[] args) {
    LNode node1 = new LNode(1);
    node1.next=new LNode(4);
    node1.next.next = new LNode(7);

    LNode node2 = new LNode(3);
    node2.next=new LNode(6);
    node2.next.next = new LNode(9);

    LNode node3 = new LNode(8);
    node3.next=new LNode(10);
    node3.next.next = new LNode(11);
    List<LNode> list = new ArrayList<>();
    list.add(node1);
    list.add(node2);
    list.add(node3);

    MergeKList mkl= new MergeKList();
    LNode sorted = mkl.merge(list);

    Ll ll = new Ll();
    ll.display(sorted);

  }


}

class LNodeComparator implements Comparator<LNode>{

  @Override
  public int compare(LNode first, LNode second) {
    return first.data-second.data;
  }
}
