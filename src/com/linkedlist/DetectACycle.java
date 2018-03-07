package com.linkedlist;

import com.node.Node;

public class DetectACycle {
	private static boolean hasCycle(Node head) {
		if(head==null) {
			return false;
		}
		Node slow = head;
		Node fast = head.next;
		
		while(slow!=null) {
			if(slow==fast) {
				return true;
			}
			
			slow = slow.next;
			if(fast.next!=null) {
				fast = fast.next;
				if(slow==fast) {
					return true;
				}
				fast = fast.next;
			}else {
				return false;
			}
		}
		return false;
	}
}
