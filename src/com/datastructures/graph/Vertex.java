package com.datastructures.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	List<Vertex> connections;
	
	private int distance = Integer.MAX_VALUE;
	boolean explored;
	int value;
	
	public Vertex(int value) {
		this.connections = new ArrayList<Vertex>();
		this.explored = false;
		this.value = value;
	}
	
	public boolean isExplored() {
		return explored;
	}

	public void setExplored() {
		this.explored = true;
	}
	
	public void setUnexplored() {
		this.explored = false;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Vertex){
			if(((Vertex) obj).value == this.value){
				return true;
			}
		}
		return false;
	}
	
	public void addConnection (Vertex connection) {
		this.connections.add(connection);
	}
	
	public List<Vertex> getConnections() {
		return connections;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
}
