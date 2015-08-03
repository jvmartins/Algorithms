package com.datastructures.tree;

public class BinaryTree {
	private TreeNode rootNode;

	public TreeNode getRootNode() {
		return this.rootNode;
	}

	public void setRootNode(TreeNode rootNode) {
		this.rootNode = rootNode;
	}
	
	@Override
	public String toString() {
		return this.rootNode.toString();
	}
	
}
