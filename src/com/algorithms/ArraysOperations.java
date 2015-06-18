package com.algorithms;


public class ArraysOperations {
	
	public static void main (String [] args){
		int [] elements = {15,25,35,45,55,65,120,490,1880,199902};
		
		int [] nelements = {8,7,3,2,1,4,6,5,9,10};
		
		printSumPairs(elements);
		printSecondLargestNumberInArray(elements);
		System.out.println(containsAllNumbers(nelements));
	}
	
	/* Check if two elements in a SORTED array sum up to a third */
	public static void printSumPairs (int[] elements) {
		for (int i = elements.length-1; i > 0; i--) {
			for(int k = 0, j = i-1; k != j;){
				if(elements[k] + elements[j] == elements[i]){
					System.out.println(elements[k] + ", " + elements[j]);
					j--;
				} else if (elements[k] + elements[j] < elements[i]){
					k++;
				} else if (elements[k] + elements[j] > elements[i]){
					j--;
				}
			}
		}
	}
	
	/* Find the second largest number in a integer array */
	public static void printSecondLargestNumberInArray (int[] elements) {
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		for(int i = 0; i < elements.length; i++) {
			if(elements[i] > secondLargest) {
				if(elements[i] > largest) {
					secondLargest = largest;
					largest = elements[i];
				} else {
					secondLargest = elements[i];
				}
			}
		}
		System.out.println(secondLargest);
	}
	
	/* Check if an array contains all integers from 1 to N, being N size of the array */
	private static boolean containsAllNumbers(int[] nelements) {
		boolean validate [] = new boolean [nelements.length];
		for (int i = 0; i < nelements.length; i++) {
			int el = nelements[i];
			if(el > 0 && el <= validate.length){
				validate[el-1] = true;
			} else {
				return false;
			}
		}
		
		for (boolean b : validate) {
			if(!b) {
				return false;
			}
		}
		
		return true;
	}

}
