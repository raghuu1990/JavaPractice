package com.prem.linkedlist;

import java.util.Stack;

public class Ll {
	static LNode rhead=null;

	public static void main(String[] args) {
		Ll ll= new Ll();

/*
		LNode head= new LNode(10);
		head=ll.insert(head,5);
		head=ll.insert(head, 15);
		head=ll.insert(head, 2);
		head=ll.insert(head, 50);
		head=ll.insert(head, 2);
		head=ll.insert(head, 10);
		ll.display(head);
		System.out.println("---");
		rhead=ll.reverse(head);
		ll.display(rhead);
*/
		//System.out.println("Middle tree.Node:"+ll.getMiddleNode(head).data);
		//System.out.println(ll.getNthNodeFromEnd(head, 6).data);

		//System.out.println(ll.isLoopedLinkedList(head));
		//System.out.println(ll.isLoopedLinkedList(ll.getLoopedLinkedList()));

/*
		LNode h=ll.removeDuplicateInUnsorted(head);
		ll.display(h);

		System.out.println("--");
		//making two intersect linkedlist
		*/
/**
		 *
		 *            1 -- 2
		 * 			        \
		 * 			         3 -- 4 -- 5 -- 6
		 * 					/
		 * 7 -- 8 -- 9 -- 10
		 *//*


		LNode head1= new LNode(1);
		LNode node2= new LNode(2);
		LNode node3= new LNode(3);
		LNode node4= new LNode(4);
		LNode node5= new LNode(5);
		LNode node6= new LNode(6);

		LNode head2= new LNode(7);
		LNode node8= new LNode(8);
		LNode node9= new LNode(9);
		LNode node10= new LNode(10);

		head1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		head2.next=node8;
		node8.next=node9;
		node9.next=node10;
		node10.next=node3;

		//intersected linkedlist creation end.

		LNode intersected=ll.getIntersectionInLinkedList(head1, head2);
		System.out.println(intersected.data);
*/
		LNode a= null;
		a=ll.insert(a,1);
		a=ll.insert(a,2);
/*
		a=ll.insert(a,3);
		a=ll.insert(a,4);
		a=ll.insert(a,5);
*/
//		ll.display(ll.reverseInGroupOfSizeK(a,3));
//		ll.display(rhead);
		LNode b= null;
		b=ll.insert(b,5);
		b=ll.insert(b,6);
/*
		b=ll.insert(b,7);
		b=ll.insert(b,8);
*/
		LNode result= ll.multiplyTwoNumber(a,b);
		//LNode result=ll.addTwoNumber(a,b);
		ll.display(result);
/*
		LNode a= null;
		a=ll.insert(a,1);
		a=ll.insert(a,2);
		a=ll.insert(a,3);
		a=ll.insert(a,0);
		a=ll.insert(a,-1);
		a=ll.insert(a,6);
		a=ll.insert(a,7);
		a=ll.insert(a,8);
		//ll.display(a);
		a=ll.deleteLargerNodeOnRightSide(a);
		ll.display(a);
		*/

		/*LNode b= null;
		b=ll.insert(b,2);
		b=ll.insert(b,4);
		b=ll.insert(b,6);
		b=ll.insert(b,12);
		LNode result=ll.mergeTwoSortedLL(a,b);
*///		LNode result=ll.addTwoLinkedList(a, b);
		//ll.display(result);

		//ll.display(a);

		//System.out.println(ll.getMiddleNode(a).data);




/*
		LNode a= null;
		a=ll.insert(a,5);
		a=ll.insert(a,6);
		a=ll.insert(a,7);
		a=ll.insert(a,8);
		a=ll.insert(a,8);
		a=ll.insert(a,7);
		a=ll.insert(a,1);
		a=ll.insert(a,5);
		System.out.println(ll.isPalindrome(a));
*/
/*
		LNode head=ll.getLoopedLinkedList();
		System.out.println(ll.getLoopOriginNode(head).data);
*/




	}



