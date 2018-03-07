package com.prem.graph;

import java.util.ArrayList;
import java.util.List;

public class GNode<T> implements Comparable<T> {

	private T data;
	private boolean visited;
	//containing all adjacent nodes/vertices
	private List<GNode<T>> vertices = new ArrayList<GNode<T>>();

	/**
	 * @param startNode = node from where you'll start to traverse
	 * @param addToVertice = node to which you want to add new node
	 * @param dataNode = data you want to feed in new node to be created.
	 */
	public void addNode(GNode<T> startNode, T addToVertice, GNode<T> dataNode) {
		if (startNode != null) {
			//check if this node is targetNode, if it is then add newNode to its adjacent node.
			if (startNode.data.equals(addToVertice)) {
				addNodeAtGivenNode(startNode, dataNode);
			}
			//traverse each and every node in depth one by one
			else {
				for (GNode<T> node : startNode.vertices) {
					//call recursively next child node.
					addNode(node, addToVertice, dataNode);
				}
			}
		}
	}

	/**
	 * Add a new adjacent node to given node.
	 * @param node
	 * @param dataNode
	 */
	public void addNodeAtGivenNode(GNode<T> node, GNode<T> dataNode) {
		node.vertices.add(dataNode);
	}

	public GNode<Integer> getIntegerGraph() {
		GNode<Integer> start = new GNode<>(4);
		start.addNode(start, 4, new GNode<>(1));
		start.addNode(start, 4, new GNode<>(2));
		start.addNode(start, 4, new GNode<>(3));
		start.addNode(start, 1, new GNode<>(6));
		start.addNode(start, 3, new GNode<>(5));
		start.addNode(start, 5, new GNode<>(8));

		return start;
	}

	public GNode<Integer> getCycledIntegerGraph() {
		GNode<Integer> start = new GNode<>(4);
		start.addNode(start, 4, new GNode<>(1));
		start.addNode(start, 4, new GNode<>(2));
		start.addNode(start, 4, new GNode<>(3));
		start.addNode(start, 1, new GNode<>(6));
		start.addNode(start, 3, new GNode<>(5));
		start.addNode(start, 5, new GNode<>(8));
		start.addNode(start, 8,start);

		return start;
	}

	public static void main(String[] args) {
		GNode<Integer> start = new GNode<>(4);
		start.addNode(start, 4, new GNode<>(1));
		start.addNode(start, 4, new GNode<>(2));
		start.addNode(start, 4, new GNode<>(3));
		start.addNode(start, 1, new GNode<>(6));
		start.addNode(start, 3, new GNode<>(5));
		start.addNode(start, 5, new GNode<>(8));


	}

	public int compareTo(T value) {
		if (value instanceof Integer) {
			return (int) ((Integer) this.data - (Integer) value);
		} else if (value instanceof String) {
			return this.data.toString().compareTo(value.toString());
		} else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object data) {
		if (this.data instanceof Integer) {
			return ((int) (Integer) this.data == (int) (Integer) data);
		}
		if (this.data instanceof String) {
			return this.data.toString().equals(data);
		}
		return this.data.equals(data);
	}
	
	public GNode() {
	}

	public GNode(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<GNode<T>> getVertices() {
		return vertices;
	}

	public void setVertices(List<GNode<T>> vertices) {
		this.vertices = vertices;
	}
}