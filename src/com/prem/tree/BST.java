package com.prem.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.LinkedBlockingQueue;

public class BST {
	private Queue<Node> nodeQueue= new LinkedBlockingQueue<>();
	private int[] inOrder={0,1,2,3,4,5,6};
	private int[] preOrder={3,1,0,2,5,4,6};

	/**
	 * predefined we send min to integer min and  max to integer max
	 *  if data is under limit then keep checking
	 * when go to left then max will be root (update)
	 * when go to right then min will be root
	 *
	 */
	public boolean isBST(Node root, int min, int max){
		if(root==null){return true;}
		if(root.data>min && root.data<max){
			return isBST(root.lc,min,root.data) && isBST(root.rc,root.data,max);
		}
			return false;
	}

	/**
	 * if first and second node null -> true
	 * if first null and second not null and vice versa -> false
	 * else
	 *  if first data and second data true
	 *  	then send
	 *  	first left and second right
	 *  	and first right and second left
	 *  to recursion
   	*/
	public boolean isMirrorTree(Node first,Node second){
		boolean isMirrored=false;
		//if both tree's root are null they are mirrored
		if(first==null && second==null) return true;
		//if node of one tree is null and corresponding other tree's node is not null
		// they are not mirrored
		else if((first==null && second!=null) || first!=null && second==null){
			return false;
		}
		else {
			// if both corresponding mirrored node are same
			if(first.data==second.data) {
				isMirrored=true;
			}
			else {
				return false;
			}
			// take one tree's left node and second's tree right node
			return isMirrored && isMirrorTree(first.lc, second.rc) && isMirrorTree(first.rc,second.lc);

		}
	}

	/**
	 * if root is leaf return 1
	 * if left is null return minDepth of right + 1
	 * if right is null return minDepth of left + 1
	 * if both child are not null return Min depth of both + 1
	 * @param node
	 * @return
   */
	public int getMinDepth(Node node){
		if (null == node) {
			return 0;
		}
		else if (null == node.lc && null == node.rc) {
			return 1;
		} else if (null == node.lc) {
			return getMinDepth(node.rc)+1;
		} else if (null == node.rc) {
			return getMinDepth(node.lc)+1;
		}
		return Math.min(getMinDepth(node.lc),getMinDepth(node.rc))+1;

	}

	/**
	 * if first and second node null -> true
	 * if first null and second not null and vice versa -> false
	 * else
	 *  if first data and second data true
	 *  	then send
	 *  	first left and second left
	 *  	and first right and second right
	 *  to recursion
	 */

	public boolean isBSTSame(Node first, Node second){
		boolean isSame=false;
		if(first==null && second==null) return true;
		else if((first==null && second!=null)||(first!=null && second==null)){
			return false;
		}
		else{
			if(first.data==second.data){
				isSame=true;
			}
			else return false;
			return isSame && isBSTSame(first.lc,second.lc) && isBSTSame(first.rc,second.rc);
		}
	}

/*
	public void levelOrderTraversal(Node root){
		if(root!=null){
			if(nodeQueue.isEmpty()){
				nodeQueue.add(root);
			}
			if(root.lc!=null){
				nodeQueue.add(root.lc);
			}
			if(root.rc!=null){
				nodeQueue.add(root.rc);
			}
			levelOrderTraversal(root.lc);
			levelOrderTraversal(root.rc);
		}
	}
*/

	/**
	 * add root to queue
	 *
	 *  until queue is empty
	 * 		take out node from queue
	 * 				print node data
	 * 		take out its left and right
	 * 				and add to queue
   */
	public void levelOrderTraversal(Node root){
		if(root!=null){
			if (nodeQueue.isEmpty()) {
				nodeQueue.add(root);
			}
			while(!nodeQueue.isEmpty()) {
				Node parent = nodeQueue.remove();
				System.out.print(parent.data + " ");
				if (parent.lc != null) {
					nodeQueue.add(parent.lc);
				}
				if (parent.rc != null) {
					nodeQueue.add(parent.rc);
				}
			}
		}
	}

	Stack<Node> leftToRight= new Stack<>();
	Stack<Node> rightToLeft= new Stack<>();

	public void zigzag(Node root){
		leftToRight.push(root);
		while(!leftToRight.isEmpty()||!rightToLeft.isEmpty()){
			while(!leftToRight.isEmpty()){
				Node node=leftToRight.pop();
				System.out.println(node.data);
				if(node.lc!=null)
					rightToLeft.push(node.lc);
				if(node.rc!=null)
					rightToLeft.push(node.rc);

			}
			while(!rightToLeft.isEmpty()){
				Node node=rightToLeft.pop();
				System.out.println(node.data);
				if(node.rc!=null)
					leftToRight.push(node.rc);
				if(node.lc!=null)
					leftToRight.push(node.lc);
			}
		}
	}

