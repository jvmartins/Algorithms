package com.datastructures.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	List<Vertex> vertices;
	
	public Graph() {
		this.vertices = new ArrayList<Vertex>();
	}
	
	public void markAllVerticesUnexplored () {
		for (Vertex vertex : vertices) {
			vertex.setUnexplored();
		}
	}
	
	public void resetAllDistances() {
		for (Vertex vertex : vertices) {
			vertex.setDistance(Integer.MAX_VALUE);
		}
	}
	
	public List<Vertex> getVertices() {
		return this.vertices;
	}
	
	public void addVertex (Vertex v){
		this.vertices.add(v);
	}
}
