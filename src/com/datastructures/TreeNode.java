package com.datastructures;

public class TreeNode {		
	private TreeNode left, right;
	private Integer value;
	
	public TreeNode(TreeNode left, TreeNode right, Integer value) {
		this.left = left;
		this.right = right;
		this.value = value;
	}

	public TreeNode getLeft() {
		return this.left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return this.right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public Integer getValue() {
		return this.value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		String printed = "\nroot: " + this.getValue();
		if(this.left != null) {			
			printed += "\nleft: " + this.left.getValue();			
		}
		if(this.right != null) {
			printed += "\nright: " + this.right.getValue();
		}
		
		printed += "\n" + this.left;
		printed += "\n" + this.right;
 		return printed;
	}

}