	public boolean isSibling(Node root, int left,int right){
		if(root==null || root.lc==null || root.rc==null){
			return false;
		}
		else{
			return (left==root.lc.data && right==root.rc.data)||
					(left==root.rc.data && right==root.lc.data)||
					isSibling(root.lc,left, right) ||
					isSibling(root.rc, left, right);
		}
	}

	public Node getCommonAncestorBST(Node root,int a, int b){
		if(root==null) return null;
		else{
			if(a==root.data||b==root.data) return root;
			else if(a<root.data && b<root.data){
				return	getCommonAncestorBST(root.lc, a, b);
			}
			else if(a>root.data && b>root.data){
				return getCommonAncestorBST(root.rc, a, b);
			}
			else if((a<root.data && b>root.data)|| (a>root.data && b<root.data)){
				return root;
			}
		}
		return null;
	}

	/**
	 * if root left'sdata or root right's data -> a or b
	 * 		return root
	 *	send root.lc recursively -> will give left node in return
	 *  send root.rc recursively -> will give right node in return
	 *
	 *  if left and right both not null -> return root
	 *  if left -> null return right
	 *  if right -> null return left
	 *
   */
	public Node getCommonAncestor(Node root, int a, int b){
		if (root == null) {
			return null;
		}
		if(root.data==a||root.data==b){
			return root;
		}
		Node left=getCommonAncestor(root.lc,a, b);
		Node right=getCommonAncestor(root.rc,a,b);
		if(left!=null && right!=null) return root;
		if(left==null) return right; else return left;
	}

	//finds distance from root to given data node. result distance is one less pathLength method returns
	public int pathLength(Node root, int data){
		if(root!=null){
			int pathLength=0;
			//
			if(root.data==data||(pathLength=pathLength(root.lc,data))>0||(pathLength=pathLength(root.rc,data))>0){
				return pathLength+1;
			}
			return 0;
		}
		return 0;
	}

	public int distanceBetweenTwoNode(Node root, int data1,int data2){
		if(root!=null){
			int data1DistanceFromRoot= pathLength(root,data1)-1;
			int data2DistanceFromRoot = pathLength(root, data2)-1;
			Node csaNode = getCommonAncestor(root, data1, data2);
			if(null==csaNode)return -1;
			int csaDistanceFromRoot= pathLength(root,csaNode.data)-1;
			int distance=data1DistanceFromRoot+data2DistanceFromRoot- 2* csaDistanceFromRoot;
			return distance;
		}
		return 0;
	}

	public void levelOrderTraversal(Node root,int level){
		if(root!=null && level>-1){
			if(level==0){
				System.out.print(root.data+" ");
			}
			else{
				levelOrderTraversal(root.lc, level-1);
				levelOrderTraversal(root.rc,level-1);
			}
		}
	}

	
	public void allLevelOrderTraversal(Node root){
		for(int i=0; i<getMaxDepth(root);i++){
			levelOrderTraversal(root, i);
			System.out.println("             --> Level:"+i);
		}
	}

	public int getMaxDepth(Node root){
		//return root==null ? 0: 1+Math.max(getMaxDepth(root.lc),getMaxDepth(root.rc));

		if(root==null){
			return 0;
		}
		else{
			int leftDepth=getMaxDepth(root.lc);
			int rightDepth=getMaxDepth(root.rc);
			
			if(leftDepth>rightDepth){
				return leftDepth+1;
			}
			else{
				return rightDepth+1;
			}
		}
	}

	public int getHeight(Node root){
		if(root==null||(root.lc==null && root.rc==null)){
			return 0;
		}
		return Math.max(getHeight(root.lc),getHeight(root.rc))+1;
	}

	public Node convertToDLLUtil(Node root){
		if(root==null) return root;
		if(root.lc!=null){
			Node left = convertToDLLUtil(root.lc);
			while(left.rc!=null) left=left.rc;
			left.rc=root;
			root.lc=left;
		}
		if(root.rc!=null){
			Node right = convertToDLLUtil(root.rc);
			while(right.lc!=null) right=right.lc;
			root.rc=right;
			right.lc=root;
		}
		return root;
	}

	public Node convertToDll(Node root){
		Node node = convertToDLLUtil(root);

		while (node.lc!=null){
			node=node.lc;
		}
		return node;
	}


	public void boundaryView(Node root){
		printLeftBoundary(root);
		printLeaves(root);
		printRightBoundary(root);
	}

	public void printLeftBoundary(Node root){
		if(root!=null){
			if(root.lc!=null){
				System.out.println(root.data);
				printLeftBoundary(root.lc);
			}
			else if(root.rc!=null){
				System.out.println(root.data);
				printLeftBoundary(root.rc);
			}
		}
	}
	public void printRightBoundary(Node root){
		if(root!=null){
			if(root.rc!=null){
				printRightBoundary(root.rc);
				System.out.println(root.data);
			}
			else if(root.rc!=null){
				printRightBoundary(root.lc);
				System.out.println(root.data);
			}
		}
	}

