package com.datastructures.graph;

import java.util.List;

public class DirectedVertex extends Vertex {
	
	List<Edge> edges;
	
	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

}
