package com.datastructures.graph;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraph {
	
	List<UndirectedVertex> vertices;
	
	
	public UndirectedGraph() {
		this.vertices = new ArrayList<UndirectedVertex>();
	}
	
	public void markAllVerticesUnexplored () {
		for (Vertex vertex : vertices) {
			vertex.setUnexplored();
		}
	}
	
	public void resetAllDistances() {
		for (UndirectedVertex vertex : vertices) {
			vertex.setDistance(Integer.MAX_VALUE);
		}
	}
	
	public List<UndirectedVertex> getVertices() {
		return this.vertices;
	}
	
	public void addVertex (UndirectedVertex v){
		this.vertices.add(v);
	}
}
