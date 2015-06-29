package com.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.datastructures.BinaryTree;
import com.datastructures.TreeNode;

public class BinaryTreeOperations {
	
	public static void main (String [] args){
		
		String[] names = new String[8];
		names[0] = "Aderbal";
		names[1] = "Beatriz";
		names[2] = "Bruna";
		names[3] = "Debora";
		names[4] = "Ignacio";
		names[5] = "Xavier";
		names[6] = "Victor";
		names[7] = "Victoria";
		
		String[] left = Arrays.copyOfRange(names, 0, 1);
		System.out.println(left[0]);
		System.out.println(left[left.length-1]);
		String[] right = Arrays.copyOfRange(names, 4, 8);
		System.out.println(right[0]);
		System.out.println(right[right.length-1]);
		
		System.out.println(names.length);
		BinaryTree btFromArray = convertToBinaryTree(names);
		
		System.out.println(btFromArray);
		
		System.out.println(findMinElement(btFromArray.getRootNode()));
		System.out.println(findMaxElement(btFromArray.getRootNode()));
		
		
		Integer [] arrayNumbers = {1,2,5,7,8,10,19,25};
		BinaryTree<Integer> integerBT = convertToBinaryTree(arrayNumbers);
		
		System.out.println(checkIfIsBST(integerBT));
		
		BinaryTree<Integer> notBST = new BinaryTree<Integer>();
		TreeNode<Integer> leaf1 = new TreeNode<Integer>(null, null, 1);
		TreeNode<Integer> leaf2 = new TreeNode<Integer>(null, null, 4);
		TreeNode<Integer> root = new TreeNode<Integer>(leaf1, leaf2, 5);
		
		notBST.setRootNode(root);
		
		System.out.println(checkIfIsBST(notBST));
		
		System.out.println(findHeight(notBST.getRootNode()));
		System.out.println(findHeight(integerBT.getRootNode()));
		System.out.println(findHeight(btFromArray.getRootNode()));
		
		traversalTreeInOrder(btFromArray.getRootNode());
		traversalTreeLevelOrder(btFromArray.getRootNode());
		System.out.println(inOrderSucessor(integerBT.getRootNode(), 5));
	}
	
	/* Convert array into BinaryTree */;
	private static BinaryTree convertToBinaryTree(String[] arr) {
		TreeNode rootNode = getSubTree(arr);
		BinaryTree bt = new BinaryTree();
		bt.setRootNode(rootNode);
		return bt;
	}
	
	/* Convert array into BinaryTree */;
	private static BinaryTree convertToBinaryTree(Integer[] arr) {
		TreeNode rootNode = getSubTree(arr);
		BinaryTree bt = new BinaryTree();
		bt.setRootNode(rootNode);
		return bt;
	}
	
	private static TreeNode getSubTree(String[] array) {
		int subTreeSize = array.length;
		if(subTreeSize == 0){
			return null;
		}
		if(subTreeSize == 1) {
			return new TreeNode<>(null, null, array[0]);
		}
		double subTreeRootIndex = ((double) subTreeSize)/2;
		int roundedIndex = (int) Math.ceil(subTreeRootIndex);
		
		TreeNode subTreeRootLeft = getSubTree(Arrays.copyOfRange(array, 0, roundedIndex-1));
		TreeNode subTreeRootRight = getSubTree(Arrays.copyOfRange(array, roundedIndex, subTreeSize));
		
		TreeNode treeRoot = new TreeNode(subTreeRootLeft, subTreeRootRight, array[roundedIndex-1]);
		
		return treeRoot;
	}
	
	private static TreeNode getSubTree(Integer[] array) {
		int subTreeSize = array.length;
		if(subTreeSize == 0){
			return null;
		}
		if(subTreeSize == 1) {
			return new TreeNode<>(null, null, array[0]);
		}
		double subTreeRootIndex = ((double) subTreeSize)/2;
		int roundedIndex = (int) Math.ceil(subTreeRootIndex);
		
		TreeNode subTreeRootLeft = getSubTree(Arrays.copyOfRange(array, 0, roundedIndex-1));
		TreeNode subTreeRootRight = getSubTree(Arrays.copyOfRange(array, roundedIndex, subTreeSize));
		
		TreeNode treeRoot = new TreeNode(subTreeRootLeft, subTreeRootRight, array[roundedIndex-1]);
		
		return treeRoot;
	}
	
	private static boolean checkIfIsBST (BinaryTree b) {
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		TreeNode root = b.getRootNode();
		if(isBSTFromNode(root.getLeft(), min, (Integer)root.getValue()) && 
				isBSTFromNode(root.getRight(), (Integer)root.getValue(), max)){
			return true;
		}
		return false;
	}
	
	private static boolean isBSTFromNode(TreeNode<Integer> root, int min, int max) {
		if(root == null){
			return true;
		}
		
		if(root.getValue() >= min  && 
				root.getValue() <= max &&
				isBSTFromNode(root.getLeft(), min, root.getValue()) &&
				isBSTFromNode(root.getRight(), root.getValue(), max)) {
			return true;
		}
		
		return false;
	}
	
	private static void deleteNodeFromBST (String name){
		
	}
	
	private static void traversalTreeInOrder(TreeNode<String> root) {
		if(root == null) {
			return;
		}
		
		traversalTreeInOrder(root.getLeft());
		System.out.println(root.getValue());
		traversalTreeInOrder(root.getRight());
	}
	
	
	
	private static void traversalTreeLevelOrder(TreeNode<String> root) {
		List<TreeNode> queue = new ArrayList<TreeNode>();
		
		if(root == null){
			return;
		}
		
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.remove(queue.size()-1);
			System.out.println(node.getValue());
			if(node.getLeft() != null){
				queue.add(node.getLeft());
			}
			if(node.getRight() != null){
				queue.add(node.getRight());
			}
			
		}
		
		return;
	}
	
	
	private static TreeNode findMinElement(TreeNode root) {
		TreeNode current = root;
		TreeNode min = root;
		while(current != null) {
			min = current;
			current = min.getLeft();
		}
		
		return min;
	}
	
	private static TreeNode findMaxElement(TreeNode root) {
		TreeNode current = root;
		TreeNode max = root;
		while(current != null) {
			max = current;
			current = max.getRight();
		}
		
		return max;
	}
	
	private static int findHeight(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int leftSize = findHeight(root.getLeft());
		int rightSize = findHeight(root.getRight());
		
		return Math.max(leftSize, rightSize) + 1;
	}
	
	// Complexity: O(log n)
	private static int inOrderSucessor(TreeNode<Integer> root, int value) {
		TreeNode<Integer> node = findNodeWithValue(root, value);
		
		if(node.getRight() != null) {
			return (Integer) findMinElement(node.getRight()).getValue();
		}
		
		if(node.getRight() == null) {
			TreeNode sucessor = null;
			TreeNode ancestor = root;
			while (ancestor != node) {
				if(node.getValue() < (Integer)ancestor.getValue()){
					sucessor = ancestor;
					ancestor = ancestor.getLeft();
				} else {
					ancestor = ancestor.getRight();
				}
			}
			return (Integer) sucessor.getValue();
		}
		
		
		return -1;
	} 
	
	// Complexity: O(log n)
	private static TreeNode findNodeWithValue(TreeNode<Integer> root, int value) {
		if(root == null){
			return null;
		}
		
		if(root.getValue() == value) {
			return root;
		} else if(value < root.getValue()) {
			return findNodeWithValue(root.getLeft(), value);
		} else {
			return findNodeWithValue(root.getRight(), value);
		}
		
	}
	
}
