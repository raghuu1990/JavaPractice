package com.prem;
public class DLL {

	public static void main(String[] args) {
		DNode head = new DNode(10);

		DLL dll = new DLL();
		dll.insert(head, 20);
		dll.insert(head, 30);
		dll.insert(head, 40);
		dll.insert(head, 50);

		// dll.display(head);
		
		// System.out.println(dll.middleNode(head).data);
		 dll.display(dll.changeToBST(head));
	}

	//
	public DNode changeToBST(DNode head) {
		if (head == null) {
			throw new RuntimeException("List found null");
		} else {
			head=middleNode(head);
			DNode temp=head.next;
			head.prev.next=null;
			head.prev=changeToBST(head);
			head.next=temp;
		}

		return head;
	}

	public DNode middleNode(DNode fast) {
		DNode slow = fast;
		while (fast.next != null) {
			fast = fast.next;
			if (fast.next != null) {
				fast = fast.next;
			}
			slow = slow.next;
		}
		return slow;
	}

	public int size(DNode head) {
		int count = 0;
		if (head == null) {
			return count;
		} else {
			while (head != null) {
				head = head.next;
				count++;
			}
			return count;
		}
	}

	public void insert(DNode head, int data) {
		if (head != null) {
			while (head.next != null) {
				head = head.next;
			}
			head.next = new DNode(data);
			head.next.prev = head;
		} else {
			head = new DNode(data);
		}
	}

	public void display(DNode node) {
		if (node != null) {
			while (node != null) {
				System.out.println(node.data);
				node = node.next;
			}
		}
	}

}
