package com.algorithms.unionfind;

public class QuickUnion {
	
	public static void main(String[] args) {
		QuickUnion qf = new QuickUnion(10);
		
		qf.union(9, 1);
		qf.union(1, 7);
		qf.union(3, 4);
		qf.union(9, 8);
		qf.union(6, 5);
		qf.union(1, 2);
		qf.union(4, 5);
		qf.union(8, 6);
		qf.union(0, 8);
		
		System.out.println(qf);
	}
	
	int [] elements;
	int [] numberOfNodes;
	
	public QuickUnion(int n) {
		elements = new int[n];
		numberOfNodes = new int[n];
		for (int i = 0; i < elements.length; i++) {
			elements[i] = i;
			numberOfNodes[i] = 1;
		}
	}
	
	
	public void union (int p, int q) {
		int pRoot = findRoot(p);
		int qRoot = findRoot(q);
		
		if(pRoot == qRoot) return;
		
		if(numberOfNodes[pRoot] >= numberOfNodes[qRoot]) {
			elements[qRoot] = pRoot;
			numberOfNodes[pRoot] += numberOfNodes[qRoot];
		} else {
			elements[pRoot] = qRoot;
			numberOfNodes[qRoot] += numberOfNodes[pRoot];
		}
		
	}
	
	private int findRoot(int r) {
		if(elements[r] == r) {
			return r;
		} 
		
		return findRoot(elements[r]);
	}
	
	@Override
	public String toString() {
		String printed = "";
		for (int i = 0; i < elements.length; i++) {
			printed += elements[i] + " ";
		}
		printed += "\n";
		for (int i = 0; i < numberOfNodes.length; i++) {
			printed += numberOfNodes[i] + " ";
		}
		return printed;
	}
}
