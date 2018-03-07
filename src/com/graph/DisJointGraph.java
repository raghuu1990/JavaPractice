package com.graph;

class DisJointGraph {
    int V;
    int E;
    Edge edge[];

    class Edge {
        int src, dest;
    };
    
    class SubSet {
        int parent, rank;
    };

    public DisJointGraph(int V, int E) {
        this.V = V;
        this.E = E;
        edge = new Edge[E];
        for (int i = 0; i < E; i++) {
            edge[i] = new Edge();
        }
    }

    // A utility function to find the subset of an element i
    public int find(SubSet[] subset, int i) {
        if (subset[i].parent == i) {
            return i;
        }
        return find(subset, subset[i].parent);
    }
    
    public int find(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }

    // A utility function to do union of two subsets
    public void union(SubSet[] subset, int x, int y) {
        int parent_x = find(subset, x);
        int parent_y = find(subset, y);
        
        if(subset[parent_x].rank>subset[parent_y].rank) {
            subset[parent_y].parent = parent_x;
        }else if(subset[parent_x].rank<subset[parent_y].rank) {
            subset[parent_x].parent = parent_y;
        }else {
            subset[parent_y].parent = parent_x;
            subset[parent_y].rank++;
        }
    }
    
    
    public void union(int[] parent, int x, int y) {
        int parent_x = find(parent, x);
        int parent_y = find(parent, y);
        parent[parent_y] = parent_x;
    }

//------------------------------------------------------------------------------------------------------------------//
    // O(Logn) 
    public boolean isCycleUsingRank() {
        SubSet[] subset = new SubSet[V];
        for (int i = 0; i < V; i++) {
            subset[i] = new SubSet();
            subset[i].parent = i;
            subset[i].rank = 0;
        }

        for (int i = 0; i < E; i++) {
            int x = find(subset, edge[i].src);
            int y = find(subset, edge[i].dest);

            if (x == y) {
                return true;
            }
            union(subset, x, y);
        }
        return false;
    }

    // O(n)
    public boolean isCycle() {
        int[] parent = new int[V];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }

        for (int i = 0; i < E; i++) {
            int x = find(parent, edge[i].src);
            int y = find(parent, edge[i].dest);

            if (x == y) {
                return true;
            }
            union(parent, x, y);
        }
        return false;
    }
//------------------------------------------------------------------------------------------------------------------//
}