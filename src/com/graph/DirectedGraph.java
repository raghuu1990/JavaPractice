package com.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
Following is Breadth First Traversal (starting from vertex 0): 
0 1 5 7 2 6 8 3 4 9 10 
0 1 5 7 2 6 8 3 
*/
class DirectedGraph {
	int V;
	LinkedList<Integer>[] adj;

	@SuppressWarnings("unchecked")
	public DirectedGraph(int V) {
		this.V = V;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int u, int v) {
		adj[u].add(v);
	}

	public boolean isCyclicUDG1() {
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				if (isCycleUDG1(i, visited, -1)) {
					return true;
				}
			}
		}
		return false;
	}

	// O(V+E) : For any visited vertex ‘u’, if there is an adjacent ‘v’ such that
	// v is already visited and v is not parent of u, then there is a cycle in graph.
	private boolean isCycleUDG1(int u, boolean[] visited, int parent) {
		visited[u] = true;
		
		Iterator<Integer> itr = adj[u].listIterator();
		while (itr.hasNext()) {
			int v = itr.next();
			if (!visited[v]) {
				if (isCycleUDG1(v, visited, u)) {
					return true;
				}
			} else if (v != parent) {
				return true;
			}
		}
		return false;
	}

	// For DG
	public boolean isCyclicDG1() {
		boolean[] visited = new boolean[V];
		boolean[] stack = new boolean[V];
		for (int i = 0; i < V; i++) {
			visited[i] = false;
			stack[i] = false;
		}

		for (int i = 0; i < V; i++) {
			if (isCyclicDG1(i, visited, stack)) {
				return true;
			}
		}
		return false;
	}

	private boolean isCyclicDG1(int v, boolean[] visited, boolean[] stack) {
		if (!visited[v]) {
			visited[v] = true;
			stack[v] = true;
			Iterator<Integer> itr = adj[v].listIterator();
			while (itr.hasNext()) {
				int t = itr.next();
				if (!visited[t] && isCyclicDG1(t, visited, stack)) {
					return true;
				}else if(stack[t]) {
					return true;
				}
			}
		}
		stack[v] = false;
		return false;
	}
	
	public boolean isCyclicDGColor() {
        Color[] color = new Color[V];
        for(int i=0; i<V; i++) {
            color[i] = Color.WHITE;
        }
        
        for(int i=0; i<V; i++) {
            if(color[i]==Color.WHITE){
                if(isCyclicDGColor(i, color)) {
                	return true;
                }
            }
        }
    
        return false;
    }
    
	private boolean isCyclicDGColor(int v, Color[] color) {
		color[v] = Color.GRAY;
		Iterator<Integer> itr = adj[v].listIterator();
		while(itr.hasNext()){
			int t = itr.next();
			if(color[t]==Color.WHITE) {
				if(isCyclicDGColor(t, color)) {
					return true;
				}
			}else if(color[t]==Color.GRAY) {
				return true;
			}
		}
		color[v] = Color.BLACK;
		return false;
    }

	// for DAG
	// Topological Sorting for a graph is not possible if the graph is not a DAG.
	// There can be more than one topological sorting for a graph.
	// The first vertex in topological sorting is always a vertex with in-degree as 0 (a vertex with no in-coming edges).
	public void topologicalSort() {
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			visited[i] = false;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				topologicalSort(i, visited, stack);
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}

	public void topologicalSortCharPrint() {
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			visited[i] = false;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				topologicalSort(i, visited, stack);
			}
		}
		while(!stack.isEmpty()) {
			System.out.print((char)(stack.pop()+'a'));
		}
	}

	private void topologicalSort(int i, boolean[] visited, Stack<Integer> stack) {
		visited[i] = true;
		Iterator<Integer> itr = adj[i].listIterator();
		while(itr.hasNext()) {
			int t = itr.next();
			if(!visited[t]) {
				topologicalSort(t, visited, stack);
			}
		}
		stack.add(i);
	}
	
	// for DAG
	public void kahnsTopologicalSort() {
		int inBound[] = new int[V];
		for (int i = 0; i < V; i++) {
			inBound[i] = 0;
		}
		
		for (int i = 0; i < V; i++) {
			Iterator<Integer> itr = adj[i].listIterator();
			// set inbound for des not src
			while(itr.hasNext()) {
				inBound[itr.next()] += 1;
			}
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < V; i++) {
			if(inBound[i]==0) {
				q.add(i);
			}
		}
		
		int counter = 0;
		Queue<Integer> result = new LinkedList<Integer>();
		while(!q.isEmpty()) {
			int t = q.poll();
			result.add(t);
			counter++;

			Iterator<Integer> itr = adj[t].listIterator();
			while(itr.hasNext()) {
				int j = itr.next();
				if(--inBound[j]==0) {
					q.add(j);
				}
			}
		}
	
		if(counter!=V) {
			System.out.println("There is cycle");
			return;
		}
		
		while(!result.isEmpty()) {
			System.out.print(result.poll()+" ");
		}
	}
	
	public void kahnsTopologicalSortAll() {
		boolean[] visited = new boolean[V] ;
		LinkedList<Integer> resultList = new LinkedList<Integer>();
		int inBound[] = new int[V];
		for (int i = 0; i < V; i++) {
			inBound[i] = 0;
		}

		for (int i = 0; i < V; i++) {
			Iterator<Integer> itr = adj[i].listIterator();
			// set inbound for des not src
			while (itr.hasNext()) {
				inBound[itr.next()]++;
			}
		}
		kahnsTopologicalSortAll(visited, inBound, resultList);
	}

	public void kahnsTopologicalSortAll(boolean[] visited, int inBound[], LinkedList<Integer> resultList) {
		boolean flag = false; 
		for (int i = 0; i < V; i++) {
			if (inBound[i] == 0 && !visited[i]) {
				Iterator<Integer> itr = adj[i].listIterator();
				while (itr.hasNext()) {
					--inBound[itr.next()];
				}

				resultList.add(i);
				visited[i] = true;
				kahnsTopologicalSortAll(visited, inBound, resultList);
				resultList.remove(resultList.size()-1);
				visited[i] = false;

				itr = adj[i].listIterator();
				while (itr.hasNext()) {
					++inBound[itr.next()];
				}
				flag = true; 
			}
		}
		if(!flag) {
			Iterator<Integer> itr = resultList.iterator();
			while (itr.hasNext()) {
				System.out.print(itr.next() + " ");
			}
			resultList = new LinkedList<Integer>();
			System.out.println();
		}
	}
}