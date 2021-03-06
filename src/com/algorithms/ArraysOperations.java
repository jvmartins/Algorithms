package com.algorithms;

import java.util.Arrays;


public class ArraysOperations {
	
	public static void main (String [] args){
		int [] elements = {15,25,35,45,55,65,120,490,1880,199902};
		
		int [] nelements = {8,2,3,7,1};
		
		//printSumPairs(elements);
		//printSecondLargestNumberInArray(elements);
		//System.out.println(containsAllNumbers(nelements));
		
		//System.out.println(Arrays.toString(nelements));
		//System.out.println(Arrays.toString(mergeSort(nelements)));
		
		// countInversions(nelements);
		// System.out.println(currentCount);
		
		//int [] coins = { 1,2,5,10,25,50,100,200 };
		//System.out.println(countMinimumCoinsForAmount(coins, 5.43));
		//System.out.println(countMinimumCoinsForAmount(coins, 0.67));
		
		/*
		int [] coins1 = { 1,11,20 };
		int [] coins2 = { 1,3,5 };
		System.out.println(countMinimumCoinsForSum(coins1, 0.22));
		System.out.println(countMinimumCoinsForSum(coins2, 0.11));
		System.out.println(countMinimumCoinsForSum(coins2, 0.14));
		System.out.println(countMinimumCoinsForSum(coins2, 0.15));
		*/
		
		int [][] matrix = {
				{  1,  2,  6,  9 },
				{  3,  4,  7, 11 },
				{  5,  8, 10, 15 }};
		
		//System.out.println(findKthElementInRowOrderedMatrix(matrix, 8)); // 21
		//System.out.println(findKthElementInOrderedMatrix(matrix, 8, (matrix.length + matrix[0].length - 1))); // 21
		
		int [] arrayFromMatrix = new int[matrix[0].length * matrix.length];
		int k = 0;
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++,k++){
				arrayFromMatrix[k] = matrix[i][j];
			}
		}
		System.out.println(Arrays.toString(quickSort(nelements, 0, nelements.length-1)));
		System.out.println(Arrays.toString(quickSort(arrayFromMatrix, 0, arrayFromMatrix.length-1)));
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
	
	
	public static int[] mergeSort(int [] arr){
		if(arr.length == 1 || arr.length == 0){
			return arr;
		}
		
		int [] leftArray = mergeSort(Arrays.copyOfRange(arr, 0, (arr.length/2)));
		int [] rightArray = mergeSort(Arrays.copyOfRange(arr, arr.length/2, arr.length));
		
		return merge(leftArray, rightArray);
	}

	private static int[] merge(int[] leftArray, int[] rightArray) {
		int [] mergedArray = new int[leftArray.length + rightArray.length];
		
		int lIndex = 0;
		int rIndex = 0;
		for(int i = 0; i < mergedArray.length; i++){
			if(rIndex >= rightArray.length || (lIndex < leftArray.length && leftArray[lIndex] < rightArray[rIndex])){
				mergedArray[i] = leftArray[lIndex];
				lIndex++;
			} else if (rIndex < rightArray.length){
				mergedArray[i] = rightArray[rIndex];
				rIndex++;
			}
		}
		
		return mergedArray;
	}
	
	
	static int currentCount = 0;
	
	public static int[] countInversions(int[] arr){
		
		if(arr.length == 1 || arr.length == 0){
			return arr;
		}
		
		int [] leftArray = countInversions(Arrays.copyOfRange(arr, 0, (arr.length/2)));
		int [] rightArray = countInversions(Arrays.copyOfRange(arr, arr.length/2, arr.length));
		
		return countSplit(leftArray, rightArray);
	}
	
	private static int[] countSplit(int[] leftArray, int[] rightArray) {
		int [] mergedArray = new int[leftArray.length + rightArray.length];
		
		int lIndex = 0;
		int rIndex = 0;
		
		for(int i = 0; i < mergedArray.length; i++){
			if(rIndex >= rightArray.length || (lIndex < leftArray.length && leftArray[lIndex] < rightArray[rIndex])){
				mergedArray[i] = leftArray[lIndex];
				lIndex++;
			} else if (rIndex < rightArray.length){
				currentCount += leftArray.length-lIndex;
				mergedArray[i] = rightArray[rIndex];
				rIndex++;
			}
		}
		
		return mergedArray;
	} 
	
	// Does not work for case: coins = {20,11,1}, amount = 22;
	public static int countMinimumCoinsForAmount(int [] coins, double amount){
		int cents = (int) (amount * 100);
		int numberOfCoins = 0; 
		for (int i = coins.length-1; i >=0; i--) {
			while(cents >= coins[i]){
				numberOfCoins++;
				cents -= coins[i];
				System.out.println(coins[i]);
			}
			if(cents == 0){
				break;
			}
		}
		return numberOfCoins;
	}
	
	// Coin Problem - Dynamic Programming
	public static int countMinimumCoinsForSum(int [] coins, double sum){
		int cents = (int) (sum * 100);
		
		if(cents == 0){
			return 0;
		}
		
		int [] sumsArray = new int[cents+1];
		for (int i = 0; i < sumsArray.length; i++) {
			sumsArray[i] = Integer.MAX_VALUE;
		}
		
		sumsArray[0] = 0;
		for(int i = 1; i <= cents; i++){
			for (int j = 0; j < coins.length; j++){
				if(coins[j] <= i && sumsArray[i-coins[j]]+1 < sumsArray[i]){
					sumsArray[i] = sumsArray[i-coins[j]]+1;
				}
			}
		}
		
		if(sumsArray[cents] == Integer.MAX_VALUE){
			return 0;
		}
		
		return sumsArray[cents];
	}
	
	public static int[] quickSort(int [] array, int leftEl, int rightEl) {
		if(rightEl - leftEl < 1){
			return array;
		}
		
		int randomPivot = (int) Math.floor(Math.random() * (rightEl-leftEl + 1)) + leftEl;
		int newPivot = quickPartition(array, leftEl, rightEl, randomPivot);
		
		quickSort(array, leftEl, newPivot-1);		
		quickSort(array, newPivot+1, rightEl);
		
		return array;
	}

	private static int quickPartition(int[] array, int leftEl, int rightEl, int pivot) {
		int divisionIndex = leftEl;
		int auxElement;
		
		for(int j = leftEl; j <= rightEl; j++) {
			if(array[pivot] > array[j]) {
				auxElement = array[divisionIndex];
				array[divisionIndex] = array[j];
				array[j] = auxElement;
				if(divisionIndex == pivot){
					pivot = j;
				}
				divisionIndex++;
			}
		}
		
		auxElement = array[divisionIndex]; 
		array[divisionIndex] = array[pivot];
		array[pivot] = auxElement;
		
		return divisionIndex;
	}
	
	// Only if the matrix is row ordered.
	public static int findKthElementInRowOrderedMatrix(int[][] matrix, int k) {
		int numberOfRows = matrix.length;
		int numberOfColumns = matrix[0].length;
		
		int rowIndexOfK = ((int) Math.ceil(k/numberOfRows)) - 1;
		int columnIndexOfK = k - rowIndexOfK*numberOfColumns - 1;
				
		return matrix[rowIndexOfK][columnIndexOfK];
	}
	
	// TODO Complete implementation
	public static int findKthElementInOrderedMatrix(int[][] matrix, int k, int end) {
		if(matrix.length == 0){
			return -1;
		}
		
		int numberOfRows = matrix.length;
		int numberOfColumns = matrix[0].length;
		
		int totalElementsInMatrix = numberOfRows*numberOfColumns;
		
		int pivot = (int) Math.random()*totalElementsInMatrix;
				
		int newPivotAfterPartition = partitionOfMatrix(matrix, k, pivot);
		if(newPivotAfterPartition == k){
			return newPivotAfterPartition;
		} else if(newPivotAfterPartition < k){
			return findKthElementInOrderedMatrix(matrix, k, newPivotAfterPartition); // k
		} else {
			return findKthElementInOrderedMatrix(matrix, k, newPivotAfterPartition); // k - pivot
		}
	}
	
	private static int partitionOfMatrix(int [][] matrix, int k, int pivot) {
		return 0;
	}
	
	private static int[][] rotateMatrix90right(int[][] matrix) {
		if(matrix.length < 1){
			return null;
		}
		int[][] rotatedMatrix = new int[matrix[0].length][matrix.length];
		
		for(int i = 0, k = matrix.length-1; i < matrix.length; i++, k--){
			for(int j = 0; j < matrix[i].length; j++){
				rotatedMatrix[j][k] = matrix[i][j];
			}
		}
		
		return rotatedMatrix;
	}
}
