package com.algorithms;

import java.util.ArrayList;

import com.datastructures.CustomHeap;

public class HeapOperations {
	
	public static void main(String[] args) {
		CustomHeap ch = new CustomHeap();
		ArrayList<Integer> heapElements = new ArrayList<Integer>();
		
		//[100, 40, 20, 10, 9, 11, 8]
		heapElements.add(100);
		heapElements.add(40);
		heapElements.add(20);
		heapElements.add(10);
		heapElements.add(9);
		heapElements.add(11);
		heapElements.add(8);
		
		ch.setHeapElements(heapElements);
		
		System.out.println(ch.getHeapElements());
		
		ch.delete();
		
		System.out.println(ch.getHeapElements());
	}
}
