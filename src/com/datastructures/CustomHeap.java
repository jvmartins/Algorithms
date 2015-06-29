package com.datastructures;

import java.util.ArrayList;

/*
 * p = k-1/2;
 * leftChild = 2k + 1;
 * rightChild = 2k + 2;
 *         
 *         100
 *       /     \
 *      40     20
 *     /  \   /  \
 *    10  9  11   8
 *    
 * [100, 40, 20, 10, 9, 11, 8]
 * 
 * After delete():
 * [40, 20, 10, 9, 11, 8]
 * 
 * After insert(200):
 * [200, 40, 20, 10, 9, 11, 8] 
 * 
 * Breadth-first search - tree level order
 * 
 */
public class CustomHeap {
	ArrayList<Integer> heapElements = new ArrayList<Integer>();
	
	private void siftUp(int index) {
		
	}
	
	private void siftDown(int index) {
		int leftIndex = (2*index)+1;
		int rightIndex = (2*index)+2;
		Integer leftChild = null;
		Integer rightChild = null;
		if(leftIndex < this.heapElements.size()) {
			leftChild = this.heapElements.get(leftIndex);
			if(rightIndex < this.heapElements.size()) {
				rightChild = this.heapElements.get(rightIndex);
			}
		} else {
			return;
		}
		
		int changeIndex = leftIndex;
		if(rightChild != null && rightChild > leftChild){
			changeIndex = rightIndex;
		}
		Integer currentElement = this.heapElements.get(index);
		Integer changeElement = this.heapElements.get(changeIndex);
		
		if(currentElement < changeElement){
			this.heapElements.set(index, changeElement);
			this.heapElements.set(changeIndex, currentElement);
			siftDown(changeIndex);
		}
	}
	
	public void delete() {
		this.heapElements.remove(0);
		this.heapElements.add(0, this.heapElements.remove(this.heapElements.size()-1));
		siftDown(0);
	}
	
	public void insert(int value) {
		
	}
	
	public ArrayList<Integer> getHeapElements() {
		return heapElements;
	}
	
	public void setHeapElements(ArrayList<Integer> heapElements) {
		this.heapElements = heapElements;
	}
}