	public void printLeaves(Node root){
		if(root!=null){
			if(root.lc==null || root.rc==null){
				System.out.println(root.data);
			}
			printLeaves(root.lc);
			printLeaves(root.rc);
		}
	}

	public void connectToRightPointer(Node root){

		if(root!=null){
			Node tempLeft=root.lc;
			if(tempLeft!=null){
				if(root.rc!=null)
				tempLeft.next=root.rc;
				else{
					Node dummy=root.next;
					while(dummy.lc!=null||dummy.rc!=null){
						dummy=dummy.next;
					}
					if(dummy.lc!=null)root.lc.next=dummy.lc;
					else root.rc.next=dummy.rc;
				}

			}

			if(root.rc!=null && root.next!=null){
				root.rc.next=root.next.lc;
			}
			connectToRightPointer(root.lc);
			connectToRightPointer(root.rc);
		}
	}


	private List<Integer> treeViewList = new ArrayList<>();
	public void leftTreeView(Node root,int size){
		if(null!=root){
			if(size>=treeViewList.size()){
				treeViewList.add(root.data);
				System.out.println(root.data + " ");
				int tempSize=treeViewList.size();
				leftTreeView(root.lc,tempSize);
				leftTreeView(root.rc,tempSize);
			}
		}
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

	public Node smallestNumberNode(Node root) {
		if (root != null) {
			if (root.lc != null) {
				root = largestNumberNode(root.lc);
			} else {
				return root;
			}
		}
		return root;
	}



	/**
	 * to delete a particular number
	 * we need to search first
     */
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

/*
	public boolean isSubTree(Node parent, Node child){

	}
*/

	public Node search(Node root,int data){
		Node result=null;
		if(root!=null){
			if(data==root.data) result=root;
			else if(data>root.data){
				return search(root.rc,data);
			}
			else{
				return search(root.lc,data);
			}
			return result;
		}
		else return result;
	}

	/**
	 * if root is null -> balanced
	 *  if check abs(leftHeight - rightheight)<=1
	 * 		check recursivley
	 * else not balanced.
   	*/
	public boolean isBSTBalanced(Node root){
		if(null==root) return true;
		int leftHeight= getMaxDepth(root.lc);
		int rightHeight= getMaxDepth(root.rc);
		if(Math.abs(leftHeight-rightHeight)>1){
			return false;
		}
		else{
			return isBSTBalanced(root.lc) && isBSTBalanced(root.rc);
		}
	}


/*
	public List<Node> combinationBST(int start, int end){
		List<Node> result= new ArrayList<>();
		for(int i=start;i<end;i++){
			if(start>end){
				result.add(null);
				return result;
			}

			List<Node> left= showMessage(start,)
		}

	}
*/


public boolean pathSum(Node root, int sum, List<Node> path){
	if(root==null) { return false;}
	if(sum-root.data==0){
		if(root.lc==null && root.rc==null){
			path.add(root);
			return true;
		}
	}
	else{
		if(pathSum(root.lc,sum-root.data,path)){
			path.add(root);
			return true;
		}
		if(pathSum(root.rc,sum-root.data,path)){
			path.add(root);
			return true;
		}
	}
	return false;
}

	public void insert(Node root, int data) {
		if (data <= root.data) {
			if (root.lc != null) {
				insert(root.lc, data);
			} else {
				root.lc = new Node(data);
			}
		} else if (data > root.data) {
			if(root.rc!=null){
				insert(root.rc,data);
			}
			else{
				root.rc=new Node(data);
			}
		}
	}

	//List<Integer> preOrder = new ArrayList<>();
	public void preOrder(Node root) {
		if (root != null) {
			System.out.println(root.data);
			//preOrder.add(root.data);
			preOrder(root.lc);
			preOrder(root.rc);
		}
	}

	public void inOrder(Node root){
		if(root!=null){
			inOrder(root.lc);
			System.out.print(root.data+" ");
			inOrder(root.rc);
		}
	}

	public void inOrderIteration(Node root){
		Stack<Node> stack = new Stack<Node>();
		if(root!=null)
		stack.push(root);

		while(!stack.isEmpty()) {
			if (root != null) {
				stack.push(root);//push element in stack
				root = root.lc;//move to left
			}
			else{
				root=stack.pop();//popping is done when left has ended
				System.out.print(root.data+ " ");//print root
				root=root.rc;//move to right
			}
		}
	}

	public void preOrderIteration(Node root){
		Stack<Node> stack = new Stack<>();
		if(root!=null)
			stack.push(root);

		while (!stack.isEmpty()){
			if(root!=null){
				System.out.println(root.data);
				stack.push(root);
				root=root.lc;
			}
			else{
				Node right=stack.pop();
				root=right.rc;
			}
		}

	}

	public void postOrder(Node root){
		if(root!=null){
			postOrder(root.lc);
			postOrder(root.rc);
			System.out.println(root.data+" ");
		}
	}

	/**
	 * pass the storing	gArray size 2^(height of tree + 1) -1
	 * to contain all values including leave node's child's null value
	 *
	 * pass initial parameter pos as 0
	 */
	public void serialize(Node root,int pos,Integer [] storingArray){
		if(root==null){
			storingArray[pos]=-1;
		}
		else{
			storingArray[pos]=root.data;
			serialize(root.lc,pos*2+1,storingArray);
			serialize(root.rc,pos*2+2,storingArray);
		}
	}

	public void deserialize(Integer[] storingArray,int pos,Node node){
		if(storingArray[pos]==-1||pos>storingArray.length-1){
			node=null;
		}
		else{
			if(node==null) node = new Node(storingArray[pos]);
			deserialize(storingArray,pos*2+1,node.lc);
			deserialize(storingArray,pos*2+2,node.rc);
		}
	}

	/**
	 * make root as level 0
	 * send left to level+1 and right to level-1
	 *
	 *
	 */
	Map<Integer,Integer> levelContainer= new TreeMap<>();
	public void topViewHelper(Node root,int level){
		if(root!=null){
			if(!levelContainer.containsKey(level)){
				levelContainer.put(level,root.data);
			}

				topViewHelper(root.lc,level-1);
				topViewHelper(root.rc,level+1);
		}
	}

	public void bottomViewHelper(Node root,int level){
		if(root!=null){
//			if(!levelContainer.containsKey(level)){
				levelContainer.put(level,root.data);
//			}

			bottomViewHelper(root.lc,level-1);
			bottomViewHelper(root.rc,level+1);
		}
	}


	public void topView(Node root){
		topViewHelper(root,0);
		for(int key:levelContainer.keySet()){
			System.out.println(levelContainer.get(key)+" ");
		}
	}

	public void bottomView(Node root){
		bottomViewHelper(root,0);
		for(int key:levelContainer.keySet()){
			System.out.println(levelContainer.get(key)+" ");
		}
	}

	public int diameter(Node root){
		if(root!=null){
			int leftHeight= getMaxDepth(root.lc);
			int rightHeight = getMaxDepth(root.rc);
			int leftDiameter = diameter(root.lc);
			int rightDiameter = diameter(root.rc);
			return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
		}
		return 0;
	}

	public Node sortedArrayToBST(int[] array,int low, int high){
			if(array.length<1 ||low==high)return null;
			int mid=(low+high)/2;
			Node root=new Node(array[mid]);
			root.lc=sortedArrayToBST(array,low,mid);
			root.rc=sortedArrayToBST(array,mid+1,high);
			return root;
	}

	public int getLevel(Node root,int data){
		int level=-1;
		if(null==root){
			return level;
		}
		else{
			if(root.data==data){
				return level+1;
			}
			int leftLevel=getLevel(root.lc,data);
			int rightLevel=getLevel(root.rc,data);
			if(leftLevel>-1) return leftLevel+1;
			if(rightLevel>-1)
				return rightLevel+1;
		}
		return level;
	}

	/**
	 *
	 *
   */
	public int getLevel(Node root,int a, int level){
		if(root==null) return -1;
		if(a==root.data) return level;
		else{
			int levelLeft=getLevel(root.lc,a,level+1);
			int levelRight=getLevel(root.rc,a,level+1);
			if(levelLeft!=-1) return levelLeft;
			else return levelRight;
		}
	}



	/**
	 * if nodes are at same level and not cousin
   */
	public boolean isCousin(Node root, int a, int b){
		if(root==null) return false;
		return getLevel(root,a,0)==getLevel(root,b,0) && !isSibling(root,a,b);
	}

	public void diagonalTraversal(Node root){
		Map<Integer, Integer> map = new TreeMap<>();
		diagonalTraversalUtil(root,1,map);
		for(Integer sum:map.values()){
			System.out.println(sum);
		}
	}

	/**
	 * create a map will contain each diagonal level and level sum
	 *  when go to left pass level+1
	 *  when go to right pass level and add root.data to existing sum against that level
   */
	private void diagonalTraversalUtil(Node root,int level, Map<Integer,Integer> map){
		if(root==null){
			return;
		}
		if(root.lc!=null){
			diagonalTraversalUtil(root.lc,level+1,map);
		}

		if(!map.containsKey(level)){
			map.put(level,root.data);
		}
		else{
			map.put(level,map.get(level)+root.data);
		}
		if(root.rc!=null) {
			diagonalTraversalUtil(root.rc, level, map);
		}
	}

	private void maximumWidthUtil(Node root, int level, Map<Integer,Integer> map){
		if(root==null){
			return;
		}
		if(root.lc!=null){
			maximumWidthUtil(root.lc,level+1,map);
		}
		if(root.rc!=null){
			maximumWidthUtil(root.rc,level+1,map);
		}
		if(!map.containsKey(level)){
			map.put(level,1);
		}
		else{
			map.put(level,map.get(level)+1);
		}
	}

	public int maximumWidth(Node root){
		Map<Integer,Integer> map = new TreeMap<>();
		maximumWidthUtil(root,1,map);
		int max=0;
		for(int width:map.values()){
			if(width>max){
				max=width;
			}
		}
		return max;
	}

	public Node testUtil(Node rt){
		Node head=rt;
		while(head.lc!=null){
			head=head.lc;
		}
		return head;
	}

	public boolean isSumTree(Node root,SumTreeSum treeSum){
		if(root==null){
			return true;
		}
		if(root.lc==null && root.rc==null){
			treeSum.sum=root.data;
			return true;
		}
		SumTreeSum leftSum=new SumTreeSum(0);
		SumTreeSum rightSum=new SumTreeSum(0);
		if(isSumTree(root.lc,leftSum) && isSumTree(root.rc,rightSum)) {
			treeSum.sum = leftSum.sum + rightSum.sum;
			if (root.data == treeSum.sum) {
				return true;
			}
		}
		return false;
	}

	public Node test(Node rt,Node prev){
		if(rt==null){
			return null;
		}
		/*if(head==null){
			head=rt;
			while(rt.lc!=null){
				head=head.lc;
			}
		}*/
		Node left= test(rt.lc,rt);
		Node right= test(rt.rc,rt);
		if(left==null && right==null){
			return rt;
		}
		else if(left!=null){
			left.rc=rt;
			rt.lc=left;
		}
		if(right!=null){
			rt.rc=right;
			right.lc=rt;
		}
		if(rt==prev){return rt;}
		if(rt.data<prev.data){
			if(right!=null){return right;}
			else{ return rt;}
		}
		else{
			if(left!=null){
				return left;
			}
			else{
				return rt;
			}
		}
	}

	public Node createBinaryTreeUsingInorderPreorder(int[] in,int[] pre){
		Node root= createBinaryTreeUsingInorderPreorderUtil(in, pre, 0,in.length-1);
		return root;
	}
	//private int index=0;
	public Node createBinaryTreeUsingInorderPreorderUtil(int[] in, int[] pre, int start, int end){
		if(start>end){
			return null;
		}
		int foundPlace=start;
		for(int i=start;i<end;i++){
			if(pre[index]==in[i]){
				foundPlace=i;
				break;
			}
		}
		Node root= new Node(pre[index]);
		index++;
		root.lc=createBinaryTreeUsingInorderPreorderUtil(in,pre,start,foundPlace-1);
		root.rc = createBinaryTreeUsingInorderPreorderUtil(in, pre, foundPlace + 1, end);
		return root;
	}


	public int nodeHavingKLeaves(Node root,int k){
		if(root==null){
			return 0;
		}
		if(root.lc==null && root.rc==null){
			return 1;
		}
		int left=nodeHavingKLeaves(root.lc,k);
		int right=nodeHavingKLeaves(root.rc,k);
		if(left+right==k){
			System.out.println(root.data);
		}
		return left+right;
	}

	public int maximumLevelSum(Node root){
		Map<Integer,Integer> map= new HashMap<>();
		maximumLevelSumUtil(root,map,0);
		return Collections.max(map.values());
	}

	public void maximumLevelSumUtil(Node root, Map<Integer,Integer> map, int level){
		int currentSum=-1;
		if(root!=null){
			if(map.containsKey(level)){
				currentSum=map.get(level)+root.data;
				map.put(level,currentSum);
			}
			else{
				map.put(level, root.data);
			}
			maximumLevelSumUtil(root.lc,map,level+1);
			maximumLevelSumUtil(root.rc,map,level+1);
		}
	}

	public void similarPair(Node root, int arr[], int index,int diff){
		if(root!=null){
			arr[index]=root.data;
			for(int i=0;i<index;i++){
				if(Math.abs(arr[i]-arr[index])<=diff){
					System.out.println(arr[i]+","+arr[index]);
				}
			}
			similarPair(root.lc,arr,index+1,diff);
			similarPair(root.rc,arr,index+1,diff);
		}
	}
	int maxDiff=0;
	public void maxDiffBetweenAncestorAndNode(Node root,List<Integer> list, int index){
		if(root!=null){
			list.add(root.data);
			for(int i=0;i<index;i++){
				maxDiff=Math.max(Math.abs(list.get(i)-list.get(index)),maxDiff);
			}
			maxDiffBetweenAncestorAndNode(root.lc,list,index+1);
			if(root.lc!=null) list.remove(index+1);
			maxDiffBetweenAncestorAndNode(root.rc,list,index+1);
			if(root.rc!=null)list.remove(index+1);
		}
	}

	public void printKNodeBeforeLeaf(Node root,int distance,int current,List<Integer> list){
		if(root.lc!=null||root.rc!=null){
			list.add(current,root.data);
			printKNodeBeforeLeaf(root.lc,distance,current+1,list);
			printKNodeBeforeLeaf(root.rc,distance,current+1,list);
		}
		else{
			if(current-distance>=0 && list.size()>=distance){
				System.out.println(list.get(current-distance));
			}
		}
	}

	/**
	 * take preorder and inOrder of main string
	 * take preorder and inorder of sub string
	 *
	 * check if main String's preorder contains preOrder of subString
	 *
	 *
   */
	public boolean isSubTree(Node main,Node sub){
		StringBuilder mainInOrder = new StringBuilder();
		StringBuilder mainPreOrder = new StringBuilder();
		StringBuilder subInOrder = new StringBuilder();
		StringBuilder subPreOrder = new StringBuilder();

		stringInOrder(main,mainInOrder);
		stringInOrder(sub,subInOrder);
		stringPreOrder(main,mainPreOrder);
		stringPreOrder(sub,subPreOrder);

		return mainInOrder.toString().contains(subInOrder.toString()) &&
				mainPreOrder.toString().contains(subPreOrder.toString());

	}

	public void stringInOrder(Node root,StringBuilder sb){
		if(root!=null){
			stringInOrder(root.lc,sb);
			sb.append(root.data);
			stringInOrder(root.rc, sb);
		}
		else{
			sb.append("%");
		}
	}
	public void stringPreOrder(Node root,StringBuilder sb){
		if(root!=null){
			sb.append(root.data);
			stringPreOrder(root.lc,sb);
			stringPreOrder(root.rc, sb);
		}
		else{
			sb.append("%");
		}
	}


	/**
	 *	just do the preorder traversal and
	 *	when you find the node is null just add -1 as a marker.
	 */
	public void getSerialized(Node root, List<Integer> list){
		if(root==null){
			list.add(-1);
		}
		else{
			list.add(root.data);
			getSerialized(root.lc,list);
			getSerialized(root.rc,list);
		}
	}

	/**
	 * as we know if there's -1 at arraylist index it must be null
	 * or index is at end of the arraylist
	 *
	 * so, from root
	 * step 1: create a node and do recursion to left by sending the left child.
	 * step 2: same do for the right child for the recursion
	 *
	 * doing step1 and step2, we need to increment the index(should be global)
	 * and at end return the root
	 *
	 */
	static int dIndex=0;
	public Node getDeserialized(List<Integer> list){
		Node root=null;
		if(dIndex==list.size()||list.get(dIndex)==-1){
			return root;
		}
		else{
			root= new Node(list.get(dIndex));
			++dIndex;
			root.lc= getDeserialized(list);
			++dIndex;
			root.rc= getDeserialized(list);
		}
		return root;
	}

	public Node convertToMirrorInPlace(Node root){
		if(root!=null){
			convertToMirrorInPlace(root.lc);
			connectAtSameLevelNode(root.rc);
			Node temp=root.lc;
			root.lc=root.rc;
			root.rc=temp;
		}
		return root;
	}

	public Node getPredecessor(Node root, Node predecessor, int data) {
		if (root != null){
			if (root.data == data) {
				if (root.lc != null) {
					predecessor = largestNumberNode(root.lc);
				}
				return predecessor;
				//successor=smallestNumberNode(root.rc);
			}
			if (data < root.data) {    //going left set successor = root
				return getPredecessor(root.lc, predecessor, data);
			} else {
				predecessor = root;//going right set predecessor to left
				return getPredecessor(root.rc, predecessor, data);
			}
		}
		else return null;
	}
	public Node getSuccessor(Node root, Node successor, int data) {
		if (root != null){
			if (root.data == data) {
				// if right is not null find smallest on  left of left sub tree
				if (root.rc != null) {
					successor = smallestNumberNode(root.rc);
				}
				//if right is null it means succesor already set
				return successor;
			}
			if (data < root.data) {    //going right set successor = root
				successor=root;
				return getSuccessor(root.lc, successor, data);
			} else {
				return getSuccessor(root.rc, successor, data);
			}
		}
		else return null;
	}

	public boolean rectify(Node root,Node prevRoot,Node wrongNode,boolean firstNodeSide){
		if(root!=null){
			return true;
		}

		if(root.lc!=null){
			if(root.lc.data>root.data){
				if(wrongNode!=null){
					Node temp=root.lc;
					if(firstNodeSide){
						root.lc=prevRoot.rc;
						prevRoot.rc=temp;
					}
					else{
						root.lc=prevRoot.lc;
						prevRoot.lc=temp;
					}
				}
				else{
					wrongNode=root.lc;
					prevRoot=root;
					firstNodeSide=false;//false for left
				}

			}
		}
		if(root.rc!=null){
			if(root.rc.data<root.data){
				if(wrongNode!=null){
					Node temp=root.rc;
					if(firstNodeSide){
						root.rc=prevRoot.rc;
						prevRoot.rc=temp;
					}
					else{
						root.rc=prevRoot.lc;
						prevRoot.lc=temp;
					}
				}
				else {

					wrongNode = root.rc;
					prevRoot = root;
					firstNodeSide = true;//true for right
				}
			}
		}
		rectify(root.lc,prevRoot,wrongNode,firstNodeSide);
		rectify(root.rc,prevRoot,wrongNode,firstNodeSide);
		return false;
	}







	public static void main(String[] args) {
/*
		tree.BST bst= new tree.BST();
		tree.Node root= bst.getBST();
		bst.allLevelOrderTraversal(root);
		System.out.println(bst.isSibling(root, 19, 20));

		System.out.println(bst.getCommonAncestor(root, 20, 60).data);

		System.out.println("Is Bst: "+bst.isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE));

		System.out.println("Is tree.BST: "+bst.isBST(bst.getBSTSample(),Integer.MIN_VALUE,Integer.MAX_VALUE));
		System.out.println(bst.pathLength(root,65));

		System.out.println("Distance between two nodes:"+bst.distanceBetweenTwoNode(root,19,45));
		System.out.println("CAN:"+bst.getCommonAncestor(root,65,20).data);

		System.out.println("isMirrorTree:"+bst.isMirrorTree(bst.getBST(),bst.getMirroredBST()));
		//System.out.print("bstToDll"+bst.convertToDll(bst.getBST()));
		System.out.println("BstToDll :");
		tree.Node node=bst.convertToDll(bst.getBST());
		while(node!=null){
			System.out.print(node.data+",");
			node=node.rc;
		}
		bst.levelOrderTraversal(bst.getBST());
		System.out.println("Level order traversal");
		while(!bst.nodeQueue.isEmpty()){
			System.out.println(bst.nodeQueue.remove().data);
		}
*/
/*
		BST bst = new BST();
		Node root= new Node(9);
		bst.insert(root,8);
		bst.insert(root,7);
		bst.insert(root,1);
		//bst.insert(root,2);
		bst.insert(root,2);
		bst.insert(root,3);
		bst.insert(root,4);
*/
//		List<Node> list= new ArrayList<Node>();
		/*bst.pathSum(root,12,list);
		for(Node node:list){
			System.out.println(node.data +",");
		}*/
		//System.out.println(bst.getCommonAncestorBT(root,0,1).data);
/*
		System.out.println("Tree balanced:"+bst.isBSTBalanced(root));
		int noOfNodes=(int)Math.pow(2,bst.getMaxDepth(root)+1)-1;
		Integer[] storingArray= new Integer[noOfNodes];
		bst.serialize(root,0,storingArray);
		for(Integer element:storingArray){
			System.out.println(element);
		}

		Node x=new Node(storingArray[0]);
		bst.deserialize(storingArray,0,x);
		bst.inOrder(x);
*/
		//bst.leftTreeView(root,0);
		//bst.zigZagTraversal(root,1);
		//bst.levelOrderTrav(root);
		/*while(!bst.nodeQueue.isEmpty()){
			System.out.println(bst.nodeQueue.remove().data);
		}*/

		//bst.boundaryView(root);
//		System.out.println(bst.isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
/*
		int arr[] = {0,1,2,3,4,5,6};
		Node route=
				bst.sortedArrayToBST(arr,0,arr.length);
		bst.inOrder(route);
*/
//bst.inOrderIteration(root);
		//bst.topView(root);
//		bst.bottomView(root);
		//for(int i=0;i<8;i++)
		//System.out.println("data:"+i+"level:"+bst.getLevel(root,i,0));
		//System.out.println(bst.diameter(root));
		//System.out.println(bst.isCousin(root,0,6));
		//bst.diagonalTraversal(root);
		//System.out.println(bst.maximumWidth(root));
		//bst.levelOrderTraversal(root);
/*
		Node head=bst.testUtil(bst.test(root, root));
		while(head!=null){
			System.out.println(head.data);
			head=head.rc;
		}
*/

		BST bst= new BST();
//		tree.Node root= bst.getBST();
		//bst.allLevelOrderTraversal(root);
		//System.out.println(bst.isSibling(root, 55, 65));
//		bst.inOrder(root);
//		bst.preOrder(root);

/*
		Node root=bst.createBinaryTreeUsingInorderPreorder(bst.inOrder, bst.preOrder);
		bst.inOrder(root);
		bst.preOrder(root);
*/

		//System.out.println(bst.isSumTree(main,new SumTreeSum(0)));
/*
		StringBuilder ssb = new StringBuilder();
		bst.getSerialized(main,ssb);
*/

//		bst.serializeBT(main,ssb);
/*
		System.out.println(ssb.toString());

		bst.zigzag(main);
*/
		/*Node sub= new Node();
		sub.data=0;
		sub.lc=new Node(0);
		sub.rc=new Node(2);
		System.out.println(bst.isSubTree(main,sub));
*/
//		System.out.println(bst.getLevel(main,7));
		Node main=bst.getBSTSample();
		for(int i=0;i<8;i++) {
			Node pred = bst.getSuccessor(main, null, i);
			if (pred != null) {
				System.out.println(i+": "+pred.data);
			}
			else{
				System.out.println(i+": null");
			}
		}
/*		Node rt= new Node(3);
		rt.lc= new Node(2);
		rt.rc= new Node(1);
		rt.rc.rc= new Node(5);
		rt.rc.lc= new Node(4);*/
//		bst.deleteNode(main,2);
		//bst.printKNodeBeforeLeaf(main,1,0,new ArrayList<>());
		//bst.nodeHavingKLeaves(main,2);
		//System.out.println(bst.maximumLevelSum(main));

//		bst.similarPair(rt,new int[10],0,2);
/*
		bst.maxDiffBetweenAncestorAndNode(main,new ArrayList<>(),0);
		System.out.println(bst.maxDiff);
*/
		//bst.preOrderIteration(main);

/*
		List<Integer> list = new ArrayList<>();
		bst.getSerialized(main,list);
		System.out.println(list);

		Node tMain=bst.getDeserialized(list);
		bst.preOrder(tMain);
*/
/*
		bst.connectAtSameLevelNode(main);

		Node temp=main.lc.lc;
	while(temp!=null){
			System.out.println(temp.data);
			temp=temp.next;
		}
*/
/*
		bst.preOrder(main);
		System.out.println();
		Node x=bst.convertToMirrorInPlace(main);
		bst.preOrder(x);
*/
	}



	public Node getBST(){
		BST bst = new BST();
		Node root= new Node(45);
		bst.insert(root, 20);
		bst.insert(root, 60);
		bst.insert(root, 21);
		bst.insert(root, 19);
		bst.insert(root, 55);
		bst.insert(root, 65);
		return root;
	}

	public Node getMirroredBST(){
		Node root= new Node(45);
		root.lc=new Node(60);
		root.rc=new Node(20);
		root.lc.lc= new Node(65);
		root.lc.rc = new Node(55);
		root.rc.lc= new Node(21);
		root.rc.rc= new Node (19);
		return root;
	}

	public Node getSumTree(){
		Node root= new Node(12);
		root.lc=new Node(2);
		root.rc=new Node(10);
		root.lc.lc=new Node(0);
		root.lc.rc=new Node(2);
		root.rc.lc= new Node(4);
		root.rc.rc=new Node(6);
		return root;
	}
	public Node getBSTSample(){
		Node root= new Node(3);
		root.lc=new Node(1);
		root.rc=new Node(5);
		root.lc.lc=new Node(0);
		root.lc.rc=new Node(2);
		root.rc.lc= new Node(4);
		root.rc.rc=new Node(6);
		return root;
	}

	public void serializeBT(Node root,StringBuilder sb){
		if(root==null){
			sb.append("%,");
			return;
		}
		sb.append(root.data).append(",");
		serializeBT(root.lc, sb);
		serializeBT(root.rc, sb);
	}

	//int index=0;
	public Node deserialize(Node root,String[] sb) {
		if(index<sb.length){
			if(sb[index].equals("%")){
				root=null;
				index++;
				return root;
			}
			else{

			}
		}
		return null;
	}

	public void getSerialized(Node node,StringBuilder sb){
		if (node == null) {
			sb.append("%,");
		}
		sb.append(node.data).append(",");
		if (node.lc != null || node.rc != null) {
			sb.append("$,");
			getSerialized(node.lc,sb);
			getSerialized(node.rc, sb);
		}
	}
	int index=0;
	public Node getDeserialized(String data){
		if("".equals(data)||null==data){
			return null;
		}
		String[] elements=data.split(",");
		if(elements.length>0){


		}

		return null;
	}


	public void connectAtSameLevelNode(Node root){
		if(root==null){
			return;
		}
		if(root.lc!=null && root.rc!=null){
			root.lc.next=root.rc;
		}

		if(root.lc!=null && root.rc==null){
			Node neighbour= root.next;
			while(neighbour!=null){
				if(neighbour.lc!=null){
					root.lc.next=neighbour.lc;
				}
				else if(neighbour.rc!=null){
					root.lc.next=neighbour.rc;
				}
			}
		}
		if(root.rc!=null && root.lc==null){
			Node neighbour= root.next;
			while(neighbour!=null){
				if(neighbour.lc!=null){
					root.rc.next=neighbour.lc;
				}
				else if(neighbour.rc!=null){
					root.rc.next=neighbour.rc;
				}
				neighbour=neighbour.next;
			}
		}
		connectAtSameLevelNode(root.rc);
		connectAtSameLevelNode(root.lc);
	}

	public void connectSameLevelNode(Node root){
		if(root==null){
			return;
		}
		if(root.lc!=null){
			if(root.rc!=null){
				root.lc.next=root.rc;
			}
			else{
				root.lc.next=root.next!=null && root.next.lc!=null ? root.next.lc:root.next.rc;
			}
		}
		else if(root.rc!=null){
			root.rc.next=root.next!=null && root.next.lc!=null ? root.next.lc:root.next.rc;
		}
		connectSameLevelNode(root.lc);
		connectSameLevelNode(root.rc);
	}
}

class SumTreeSum{
	public SumTreeSum(int sum){
		this.sum=sum;
	}
	int sum;
}