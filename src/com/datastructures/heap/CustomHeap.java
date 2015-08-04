package com.datastructures.heap;

import java.util.ArrayList;

import org.junit.Test;

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
		int parentIndex = (index-1)/2;
		if(parentIndex < 0){
			return;
		}
		
		Integer parent = this.heapElements.get(parentIndex);
		Integer element = this.heapElements.get(index);
		if(element > parent) {
			this.heapElements.set(parentIndex, element);
			this.heapElements.set(index, parent);
			siftUp(parentIndex);
		}
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
		if(heapElements.size() > 0){
			this.heapElements.add(0, this.heapElements.remove(this.heapElements.size()-1));
			siftDown(0);
		}
	}
	
	public void insert(int value) {
		this.heapElements.add(value);
		siftUp(this.heapElements.size()-1);
	}
	
	public int getTopOfHeap() {
		if(this.heapElements.size() == 0){
			return 0;
		}
		return heapElements.get(0);
	}
	
	public ArrayList<Integer> getHeapElements() {
		return heapElements;
	}
	
	public void setHeapElements(ArrayList<Integer> heapElements) {
		this.heapElements = heapElements;
	}

	public void removeSpecific(int height) {
		int root = this.heapElements.get(0);
		
		if(root == height){
			this.delete();
			return;
		}
		
		int position = 0;
		while (height != root) {
			position++;
			root = this.heapElements.get(position);
		}
		
		this.heapElements.remove(position);
		this.heapElements.add(0, this.heapElements.remove(this.heapElements.size()-1));
		siftDown(0);
	}
	
	@Override
	public String toString() {
		String str = "[";
		String separator = "";
		for (Integer integer : heapElements) {
			str += separator + integer;
			separator = ", ";
		}
		str += "]";
		return str;
	}
	
	/*         100
	 *       /     \
	 *      40     20
	 *     /  \   /  \
	 *    10  9  11   8
	 *    
	 * [100, 40, 20, 10, 9, 11, 8]
	 */
	@Test
	public void testCustomHeap(){
		CustomHeap ch = new CustomHeap();
		
		ch.insert(100);
		ch.insert(10);
		ch.insert(20);
		ch.insert(40);
		ch.insert(9);
		ch.insert(11);
		ch.insert(8);
		
		System.out.println(ch);
	}
}
