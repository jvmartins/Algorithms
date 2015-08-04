package com.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

import com.datastructures.heap.CustomHeap;

public class SkylineProblem {
	
    //Input: [ [Li Ri Hi] ] - Left index, Right index, Height
    //Output: List of [x,y] - Coordinates
	CustomHeap heap = new CustomHeap();
	
	public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> coordinates = new ArrayList<int[]>();
        SortedSet<Point> criticalPoints = getCriticalPointsOrdered(buildings);
        
        for (Point point : criticalPoints) {
			if(point.isLeft) {
				addToHeap(point);
			} else {
				removeFromHeap(point);
			}
			
			if(coordinates.size() == 0) {
				int [] coordinate = { point.x, getFirstHeapEl() };
				coordinates.add(coordinate);
				continue;
			}
			
			int [] lastCoordinate = coordinates.get(coordinates.size()-1);
			
			if(lastCoordinate[0] == point.x) {
				int [] coordinate = { point.x, getFirstHeapEl() };
				coordinates.set(coordinates.size()-1, coordinate);
				continue;
			}
			
			if(lastCoordinate[1] != getFirstHeapEl()) {
				int [] coordinate = { point.x, getFirstHeapEl() };
				coordinates.add(coordinate);
			}
			
		}
        return coordinates;
    }
	
	private int getFirstHeapEl() {
		return heap.getTopOfHeap();
	}

	private void removeFromHeap(Point point) {
		this.heap.removeSpecific(point.getR().getHeight());
	}

	private void addToHeap(Point point) {
		this.heap.insert(point.getR().getHeight());
	}

	private SortedSet<Point> getCriticalPointsOrdered(int[][] buildings){
		SortedSet<Point> criticalPoints = new TreeSet<Point>();
		
		for (int i = 0; i < buildings.length; i++) {
        	int leftIndex = buildings[i][0];
        	int rightIndex = buildings[i][1];
        	int height = buildings[i][2];
        	Rectangle r = new Rectangle(leftIndex, rightIndex, height);
        	Point leftPoint = new Point(r, r.getLeftIndex(), r.getHeight(), true);
    		Point rightPoint = new Point(r, r.getRightIndex(), r.getHeight(), false);
    		
    		if(criticalPoints.contains(leftPoint)) {
    			criticalPoints.remove(leftPoint);
    		} else {
    			criticalPoints.add(leftPoint);
    		}
    		
    		if(criticalPoints.contains(rightPoint)) {
    			criticalPoints.remove(rightPoint);
    		} else {
    			criticalPoints.add(rightPoint);
    		}
		}
		
		return criticalPoints;
	}
	
	class Rectangle {
		int leftIndex;
		int rightIndex;
		int height;
		
		public Rectangle(int leftIndex, int rightIndex, int height) {
			super();
			this.leftIndex = leftIndex;
			this.rightIndex = rightIndex;
			this.height = height;
		}
		
		public int getLeftIndex() {
			return leftIndex;
		}
		
		public int getRightIndex() {
			return rightIndex;
		}
		
		public int getHeight() {
			return height;
		}
	}
	
	class Point implements Comparable<Point>{
		
		Rectangle r;
		int x;
		int y;
		boolean isLeft;
		
		public Point(Rectangle r, int x, int y, boolean isLeft) {
			super();
			this.r = r;
			this.x = x;
			this.y = y;
			this.isLeft = isLeft;
		}

		public Rectangle getR() {
			return r;
		}
		
		public boolean isLeft() {
			return isLeft;
		}
		
		public boolean isRight() {
			return !isLeft;
		}
		
		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}

		public int compareTo(Point o) {
			if(this.getX() < o.getX()) {
				return -1;
			} 
			if(this.getX() == o.getX() && this.getY() == o.getY()){
				return 0;
			}
			return 1;
		}
		
	}
	
	public void testSkylineProblem() {
		
	}
	
	public void testOrderedCriticalPoints() {
		int[][] buildings = initializeBuildingsEx1();
		SortedSet<Point> criticalPoints = getCriticalPointsOrdered(buildings);
		for (Point point : criticalPoints) {
			System.out.print("(" + point.getX() + ", ");
			System.out.print(point.getY() + ")");
		}
		
		System.out.println();
		
		buildings = initializeBuildingsEx2();
		criticalPoints = getCriticalPointsOrdered(buildings);
		for (Point point : criticalPoints) {
			System.out.print("(" + point.getX() + ", ");
			System.out.print(point.getY() + ")");
		}
	}
	
	@Test
	public void testSkyline1(){
		SkylineProblem sp = new SkylineProblem();
		printList(sp.getSkyline(initializeBuildingsEx1()));
	}
	
	@Test
	public void testSkyline2(){
		SkylineProblem sp = new SkylineProblem();
		printList(sp.getSkyline(initializeBuildingsEx2()));
	}
	
	@Test
	public void testSkyline3(){
		SkylineProblem sp = new SkylineProblem();
		printList(sp.getSkyline(initializeBuildingsEx3()));
	}
	
	@Test
	public void testSkyline4(){
		SkylineProblem sp = new SkylineProblem();
		printList(sp.getSkyline(initializeBuildingsEx4()));
	}
	
	private void printList(List<int[]> coordinates) {
		System.out.println();
		for (int[] is : coordinates) {
			System.out.print("(" + is[0] + "," + is[1] + ") ");
		}
	}
    
    //Input: [ [1 3 6], [2 3 8], [2 4 5], [5 6 8] ]
	//Critical points: 1,6 2,8 2,5 3,6 3,8 4,5 5,8 6,8 
    //Output: (1,6) (2,8) (3,5) (5,8) (6,0)
	private int[][] initializeBuildingsEx1() {
		int[][] buildings = {{1,3,6},{2,3,8},{2,4,5},{5,6,8}};
		return buildings;
	}
	
	//Input: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ]
	//Critical points: 2,10 3,15 5,12 7,15 9,10 12,12 15,10 19,8 20,10 24,8
    //Output: [ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]
	private int[][] initializeBuildingsEx2() {
		int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
		return buildings;
	}
	
	//Input: [ [0 2 3], [2 5 3] ]
	//Critical points: 0,3 2,3 2,3 2,5 5,0
    //Output: [ [0,3] [5,0] ]
	private int[][] initializeBuildingsEx3() {
		int[][] buildings = {{0,2,3},{2,5,3}};
		return buildings;
	}
	
	//Input: [ [1 2 1], [1 2 2], [1 2 3] ]
	//Critical points: 1,1 1,2 1,3 2,1 2,2 2,3
    //Output: [ [1,3] [2,0] ]
	private int[][] initializeBuildingsEx4() {
		int[][] buildings = {{1,2,1},{1,2,2},{1,2,3}};
		return buildings;
	}
	
}
