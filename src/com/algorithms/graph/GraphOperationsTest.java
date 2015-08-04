package com.algorithms.graph;

import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.datastructures.graph.UndirectedGraph;
import com.datastructures.graph.UndirectedVertex;

public class GraphOperationsTest{
	
	@Test
	public void breadthFirstTest() {
		UndirectedGraph g = createGraph();
		
		List<UndirectedVertex> ordered1 = GraphOperations.breadthFirstSearch(g, g.getVertices().get(0));
		assertEquals(ordered1.get(3), new UndirectedVertex(4));
		
		List<UndirectedVertex> ordered2 = GraphOperations.breadthFirstSearch(g, g.getVertices().get(1));
		assertEquals(ordered2.get(1), new UndirectedVertex(1));
		
		List<UndirectedVertex> ordered3 = GraphOperations.breadthFirstSearch(g, g.getVertices().get(4));
		assertEquals(ordered3.get(0), new UndirectedVertex(6));
		
		List<UndirectedVertex> ordered4 = GraphOperations.breadthFirstSearch(g, g.getVertices().get(5));
		assertEquals(ordered4.get(0), new UndirectedVertex(7));
	}
	
	@Test
	public void ShortestPathTest() {
		UndirectedGraph g = createGraph();
		
		List<UndirectedVertex> path = GraphOperations.findShortestPath(g, g.getVertices().get(0), g.getVertices().get(3));
		assertEquals(path.get(0), new UndirectedVertex(2));
		assertEquals(path.get(path.size()-1).getDistance(), 2);
		
	}

	private UndirectedGraph createGraph() {
		
		UndirectedGraph g = new UndirectedGraph();
		
		// Create vertices
		UndirectedVertex v1 = new UndirectedVertex(1);
		UndirectedVertex v2 = new UndirectedVertex(2);
		UndirectedVertex v3 = new UndirectedVertex(3);
		UndirectedVertex v4 = new UndirectedVertex(4);
		
		// Different connected component
		UndirectedVertex v6 = new UndirectedVertex(6);
		UndirectedVertex v7 = new UndirectedVertex(7);
		
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
