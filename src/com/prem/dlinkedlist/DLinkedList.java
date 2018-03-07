package com.prem.dlinkedlist;

/**
 * Created by lovebharti on 30/7/16.
 */
public class DLinkedList<T> {

  public static void main(String[] args) {
    DLinkedList dll= new DLinkedList();
    DLNode head=dll.insert(null,5);
    dll.insert(head,10);
    dll.insert(head,15);
    dll.insert(head,20);
    dll.insert(head,25);
    dll.insert(head,30);
    dll.insert(head,35);
    dll.display(head);
    /*head=dll.insertAtSortedNode(head,31);
    System.out.println();
    dll.display(head);

    head=dll.insertAtSortedNode(head,36);
    System.out.println();
    dll.display(head);

    head=dll.insertAtSortedNode(head,4);
    System.out.println();

    head=dll.insertAtSortedNode(head,20);
    System.out.println();

    dll.display(head);
    */head=dll.reverse(head);
    System.out.println();
    dll.display(head);

  }

  public void display(DLNode head){
    while(head!=null){
      System.out.print(head.data+ ", ");
      head=head.next;
    }
  }

/*
  public DLNode insertAtSortedNode(DLNode head, int data){
    DLNode first=head;
    DLNode node= new DLNode(data);
    if(head==null){
      return node;
    }
    if(data<head.data){
      node.next=head;
      head.prev=node;
      return node;
    }


    while(!(head!=null && data<head.data)){
      if(head.next==null && data>head.data){
        head.next=node;
        node.prev=head;
        return first;
      }
      head=head.next;
    }

    DLNode temp=head.next;
    head.prev.next=node;
    node.prev=head;
    node.next=temp;
    if(temp!=null)
    temp.prev = node;
    return first;
  }
*/

  public DLNode insert(DLNode head,T data){
    DLNode first=head;

    DLNode node= new DLNode(data);

    if(head==null){
      return node;
    }

    while(head.next!=null){
      head=head.next;
    }

    head.next=node;
    node.prev=head;

    return first;
  }


  /** Need to look into **/
  public DLNode reverse(DLNode head){
    if(head==null){
      return null;
    }
    DLNode prev= head.prev;

    while(head.next!=null){
      prev=head;
      DLNode temp=head.next;
      head.next=head.prev;
      head.prev=temp;
      head=temp;
    }
    head.next=prev;
    head.prev=null;

    return head;

  }

}
