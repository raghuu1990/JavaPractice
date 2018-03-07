package com.linkedlist;

import com.node.DNode;

// 1->2->3->4->5->6->7->8->9->10 ==>  1->10->2->9->3->8->4->7->5->6
// O(n^2)

public class ReverseDList {
	public static void main(String[] args) {
		DNode head = DNode.getLinkedList(10);
		printForward(head);
		printBackward(head);
		head = reverse(head);
		printForward(head);
		printBackward(head);
	}

	public static DNode reverse(DNode head) {
		DNode curr = head;
		DNode prev = head!=null?head.left:head;
		while (curr!= null) {
			DNode temp = curr.right;
			curr.right = prev;
			if(prev!=null) {
				curr.left = prev.left;
				prev.left = curr;
			}
			prev = curr;
			curr = temp;
		}
		return prev;
	}
	
	public static void printForward(DNode node) {
		while (node != null) {
			System.out.print(node.data);
			System.out.print(" ");
			node = node.right;
		}
		System.out.println();
	}

	public static void printBackward(DNode node) {
		while(node!=null && node.right!=null) {
			node = node.right;
		}
		while (node != null) {
			System.out.print(node.data);
			System.out.print(" ");
			node = node.left;
		}
		System.out.println();
	}
}