	/**
	 * pass two list head whose node are intersecting at a point.
	 * @param head1
	 * @param head2
	 * @return LNode (intersecting point)
	 */
	public LNode getIntersectionInLinkedList(LNode head1, LNode head2){
		//get tempHead1 for head1 and tempHead2 for head2 to get both list count
		LNode tempHead1=head1;
		LNode tempHead2=head2;


		int head1Count=0;
		int head2Count=0;

		//get first list count
		while(tempHead1!=null){
			head1Count++;
			tempHead1=tempHead1.next;
		}
		//get second list count
		while(tempHead2!=null){
			head2Count++;
			tempHead2=tempHead2.next;
		}

		//get diff of both list and set in travNode which list is larger
		int diff = 0;
		LNode travNode = null;
		if (head1Count > head2Count) {
			diff = head1Count - head2Count;
			travNode = head1;
		} else {
			diff = head2Count - head1Count;
			travNode = head2;
		}

		//start to traverse from larger list by diff no. of steps.
		if(travNode==head1){
			while(diff!=0){
				head1=head1.next;
				diff--;
			}
		} else{
			while(diff!=0){
				head2=head2.next;
				diff--;
			}
		}

		//Now both list are on equal distance from intersected list, so traverse until both list node match
		while(head1!=head2){
			head1=head1.next;
			head2=head2.next;
		}

		return head1;
	}

	/**
	 * return node if it contains looped linked list
	 * return null otherwise
	 * @param head
	 * @return
   */
	public LNode isLoopedLinkedList(LNode head){
		LNode fast=head;

		while(fast!=null){
			fast=fast.next;
			if(fast!=null){
				fast=fast.next;
				head=head.next;
			}
			if(fast==head){
				return fast;
			}
		}
		return null;
	}
	public LNode getLoopOriginNode(LNode head){
		LNode meetPoint = isLoopedLinkedList(head);
		if(null==meetPoint) return null;
		while(head!=meetPoint){
			head=head.next;
			meetPoint=meetPoint.next;
		}
		return meetPoint;
	}


	public void dummySort(){
		for(int i=0;i<5;i++){
			for(int j=0;j<i;j++){

					//swap the variable if second is found lesser than the first

				System.out.println();
			}
		}
	}


	public void sort(LNode head){


		if(head!=null){
			while(head.next!=null){
				head=head.next;

			}
		}
	}

	public LNode insert(LNode root, int data){
		LNode head =root;
		if(root==null){
			return new LNode(data);
		}
		else{
			while(root.next!=null){
				root=root.next;
			}
			root.next=new LNode(data);
		}
		return head;
	}

	public void display(LNode root){
			while(root!=null){
				System.out.println(root.data);
				root=root.next;
			}
	}


	public LNode getMiddleNode(LNode root){
		LNode slow= root;
		LNode fast=root;
		if(root!=null){
			while(fast!=null){
				fast = fast.next;
				if(fast!=null){
					fast=fast.next;
				}
				slow=slow.next;
			}
			return slow;
		} else {
			return null;
		}
	}

	public void deleteLinkedList(LNode head){
		LNode nextNode=head.next;
		while(nextNode!=null){
			head=null;
			head=nextNode;
			head=head.next;
		}
		head=null;
	}


	public LNode getNthNodeFromEnd(LNode head, int n){
		//get nAhead node which will be n step ahead of root
		LNode nAhead=head;
		if(nAhead!=null){
			while(nAhead.next!=null){
				if(--n==0) break;
				nAhead=nAhead.next;
			}
			//if nAhead can't read n steps ahead then linked list have not enough nodes.
			if(n>0){
				throw new RuntimeException("No. of nodes in linked list not enough to get nth node from end");
			}
		}
			//when nAhead will reach at end head will be @ n steps behind from end.
			while(nAhead.next!=null){
				head=head.next;
				nAhead=nAhead.next;
			}
			return head;
		}

	public LNode removeDuplicateInUnsorted(LNode head){
		while(head!=null){
			LNode temp=head;

			 temp=temp.next;
				while(temp!=null){
					if(head.data==temp.data){
						LNode nextNode=temp.next;
						temp=null;
						temp=nextNode;
					}
					else{
						temp=temp.next;
					}
				}
				head=head.next;
		}
		return head;
	}

	public LNode iterativeReverse(LNode p){
		LNode r=null;
		LNode q=p;
		while(p!=null){
			p=q.next;
			q.next=r;
			r=q;
			q=p;
		}
		return r;
	}


	public LNode reverseInGroupOfSizeK(LNode p,int size){
		LNode r=null;
		LNode head=p;
		LNode q=p;
		int count=size;

		//first reverse of size k same we reverse in iterative reverse
		while(p!=null && count--!=0){
			p=q.next;
			q.next=r;
			r=q;
			q=p;
		}

		//now check if next p node is not null
		//now head will be tail now so send head.next to recursive to reverse next size node and so on.
		// at last return r which is our list actual head as in iterative reverse
		if(p!=null)
		head.next=reverseInGroupOfSizeK(p,size);
		return r;
	}

