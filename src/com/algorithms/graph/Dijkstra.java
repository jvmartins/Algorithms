package com.algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Dijkstra {
	
	// Find shortest paths in a weighted directed graph
	public List<DijkstraVertex> findShortestPath(DijkstraGraph g, DijkstraVertex start, DijkstraVertex goal) {
		
		Map<DijkstraVertex, Integer> shortestPathLength = new HashMap<DijkstraVertex, Integer>();
		Map<DijkstraVertex, List<DijkstraVertex>> shortestPath = new HashMap<DijkstraVertex, List<DijkstraVertex>>();
		
		DijkstraVertex current = start;
		shortestPathLength.put(current, 0);
		shortestPath.put(current, new ArrayList<DijkstraVertex>());
		
		Set<DijkstraEdge> nextEdges = new HashSet<DijkstraEdge>();
		nextEdges.addAll(current.getOutgoingEdges());
		
		while (!current.equals(goal)) {
			if(nextEdges.size() == 0) {
				break;
			}
			
			int smallestLength = Integer.MAX_VALUE;
			DijkstraEdge nextEdge = null;
			List<DijkstraEdge> edgesToRemove = new ArrayList<DijkstraEdge>();
			for (Iterator<DijkstraEdge> iterator = nextEdges.iterator(); iterator.hasNext();) {
				DijkstraEdge edge = (DijkstraEdge) iterator.next();
				if(shortestPathLength.get(edge.getNextVertex()) != null){
					edgesToRemove.add(edge);
					continue;
				}
				if(shortestPathLength.get(edge.getFromVertex()) + edge.getLength() < smallestLength) {
					smallestLength = shortestPathLength.get(edge.getFromVertex()) + edge.getLength();
					nextEdge = edge;
				}
			}
			
			removeEdges(nextEdges, edgesToRemove);
			
			int length = shortestPathLength.get(nextEdge.getFromVertex()) + nextEdge.getLength();
			
			nextEdges.addAll(nextEdge.getNextVertex().getOutgoingEdges());
			
			if(shortestPathLength.get(nextEdge.getNextVertex()) == null || length < shortestPathLength.get(nextEdge.getNextVertex())) {
				shortestPathLength.put(nextEdge.getNextVertex(), length);
				
				List<DijkstraVertex> newPath = new ArrayList<DijkstraVertex>();
				newPath.addAll(shortestPath.get(nextEdge.getFromVertex()));
				newPath.add(nextEdge.getNextVertex());
				
				shortestPath.put(nextEdge.getNextVertex(), newPath);
			}
			
			nextEdges.remove(nextEdge);
			
			current = nextEdge.getNextVertex();
		}
		
		return shortestPath.get(current);
	}
	
	private void removeEdges(Set<DijkstraEdge> nextEdges,
			List<DijkstraEdge> edgesToRemove) {
		nextEdges.removeAll(edgesToRemove);
		
	}

	class DijkstraGraph {
		List<DijkstraVertex> vertices = new ArrayList<DijkstraVertex>();
		
		public void addVertex(DijkstraVertex v) {
			this.vertices.add(v);
		}
		
		public int getLength() {
			return this.vertices.size();
		}
	}
	
	class DijkstraVertex {
		int uniqueIndex;
		List<DijkstraEdge> outgoingEdges = new ArrayList<DijkstraEdge>();
		
		public int getUniqueIndex() {
			return uniqueIndex;
		}
		public void setUniqueIndex(int uniqueIndex) {
			this.uniqueIndex = uniqueIndex;
		}
		public List<DijkstraEdge> getOutgoingEdges() {
			return outgoingEdges;
		}
		public void addOutgoingEdge(DijkstraEdge outgoingEdge) {
			this.outgoingEdges.add(outgoingEdge);
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
		    return prime * uniqueIndex;
		}
		
	}
	
	class DijkstraEdge {
		
		int length;
		DijkstraVertex fromVertex;
		DijkstraVertex nextVertex;
		
		public DijkstraEdge() {
			this.length = 1;
		}
		
		public DijkstraEdge(int length, DijkstraVertex fromVertex, DijkstraVertex nextVertex) {
			super();
			this.length = length;
			this.nextVertex = nextVertex;
			this.fromVertex = fromVertex;
		}
		
		public int getLength() {
			return length;
		}
		public void setLength(int length) {
			this.length = length;
		}
		public DijkstraVertex getNextVertex() {
			return nextVertex;
		}
		public void setNextVertex(DijkstraVertex nextVertex) {
			this.nextVertex = nextVertex;
		}
		public DijkstraVertex getFromVertex() {
			return fromVertex;
		}
		public void setFromVertex(DijkstraVertex fromVertex) {
			this.fromVertex = fromVertex;
		}
		
	}
	
	
	@Test
	public void testDijkstraAlgorithm () {
		DijkstraVertex s = new DijkstraVertex();
		s.setUniqueIndex(0);
		DijkstraVertex v = new DijkstraVertex();
		v.setUniqueIndex(1);
		DijkstraVertex w = new DijkstraVertex();
		w.setUniqueIndex(2);
		DijkstraVertex t = new DijkstraVertex();
		t.setUniqueIndex(3);
		
		DijkstraEdge e1 = new DijkstraEdge(1, s, v);
		s.addOutgoingEdge(e1);
		DijkstraEdge e2 = new DijkstraEdge(4, s, w);
		s.addOutgoingEdge(e2);
		
		DijkstraEdge e3 = new DijkstraEdge(2, v, w);
		v.addOutgoingEdge(e3);
		
		DijkstraEdge e4 = new DijkstraEdge(6, v, t);
		v.addOutgoingEdge(e4);
		
		DijkstraEdge e5 = new DijkstraEdge(3, w, t);
		w.addOutgoingEdge(e5);
		
		DijkstraGraph graph = new DijkstraGraph();
		graph.addVertex(s);
		graph.addVertex(v);
		graph.addVertex(w);
		graph.addVertex(t);
		
		List<DijkstraVertex> path = this.findShortestPath(graph, s, t);
		assertEquals(v, path.get(0));
		assertEquals(w, path.get(1));
		assertEquals(t, path.get(2));
	}
}
