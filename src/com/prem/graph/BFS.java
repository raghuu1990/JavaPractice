package com.prem.graph;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author lovebharti
 * traversal of graph using graph.BFS needs a queue
 *
 * get startNode check if it's not null
 * 	if not visited then add to queue and set to visited.
 *
 * 	Now get startNode's all child vertices
 * 		set it visited and add it to queue.
 *
 *  remove queue's first data and display it
 *  check if still queue have data, set start node as queue new head data.
 *  and do recursion until queue size become 0
 */
public class BFS<T> {
	private Queue<GNode<T>> queue;

	public void traverseWithLoop(GNode<T> startNode){
		if(startNode!=null){//it means there's one node at least to visit
			do{
				if(!startNode.isVisited()){
					queue.add(startNode);
					startNode.setVisited(true);
				}
				List<GNode<T>> vertices = startNode.getVertices();
				for(GNode<T> node: vertices){
					if(!node.isVisited()){
						node.setVisited(true);
						queue.add(node);
					}
				}
				System.out.println(queue.remove().getData());
				if(queue.size()>0) startNode=queue.peek();
			}while (queue.size()>0);
		}
	}


	public void traverse(GNode<T> startNode){
		if(startNode!=null){
			if(!startNode.isVisited()){
				queue.add(startNode);
				startNode.setVisited(true);
			} 
			List<GNode<T>> vertices = startNode.getVertices();
			if(vertices.size()>0)
				for(GNode<T> node: vertices){
					if(!node.isVisited()){
						node.setVisited(true);
						queue.add(node);
					}
				}
			
			System.out.println(queue.remove().getData());
			if(queue!=null)
				traverse(queue.peek());
		}
	}

	public static void main(String[] args) {
		GNode<Integer> graph= new GNode<Integer>();
		GNode<Integer> startNode=graph.getIntegerGraph();
		BFS<Integer> bfs= new BFS<Integer>();
		bfs.traverseWithLoop(startNode);
	}
	
	public BFS() {
		queue= new ConcurrentLinkedDeque<GNode<T>>();
	}
}

