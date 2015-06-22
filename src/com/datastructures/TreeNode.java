package com.datastructures;

public class TreeNode<E> implements Comparable<E>{		
	private TreeNode<E> left, right;
	private E value;
	
	public TreeNode(TreeNode left, TreeNode right, E value) {
		this.left = left;
		this.right = right;
		this.value = value;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		String printed = "\nroot: " + this.getValue();
		if(left != null) {			
			printed += "\nleft: " + left.getValue();			
		}
		if(right != null) {
			printed += "\nright: " + right.getValue();
		}
		
		printed += "\n" + left;
		printed += "\n" + right;
 		return printed;
	}

	@Override
	public int compareTo(E o) {
		if(this.getValue() == o) {
			return 1;
		}
		return 0;
	}
}
