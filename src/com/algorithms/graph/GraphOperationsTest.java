package com.algorithms.graph;

import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.datastructures.graph.Graph;
import com.datastructures.graph.Vertex;

public class GraphOperationsTest{
	
	@Test
	public void breadthFirstTest() {
		Graph g = createGraph();
		
		List<Vertex> ordered1 = GraphOperations.breadthFirstSearch(g, g.getVertices().get(0));
		assertEquals(ordered1.get(3), new Vertex(4));
		
		List<Vertex> ordered2 = GraphOperations.breadthFirstSearch(g, g.getVertices().get(1));
		assertEquals(ordered2.get(1), new Vertex(1));
		
		List<Vertex> ordered3 = GraphOperations.breadthFirstSearch(g, g.getVertices().get(4));
		assertEquals(ordered3.get(0), new Vertex(6));
		
		List<Vertex> ordered4 = GraphOperations.breadthFirstSearch(g, g.getVertices().get(5));
		assertEquals(ordered4.get(0), new Vertex(7));
	}
	
	@Test
	public void ShortestPathTest() {
		Graph g = createGraph();
		
		int path = GraphOperations.findShortestPath(g, g.getVertices().get(0), g.getVertices().get(3));
		
	}

	private Graph createGraph() {
		
		Graph g = new Graph();
		
		// Create vertices
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		
		// Different connected component
		Vertex v6 = new Vertex(6);
		Vertex v7 = new Vertex(7);
		
		//Create bidirectional connections
		v1.addConnection(v2);
		v2.addConnection(v1);
		
		v1.addConnection(v3);
		v3.addConnection(v1);
		
		v2.addConnection(v4);
		v4.addConnection(v2);
		
		v3.addConnection(v4);
		v4.addConnection(v3);
		
		v6.addConnection(v7);
		v7.addConnection(v6);
		
		// Add vertices to Graph
		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);
		
		g.addVertex(v6);
		g.addVertex(v7);
		
		return g;
	}
	
}
