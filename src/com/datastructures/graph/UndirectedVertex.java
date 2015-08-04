package com.datastructures.graph;

import java.util.ArrayList;
import java.util.List;

public class UndirectedVertex extends Vertex {
	
	List<UndirectedVertex> connections;
	
	private int distance = Integer.MAX_VALUE;
	
	public UndirectedVertex(int value) {
		this.connections = new ArrayList<UndirectedVertex>();
		this.explored = false;
		this.value = value;
	}
	
	public void addConnection (UndirectedVertex connection) {
		this.connections.add(connection);
	}
	
	public List<UndirectedVertex> getConnections() {
		return connections;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
}
