package com.prem.tree;

public class AVL extends BST{

  public Node leftRotation(Node root){
    Node newRoot=root.rc;
    root.rc=root.rc.lc;
    newRoot.lc=root;
    root.height = getHeight(root);
    newRoot.height= getHeight(newRoot);
    return newRoot;
  }
  public Node rightRotation(Node root){
    Node newRoot=root.lc;
    root.lc=root.lc.rc;
    newRoot.rc=root;
    root.height = getHeight(root);
    newRoot.height= getHeight(newRoot);
    return root;
  }


  public Node insertAvl(Node root, int data){
    if(root!=null){
      if(data>root.data){
          root.rc=insertAvl(root.rc,data);
      }
      else{
         root.lc= insertAvl(root.lc,data);
      }
      int balance= avlHeight(root.lc)- avlHeight(root.rc);
      if(balance<-1){
        if(avlHeight(root.rc.rc)>=avlHeight(root.rc.lc)){
          root=leftRotation(root);
        }
        else{
          root.rc=rightRotation(root.rc);
          root=leftRotation(root);
        }
      }
      else if(balance>1){
        if(avlHeight(root.lc.lc)>=avlHeight(root.lc.rc)){
          root=rightRotation(root);
        }
        else{
          root.lc=leftRotation(root.lc);
          root=rightRotation(root);
        }
      }
      else{
        root.height=getHeight(root);
      }
      return root;
    }
    else{
      return new Node(data);
    }
  }

  public int avlHeight(Node root){
    if(root==null){
      return 0;
    }
    return root.height;
  }

  public static void main(String[] args) {
    AVL avl = new AVL();
    Node root = null;
    for(int i=2;i<9;i++) {
      root=avl.insertAvl(root, i);
    }
    avl.allLevelOrderTraversal(root);
    avl.inOrder(root);

  }
}