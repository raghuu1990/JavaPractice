package com.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class UndirectedGraph {
	int V;
	LinkedList<Integer>[] adj;

	@SuppressWarnings("unchecked")
	public UndirectedGraph(int V) {
		this.V = V;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}

	// For connected graphs only
	public void BFS(int v) {
		boolean[] visited = new boolean[V];
		System.out.println("Breadth First Traversal (starting from vertex "+ v +"): ");
		BFS(v, visited);
	}

	// For non connected graphs
	public void BFS() {
		boolean[] visited = new boolean[V];
		System.out.println("Breadth First Traversal for non connected (starting from vertex 0): ");
		for (int i = 0; i < V; ++i) {
			if (!visited[i]) {
				BFS(i, visited);
			}
		}
	}

	private void BFS(int v, boolean[] visited) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited[v] = true;
		q.add(v);

		while (!q.isEmpty()) {
			v = q.poll();
			System.out.print(v + " ");
			Iterator<Integer> itr = adj[v].listIterator();
			while (itr.hasNext()) {
				int t = itr.next();
				if (!visited[t]) {
					visited[t] = true;
					q.add(t);
				}
			}
		}
	}

	// For connected graphs only
	public void DFS(int v) {
		boolean[] visited = new boolean[V];
		System.out.println("Depth First Traversal (starting from vertex "+ v +"): ");
		DFS(v, visited);
	}
		
	// For non connected graphs
	public void DFS() {
		boolean[] visited = new boolean[V];
		System.out.println("Depth First Traversal (starting from vertex 0): ");
		for (int i = 0; i < V; ++i) {
			if (!visited[i]) {
				DFS(i, visited);
			}
		}
	}

	private void DFS(int i, boolean[] visited) {
		visited[i] = true;
		System.out.print(i + " ");
		Iterator<Integer> itr = adj[i].listIterator();
		while (itr.hasNext()) {
			int t = itr.next();
			if (!visited[t]) {
				DFS(t, visited);
			}
		}
	}

	public boolean isCyclicUDG1() {
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				if (ifCycleUDG1(i, visited, -1)) {
					return true;
				}
			}
		}
		return false;
	}

	// O(V+E) : For every visited vertex ‘v’, if there is an adjacent ‘u’ such that
	// u is already visited and u is not parent of v, then there is a cycle in graph.
	private boolean ifCycleUDG1(int v, boolean[] visited, int parent) {
		visited[v] = true;
		
		Iterator<Integer> itr = adj[v].listIterator();
		while (itr.hasNext()) {
			int t = itr.next();
			if (!visited[t]) {
				if (ifCycleUDG1(t, visited, v)) {
					return true;
				}
			} else if (t != parent) {
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
}