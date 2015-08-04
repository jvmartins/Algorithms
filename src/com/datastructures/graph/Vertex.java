package com.datastructures.graph;

public class Vertex {
	
	boolean explored;
	
	int value;
	
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
}
