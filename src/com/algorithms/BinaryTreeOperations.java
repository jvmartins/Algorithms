package com.algorithms;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

import com.datastructures.BinaryTree;
import com.datastructures.TreeNode;

public class BinaryTreeOperations {
	
	public static void main (String [] args){
		SortedSet<String> sortedList = new TreeSet<String>();
		sortedList.add("Aderbal");
		sortedList.add("Beatriz");
		sortedList.add("Bruna");
		sortedList.add("Debora");
		sortedList.add("Ignacio");
		sortedList.add("Xavier");
		sortedList.add("Victor");
		sortedList.add("Victoria");
		
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
		//BinaryTree btFromSortedList = convertToBinaryTree(sortedList);
		BinaryTree btFromArray = convertToBinaryTree(names);
		
		System.out.println(btFromArray);
	}
	
	/* Convert sorted array into BinaryTree */;
	private static BinaryTree convertToBinaryTree(SortedSet<String> sortedList) {
		TreeNode rootNode = getSubTree(sortedList);
		BinaryTree bt = new BinaryTree();
		bt.setRootNode(rootNode);
		return bt;
	}
	
	private static TreeNode getSubTree(SortedSet<String> sortedList) {
		int subTreeSize = sortedList.size();
		if(subTreeSize == 1) {
			return new TreeNode(null, null, sortedList.first());
		}
		//TreeNode subTreeRootLeft = getSubTree(sortedList.subSet(sortedList.first(), ));
		//TreeNode subTreeRootRight = getSubTree(sortedList.subSet(sortedList, toElement));
		
		//TreeNode treeRoot = new TreeNode(subTreeRootLeft, subTreeRootRight, sortedList.get(middleElement));
		return new TreeNode(null, null, null);
	}
	
	/* Convert array into BinaryTree */;
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
		double subTreeRootIndex = ((double) subTreeSize)/2;
		int roundedIndex = (int) Math.ceil(subTreeRootIndex);
		
		if(subTreeSize == 1) {
			return new TreeNode(null, null, array[0]);
		}
		
		TreeNode subTreeRootLeft = getSubTree(Arrays.copyOfRange(array, 0, roundedIndex-1));
		TreeNode subTreeRootRight = getSubTree(Arrays.copyOfRange(array, roundedIndex, subTreeSize));
		
		TreeNode treeRoot = new TreeNode(subTreeRootLeft, subTreeRootRight, array[roundedIndex-1]);
		
		return treeRoot;
	}

}
