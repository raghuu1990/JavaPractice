package com.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem

public class ShortestReachInAGraph {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        for (int t = 0; t < queries; t++) {
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                graph.addEdge(u, v);
            }
            
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);
            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();            
        }
        scanner.close();
    }

	public static class Graph {
        int size;
        LinkedList<Integer>[] list;
        public Graph(int size) {
            this.size = size;
            list = new LinkedList[size];
            for(int i =0; i<size ;i++){
                list[i] = new LinkedList<Integer>();
            }
        }

        public void addEdge(int first, int second) {
            list[first].add(second);
        }
        
        public int[] shortestReach(int startId) {
        	int[] dis = new int[this.size];
        	boolean[] visited = new boolean[size];
        	int d = 1;
        	Arrays.fill(dis, -1);
        	Arrays.fill(visited, false);
        	dis[startId] = 0;
        	visited[startId] = true;
        	
        	Queue<Integer>  queue = new LinkedList<Integer>();
        	queue.add(startId);
        	while(!queue.isEmpty()) {
        		int u = queue.poll();
        		for (int i : list[u]) {
        			if(!visited[i]) {
	        			dis[i] = dis[u]+1;
	        			visited[i] = true;
	        			queue.add(i);
        			}
				}
        	}
        	return dis;
        }
    }
}