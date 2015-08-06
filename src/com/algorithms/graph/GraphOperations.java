package com.algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.datastructures.graph.Graph;
import com.datastructures.graph.Vertex;

public class GraphOperations {
	
	// BFS for undirected graph
	public static List<Vertex> breadthFirstSearch(Graph graph, Vertex start){
		LinkedList<Vertex> queue = new LinkedList<Vertex>();
		List<Vertex> orderedVertices = new ArrayList<Vertex>();
		
		graph.markAllVerticesUnexplored();
		
		start.setExplored();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			Vertex v = queue.remove();
			
			orderedVertices.add(v);
			
			for (Vertex connectedVertex : v.getConnections()) {
				if(!connectedVertex.isExplored()){
					connectedVertex.setExplored();
					queue.add(connectedVertex);
				}
			}
		}
		return orderedVertices;
	}
	
	// BFS - Finding number of levels in a shortest path for undirected Graph
	public static int findShortestPath(Graph graph, Vertex start, Vertex goal) {
		LinkedList<Vertex> queue = new LinkedList<Vertex>();
		
		graph.markAllVerticesUnexplored();
		graph.resetAllDistances();
		
		start.setExplored();
		start.setDistance(0);
		queue.add(start);
		
		while(!queue.isEmpty()) {
			Vertex v = queue.remove();
			for (Vertex connectedVertex : v.getConnections()) {
				if(!connectedVertex.isExplored()) {
					
					connectedVertex.setExplored();
					connectedVertex.setDistance(v.getDistance() + 1);
					
					queue.add(connectedVertex);
					
					if(connectedVertex.equals(goal)) {
						return connectedVertex.getDistance();
					}
				}
			}
		}
		
		return -1;
	}
	
	// BFS - Finding connected components in an undirected graph
	public static List<Vertex> findConnectedComponents (Graph graph, Vertex start) {
		List<Vertex> connectedComponents = new ArrayList<Vertex>();
		return connectedComponents;
	}
	
	// DFS - Topological Sort of directed graphs
	public static List<Vertex> DFSTopologicalSort() {
		return null;
	}
	
	// DFS - Removing cycles with strongly connected components in a directed graph
	public static void removeCyclesWithDFS () {
		
	}
	
}