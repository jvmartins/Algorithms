package com.algorithms.unionfind;

public class QuickFind {
	
	public static void main(String[] args) {
		QuickFind qf = new QuickFind(10);
		
		qf.union(1, 0);
		qf.union(5, 1);
		qf.union(1, 9);
		qf.union(0, 4);
		qf.union(2, 9);
		qf.union(9, 8);
		
		System.out.println(qf);
	}
	
	int [] elements;
	
	public QuickFind(int n) {
		elements = new int[n];
		for (int i = 0; i < elements.length; i++) {
			elements[i] = i;
		}
	}
	
	
	public void union (int p, int q) {
		int oldId = elements[p];
		int newId = elements[q];
		for (int i = 0; i < elements.length; i++) {
			if(elements[i] == oldId){
				elements[i] = newId;
			}
		}
	}
	
	public boolean connected (int p, int q) {
		return elements[p] == elements[q];
	}
	
	@Override
	public String toString() {
		String printed = "";
		for (int i = 0; i < elements.length; i++) {
			printed += elements[i] + " ";
		}
		return printed;
	}
}
