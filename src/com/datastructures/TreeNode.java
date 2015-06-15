package com.datastructures;

public class TreeNode {		
	private TreeNode left, right;
	private String value;
	
	public TreeNode(TreeNode left, TreeNode right, String value) {
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
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
}
