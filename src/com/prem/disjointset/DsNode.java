package com.prem.disjointset;

/**
 * Created by lovebharti on 31/7/16.
 */
public class DsNode {
   int rank;
   long data;
   DsNode parent;


   int size;//not required

   public DsNode(long data){
      this.data=data;
      this.size=1;
   }

   public int getRank() {
      return rank;
   }

   public void setRank(int rank) {
      this.rank = rank;
   }

   public long getData() {
      return data;
   }

   public void setData(long data) {
      this.data = data;
   }

   public int getSize() {
      return size;
   }

   public void setSize(int size) {
      this.size = size;
   }

   public DsNode getParent() {
      return parent;
   }

   public void setParent(DsNode parent) {
      this.parent = parent;
   }
}


