package com.datastructures;

public class BinaryTree<E> {
	private TreeNode<E> rootNode;

	public TreeNode<E> getRootNode() {
		return rootNode;
	}

	public void setRootNode(TreeNode<E> rootNode) {
		this.rootNode = rootNode;
	}
	
	@Override
	public String toString() {
		return rootNode.toString();
	}
	
}
