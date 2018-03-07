package com.prem.dlinkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * It's a caching algorithm, Let's say we have to cache 50 last element used by the user.
 *
 * Caching in which we keep recent used page and remove old one
 * if exceeds size of cache.
 *
 * Keep a map and doubly linked list
 *
 *  Map -> will give result in O(1) using url as key
 *  DDL -> will work as queue and removing and appending operation will take O(1) operation.
 *
 *  using key get node from map directly and remove map in O(1) from dll.
 *  So, add in both(map,dll) and remove from both for consistency.
 */
public class LRUCache {

  private int count=0;
  private int threshold=0;
  DLNode<Page> head=null;
  Map<String,DLNode> map;

  public LRUCache(int threshold) {
    this.threshold=threshold;
    map = new HashMap<>();
  }


  /**
   * if url response exist in map return response
   *    remove from dll and append to tail
   * else
   *    fetch response
   *      if count is still less than threshold then just append to tail and add to map
   *      else
   *        remove head from dll and same remove from map
   *        and append to tail and add to map
   *
   */
  public Page get(String url){
    if(map.containsKey(url)){
      DLNode<Page> node = map.get(url);
      removeFromDll(map.get(url));
      head=appendToDll(head,node);
      return node.data;
    }
    else{
      // fetch the url response from the internet or resource
      Page page = new Page();
      page.setUrl(url);
      DLNode newNode = new DLNode();
      newNode.data=page;

      if(count<threshold){
        head=appendToDll(head,newNode);
        map.put(url,newNode);
        count++;
      }
      else if(count>=threshold){
        String headUrl=head.data.getUrl();
        removeFromHead();
        map.remove(headUrl);
        appendToDll(head,newNode);
        map.put(url,newNode);
      }
      return page;
    }
  }

  public void removeFromDll(DLNode node){
    //in case node is head: make next node as head
    if(node.prev==null){
      head=head.next;
      head.prev=null;
    }
    else{
      DLNode next= node.next;
      node.prev.next=next;
      next.prev=node.prev;
    }
  }

  /**
   * at time of appending remember to add node.next =null;
   * @param head
   * @param node
   * @return
   */
  public DLNode appendToDll(DLNode head, DLNode node){
    DLNode start= head;
    if(head==null){
      return node;
    }
    else{
      while(head.next!=null){
        head= head.next;
      }
      head.next=node;
      node.prev=head;
      node.next=null;
    }
    return start;
  }

  public void removeFromHead(){
    head=head.next;
  }

  //in case you want to explicitly add pages to cache
  public void add(String url,Page page){
    DLNode newNode = new DLNode(page);
    if(map.containsKey(url)){
      removeFromDll(map.get(url));
      head=appendToDll(head,newNode);
    }
    if(count<threshold){
      head=appendToDll(head,newNode);
      map.put(page.getUrl(),newNode);
    }
  }

  public void printCache(DLNode<Page> head){
    DLNode<Page> start= head;
    while(start!=null){
      System.out.print(start.data.getUrl()+", ");
      start=start.next;
    }
  }

  public static void main(String[] args) {
    int[] pages={1,2,3,4,5,1,2,4,2,3,12,13,14,2,5,6};
    LRUCache lru= new LRUCache(7);
    for(int page:pages) {
      System.out.print(page+":>");
      lru.get(page+"");
      lru.printCache(lru.head);
      System.out.println();
    }
  }
}