	/**
	 * 10 5 30 2 35
	 * @param head
	 * @return
	 */
	public LNode reverse(LNode head){
		//wait until last node comes make this head (defined static)
		if(head.next==null){
			rhead=head;
			return rhead;
		}
		else {
			//recursive method will return one right node, on right next node set current node
			LNode prev=reverse(head.next);
			head.next=null;
			prev.next=head;
			return head;
		}
	}

  /**
   * put first list into stack1 and second list data in stack2
   *
   * now start to pop from both stack until any of them get empty
   *
   *  get data from both stack -> data1, data2 and keep a carry=0
   *  sum = data1+data2+carry
   *  if sum exceeds 9 -> set to carry to 1
   *  and sum sum=sum%10
   *
   *  and keep adding to linkedlist
   *
   *
   *
   *
   */
	public LNode addTwoLinkedList(LNode a, LNode b){
		Stack<Integer> stack1= new Stack<>();
		Stack<Integer> stack2= new Stack<>();
		while(a!=null){
			stack1.add(a.data);
			a=a.next;
		}
		while(b!=null){
			stack2.add(b.data);
			b=b.next;
		}
		LNode result = null;
		int carry= 0;
		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			int sum= stack1.pop()+ stack2.pop()+carry;
			if(sum>9){
				carry=1;
				sum=sum%10;
			}
			else carry=0;
			result= insert(result,sum);
		}
		Stack<Integer> tempStack=null;
		if(!stack1.isEmpty()) tempStack=stack1;
		else if(!stack2.isEmpty()) tempStack=stack2;
		while(tempStack!=null && !tempStack.isEmpty()){
			if(carry>0){
				result=insert(result,tempStack.pop()+carry);
				carry=0;
			}
			else{
				result=insert(result,tempStack.pop()+carry);
			}
		}
		if(carry>0) result = insert(result, carry);
		return result;
	}

	/**
	 * feed all nodes in a stack.
	 * start to traverse from first node.
	 * pop node from stack and check if matches with node
	 * and keep moving next node
	 *
	 * if at any point not matches return false
	 *
   */
	public boolean isPalindrome(LNode start){
		LNode head=start;
		Stack<LNode> stack = new Stack<>();
		while(start!=null){
			stack.push(start);
			start=start.next;
		}
		boolean isPalindrome=true;
		while(head!=null){
			if((head.data!=stack.pop().data)){
				isPalindrome=false;break;
			}
			head=head.next;
		}
		return isPalindrome;
	}

	/**
	 *
	 * Merge two linked list using recursion
	 * if list1 is null return list2 and vice versa
	 * if list1.data < list2.data
	 * 	 take list1 and send list1.next to next recursion to merge list1 from next and list2
	 *
   */
	public LNode mergeTwoSortedLL(LNode a, LNode b){
		if(a==null){
			return b;
		}
		else if(b==null){
			return a;
		}
		if(a.data<b.data){
			a.next=mergeTwoSortedLL(a.next,b);
			return a;
		}
		else{
			b.next=mergeTwoSortedLL(b.next,a);
			return b;
		}
	}


	/**
	 * Linklist containing loop
	 * 27 -- 25 -- 23
	 *            /  \
	 *           17  21
	 *            \  /
	 *             19
	 *
	 */
	public LNode getLoopedLinkedList(){

		LNode head= new LNode(27);
		LNode node2= new LNode(25);
		LNode jointNode= new LNode(23);

		LNode node4= new LNode(21);
		LNode node5= new LNode(19);
		LNode node6= new LNode(17);

		head.next=node2;
		node2.next=jointNode;
		jointNode.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=jointNode;

		return head;
	}

	/**
	 * two sorted linked list given, need to make a union in third linked list
	 *
	 * if first null return second and vice versa
	 *
	 * if first data < second data
	 * 		add first and move first
	 * if second data < first data
	 * 		add second and move second
	 * if both same
	 * 		add first and move both
	 *
	 * if first or second come to null
	 * 	make resultNode next to first/second which is still not null
	 *
   */
	public LNode getUnion(LNode first, LNode second){
		if(first==null) return second;
		if(second==null) return first;

		LNode resultNode = null;
		while(first!=null && second!=null){
			if(first.data<second.data){
				if(resultNode!=null) resultNode.next=first;
				else resultNode=first;

				first=first.next;
			}
			else if(second.data<first.data){
				if(resultNode!=null) resultNode.next=second;
				else resultNode=second;

				second=second.next;
			}
			else{
				if(resultNode!=null) resultNode.next=first;
				else resultNode=first;

				first=first.next;
				second=second.next;
			}
		}
		if (first == null) resultNode.next=second;
		else resultNode.next=first;

		return resultNode;
	}

	public LNode getIntersection(LNode first, LNode second) {
		if(first==null||second==null) return null;
		LNode result=null;
		while (first != null && second != null) {
			if(first.data< second.data) first=first.next;
			if(second.data<first.data) second=second.next;
			else{
				if(result==null) result=first;
				else result.next=first;
				first=first.next;
				second=second.next;
			}
		}
		return result;
	}

	/**
	 * delete all larger node on right side of linked list
	 * Take first node as min
	 * compare it with next node if next node is less
	 * then make node.next = node.next.next
	 * else
	 * 	move current node to node.next
	 *
	 * 	return head
   */
	public LNode deleteLargerNodeOnRightSide(LNode head){
		LNode node=head;
		if(node!=null) {
			Integer min = head.data;
			while (node != null) {
				if (node.next != null) {
					if (min < node.next.data) {
						node.next = node.next.next;
					} else {
						node = node.next;
					}
				} else {
					node = node.next;
				}
			}
		}
		return head;
	}

	public LNode addTwoNumber(LNode a, LNode b){
		a=iterativeReverse(a);
		b=iterativeReverse(b);
		int carry=0;
		LNode result=new LNode();
		LNode resultHead=result;
		int sum=0;
		while(a!=null && b!=null){
			sum=(a.data+b.data+carry);
			carry=(a.data+b.data+carry)/10;
			if(sum>9) sum=sum-10;
			result.next= new LNode(sum);
			result=result.next; a=a.next; b=b.next;
		}

		if(a!=null){
			result.next=a;
		}
		else if(b!=null){
			result.next=b;
		}

		resultHead=iterativeReverse(resultHead.next);
		return resultHead;
	}

	public LNode multiplyTwoNumber(LNode a, LNode b){
		//Check which is larger linkedList
		LNode largerNode=a;
		LNode smallerNode=iterativeReverse(b);
/*
		while(largerNode!=null && smallerNode!=null){
			largerNode=largerNode.next;
			smallerNode=smallerNode.next;
		}
		if(largerNode!=null|| (largerNode==null && smallerNode==null)){
			largerNode=a;
			smallerNode=b;
		}
		else{
			largerNode=b;
			smallerNode=a;
		}

		LNode totalSum=new LNode(0);
		LNode lowerSum=new LNode();
*/
		int index=0;
		LNode totalSum=new LNode(0);
		while(smallerNode!=null){
			largerNode=a;
			LNode singleBaseMultiply=multiplyWithSingleNumber(largerNode,smallerNode.data*((int)Math.pow(10,index++)));
			totalSum=addTwoLinkedList(singleBaseMultiply,totalSum);
			smallerNode=smallerNode.next;
		}
		return totalSum;
	}

	public LNode multiplyWithSingleNumber(LNode bigNumber,int num){
		bigNumber=iterativeReverse(bigNumber);
		LNode resultNode=new LNode();
		LNode head=resultNode;
		int carry=0;
		int sum=0;
		while(bigNumber!=null){
			sum=num*bigNumber.data+carry;
			carry=(num*bigNumber.data)/10;
			if(sum>9){sum=sum-10;}
			resultNode.next=new LNode(sum);
			bigNumber=bigNumber.next;resultNode=resultNode.next;
		}
		if(carry!=0) resultNode.next=new LNode(carry);
		return iterativeReverse(head.next);
	}

	public LNode rearrange(LNode head){
		LNode middle=getMiddleNode(head);
		LNode reversed=reverse(middle);
		LNode temp=null;
		temp=head;
		LNode tempHead=null;
		LNode tempReverse=null;
		while(reversed!=null){
			tempHead=head.next;  //save head next b4 connecting to reverse
			head=head.next;
			temp.next=reversed;
			tempReverse=reversed.next; //save reverse next
			reversed.next=tempHead;

			temp.next=head.next;
			head=head.next;
		}
		return temp;
	}

}
