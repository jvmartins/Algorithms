package com.datastructures;

public class BinaryTree {
	private TreeNode rootNode;

	public TreeNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(TreeNode rootNode) {
		this.rootNode = rootNode;
	}
	
	@Override
	public String toString() {
		return rootNode.toString();
	}
	
}
