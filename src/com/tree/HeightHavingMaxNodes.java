package com.tree;

import java.util.HashMap;
import java.util.Map;

import com.node.TreeNode;

public class HeightHavingMaxNodes {

	/*
	 *		1 
	 *	   / \ 
	 *    2   3
	 *   / \   \
	 *  4   5 	8
	 *       \ 
	 *        6 
	 *         \ 
	 *          7
	 */
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, new TreeNode(6, null, new TreeNode(7, null, null)))),
				new TreeNode(3, null, new TreeNode(8, null, null)));
		printMaxlavel(root);
	}
	
	
	public static void printMaxlavel(TreeNode root){
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    processTree(root, 1, map);
	    
	    int maxKey = -1;
	    int maxValue = -1;
	    
	    for(Integer key : map.keySet()){
	    	if(map.get(key)>maxValue) {
	    		maxKey = key;
	    		maxValue = map.get(key);
	    	}
	    }
	    
	    if(maxValue>0) {
	    	System.out.println("Height : " + maxKey+", Nodes : "+maxValue );
	    }else {
	    	System.out.println("");
	    }
	}

	public static void processTree(TreeNode root, int height, Map<Integer, Integer> map){
	    if(root==null){
	        return;
	    }
	    
	    if(map.containsKey(height)){
	        map.put(height, map.get(height)+1);
	    }else{
	        map.put(height,1);
	    }
	    
	    // Left
	    processTree(root.left, height+1, map);
	    
	    // Right
	    processTree(root.right, height+1, map);
	}
}
