package com.algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.datastructures.graph.UndirectedGraph;
import com.datastructures.graph.UndirectedVertex;

public class GraphOperations {
	
	public static List<UndirectedVertex> breadthFirstSearch (UndirectedGraph graph, UndirectedVertex start){
		LinkedList<UndirectedVertex> queue = new LinkedList<UndirectedVertex>();
		List<UndirectedVertex> orderedVertices = new ArrayList<UndirectedVertex>();
		
		graph.markAllVerticesUnexplored();
		
		start.setExplored();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			UndirectedVertex v = queue.remove();
			
			orderedVertices.add(v);
			
			for (UndirectedVertex connectedVertex : v.getConnections()) {
				if(!connectedVertex.isExplored()){
					connectedVertex.setExplored();
					queue.add(connectedVertex);
				}
			}
		}
		return orderedVertices;
	}
	
	public static List<UndirectedVertex> findShortestPath (UndirectedGraph graph, UndirectedVertex start, UndirectedVertex goal) {
		List<UndirectedVertex> path = new ArrayList<UndirectedVertex>();
		LinkedList<UndirectedVertex> queue = new LinkedList<UndirectedVertex>();
		
		graph.markAllVerticesUnexplored();
		graph.resetAllDistances();
		
		start.setExplored();
		int level = 0;
		start.setDistance(level);
		queue.add(start);
		
		while(!queue.isEmpty()) {
			UndirectedVertex v = queue.remove();
			for (UndirectedVertex connectedVertex : v.getConnections()) {
				if(!connectedVertex.isExplored()) {
					if(level == v.getDistance()) {
						level++;
						path.add(connectedVertex);
					}
					
					connectedVertex.setExplored();
					connectedVertex.setDistance(level);
					queue.add(connectedVertex);
					
					if(connectedVertex.equals(goal)) {
						return path;
					}
				}
			}
		}
		
		return path;
	}
	
	public static List<UndirectedVertex> findConnectedComponents (UndirectedGraph graph, UndirectedVertex start) {
		List<UndirectedVertex> connectedComponents = new ArrayList<UndirectedVertex>();
		//TODO implement
		return connectedComponents;
	}
	
}