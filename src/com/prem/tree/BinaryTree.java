package com.prem.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	public void insertNewNode(Node node, int data) {
		if (data <= node.data) {
			if (node.lc == null) {
				node.lc = new Node(data);
			} else {
				insertNewNode(node.lc, data);
			}
		} else {
			if (node.rc == null) {
				node.rc = new Node(data);
			} else {
				insertNewNode(node.rc, data);
			}
		}
	}

	public int getMaxDepth(Node root) {
		if (root == null)
			return 0;
		else {
			int leftDepth = getMaxDepth(root.lc);
			int rightDepth = getMaxDepth(root.rc);
			if (leftDepth > rightDepth) {
				return leftDepth + 1;
			} else {
				return rightDepth + 1;
			}
		}
	}

	public void levelOrderTraversal(Node root, int level) {
		if (null != root) {
			if (level == 0) {
				System.out.print(root.data + " ");
			} else {
				levelOrderTraversal(root.lc, level - 1);
				levelOrderTraversal(root.rc, level - 1);
			}
		}
	}

	public void displayAllLevels(Node root) {
		for (int i = 0; i < getMaxDepth(root); i++) {

			levelOrderTraversal(root, i);
			System.out.println("                ----      Level:" + i);

		}
	}

	public void inOrder(Node root) {
		if (root != null) {
			inOrder(root.lc);
			System.out.print(root.data + "| ");
			inOrder(root.rc);
		}
	}

	public Node isCommonAncestor(Node root, int a, int b) {
		if (root == null) {
			return null;
		} else {
			if (a < root.data && b < root.data) {
				isCommonAncestor(root.lc, a, b);
			} else if (a > root.data && b > root.data) {
				isCommonAncestor(root.rc, a, b);
			} else {
				return root;
			}
		}
		return null;
	}

	public boolean isSibling(Node root, int a, int b) {
		if (root == null || root.lc == null || root.rc == null)
			return false;
		else
			return (a == root.lc.data && b == root.rc.data)
					|| (a == root.rc.data && b == root.lc.data)
					|| isSibling(root.lc, a, b) || isSibling(root.rc, a, b);
	}

	public Node largestNumberNode(Node root) {
		if (root != null) {
			if (root.rc != null) {
				root = largestNumberNode(root.rc);
			} else {
				return root;
			}
		}
		return root;
	}

	public Node deleteNode(Node root, int num) {
		if (root != null) {
			if (num < root.data) {
				root.lc = deleteNode(root.lc, num);
			} else if (num > root.data) {
				root.rc = deleteNode(root.rc, num);
			} else if (num == root.data) {
				// case 1: if node has no child
				if (root.lc == null && root.rc == null) {
					root = null;
				}
				// case 2: if node has 1 child
				else if (root.lc == null && root.rc != null) {
					root = root.rc;
					// return root;
				} else if (root.lc != null && root.rc == null) {
					root = root.lc;
					// return root;
				}
				// case 3: if node has two child
				else if (root.lc != null && root.rc != null) {
					// get the largest of left side node and copy to root
					Node largestNumberNode = largestNumberNode(root.lc);
					root.data = largestNumberNode.data;
					// now delete the largest node
					root.lc = deleteNode(root.lc, largestNumberNode.data);

					// we can also get the smallest of right side and copy to
					// root and repeat the same proccess.
				}
			}
		}
		return root;
	}

	public Integer lOT(Node head, int level) {
		if (head != null) {
			if (level == 1) {
				return head.data;
			} else {
				Integer result=lOT(head.lc, level - 1);
				if(null==result)
				result=lOT(head.rc, level - 1);
				return result;
			}
		}
		else{
			return null;
		}
	}
	
	public int leftView(Node head, int level,int max){
		if(head==null){
			return level-1;
		}
		else{
			int left=leftView(head.lc, level+1,max);
			int right=leftView(head.rc,level+1,max);
			if(left>=right){
				if(left>max){
					max=left;
					System.out.println(head.data);
				}
				return left-1;
			}
			else{
				//System.out.println(head.data);
				max=right;
				return right-1;
			}
			
		}
	}

	/** is complete binary tree
	 * 1. if root is null -> return true
	 * 2. if both child is not null -> add in the queue
	 * 3. if right child not null but left child is null -> return false
	 * 4. if left child not null and right child null found -> set firstCheckPoint (true)
	 * 5. after firstCheckPoint set to true, every left and right child should be true
	 *
	 * **/
	public boolean isComplete(Node root){
		if(root==null){
			return true;
		}
		boolean firstCheckPoint=false;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			Node parent= queue.poll();
			if(parent.lc!=null && parent.rc!=null){
				queue.offer(parent.lc);
				queue.offer(parent.rc);
			}
			else if(parent.rc!=null && parent.lc==null) return false;
			else if(parent.lc!=null && parent.rc==null){
				queue.offer(parent.lc);
				firstCheckPoint=true;
			}
			if(!firstCheckPoint && parent.lc!=null||parent.rc!=null){
				firstCheckPoint=true;
			}
			//after once checkpoint is true then every node should contain null child
			if(firstCheckPoint && (parent.lc!=null || parent.rc!=null)){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		Node root = new Node(25);

		bt.insertNewNode(root, 14);
		bt.insertNewNode(root, 28);
		bt.insertNewNode(root, 10);
		bt.insertNewNode(root, 16);
		bt.insertNewNode(root, 27);
		bt.insertNewNode(root, 29);
		
		

		//bt.displayAllLevels(root);

		//System.out.println(bt.isSibling(root, 3, -1));
		//System.out.println(bt.isCommonAncestor(root, 2, 4).data);

		//bt.inOrder(root);
		//System.out.println("Largest NO:" + bt.largestNumberNode(root).data);

		//root = bt.deleteNode(root, 0);
		bt.displayAllLevels(root);
		//for(int i=1;i<=bt.getMaxDepth(root);i++)
		//System.out.println(bt.lOT(root, i));
		bt.leftView(root, 1,1);
	}
}
