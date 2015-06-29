package com.algorithms;

public class StringBinaryTreeOperations {
	
	public static void main(String[] args) {
		/*
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
		System.out.println(findHeight(btFromArray.getRootNode()));
		*/
	}
	
	/* Convert array String into BinaryTree 
	private static BinaryTree convertToBinaryTree(String[] arr) {
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
			return new TreeNode(null, null, array[0]);
		}
		double subTreeRootIndex = ((double) subTreeSize)/2;
		int roundedIndex = (int) Math.ceil(subTreeRootIndex);
		
		TreeNode subTreeRootLeft = getSubTree(Arrays.copyOfRange(array, 0, roundedIndex-1));
		TreeNode subTreeRootRight = getSubTree(Arrays.copyOfRange(array, roundedIndex, subTreeSize));
		
		TreeNode treeRoot = new TreeNode(subTreeRootLeft, subTreeRootRight, array[roundedIndex-1]);
		
		return treeRoot;
	} */
}
