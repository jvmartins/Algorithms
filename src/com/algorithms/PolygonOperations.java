package com.algorithms;

public class PolygonOperations {
	
	public static void main (String [] args){
		int [] bottomLeftR1 = {1,1};
		int [] topRightR1 = {3,2};
		Rectangle r1 = new Rectangle(bottomLeftR1, topRightR1);
		
		int [] bottomLeftR2 = {2,1};
		int [] topRightR2 = {5,4};
		Rectangle r2 = new Rectangle(bottomLeftR2, topRightR2);
		
		System.out.println(findRectanglesIntersectedArea(r1, r2));
	}
	
	/* Find two intersected (or not) rectangles area */
	public static int findRectanglesIntersectedArea(Rectangle r1, Rectangle r2){
		int intersectedArea = 0;
		if(r1.getBottomRight()[0] > r2.getBottomLeft()[0] && r1.getBottomLeft()[0] < r2.getBottomRight()[0]) {
			if(r1.getTopLeft()[1] > r2.getBottomLeft()[1] && r1.getBottomLeft()[1] < r2.getTopLeft()[1]) {
				// It means has an intersection, should now find the intersected triangle and its area
				// TODO intersectedArea
			}
		}
		return r1.getArea() + r2.getArea() - intersectedArea;
	}
	
	static class Rectangle {
		
		int [] bottomLeft;
		int [] bottomRight;
		int [] topRight;
		int [] topLeft;
		
		public Rectangle(int [] bottomLeft, int [] topRight) {
			this.bottomLeft = bottomLeft;
			this.bottomRight = new int[2];
			bottomRight[0] = topRight[0];
			bottomRight[1] = bottomLeft[1];
			
			this.topRight = topRight;
			this.topLeft = new int[2];
			topLeft[0] = bottomLeft[0];
			topLeft[1] = topRight[1];
		}
		
		public int [] getBottomLeft() {
			return bottomLeft;
		}
		
		
		public int [] getTopRight(){
			return topRight;
		}
		
		public int [] getTopLeft(){
			return topLeft;
		}
		
		public int [] getBottomRight() {
			return bottomRight;
		}
		
		public int getArea () {
			int a = this.topRight[0] - this.bottomLeft[0];
			int b = this.topRight[1] - this.bottomLeft[1];
			return a * b;
		}
		
		/*
		public Rectangle intersection(Rectangle r2) {
	        double newX = Math.max(this.x, r2.x);
	        double newY = Math.max(this.y, r2.y);

	        double newWidth = Math.min(this.x + this.width, r2.x + r2.width) - newX;
	        double newHeight = Math.min(this.y + this.height, r2.y + r2.height) - newY;

	        if (newWidth <= 0d || newHeight <= 0d) return null;

	        return new Rect(newX, newY, newWidth, newHeight);
	    } 
	    */
	}
}
