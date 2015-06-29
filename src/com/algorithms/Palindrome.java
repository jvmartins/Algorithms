package com.algorithms;

import java.util.Scanner;

public class Palindrome {
	
	public static void main (String [] args){
		Scanner sc = new Scanner(System.in);
		for(;;) {
			System.out.println("Input string: ");
			String string = sc.next();
		    //System.out.println(isPalindrome(string));
			System.out.println(completeAPalindrome(string));
		}
	}
	
	/* Given a string check if it is a Palindrome */
	public static boolean isPalindrome (String word) {
		char[] chars = word.toCharArray();
		for(int i = 0, j = chars.length-1; j-i >= 2; i++, j--){
			if(chars[i] == chars[j]) {
				continue;
			} 
			return false;
		}
		return true;
	}
	
	/* Identify what needs to be added at the end of a word to make it a palindrome */
	public static String completeAPalindrome(String word) {
		char[] chars = word.toCharArray();
		int last = chars.length-1;
		int startIndexOfCompletion = -1;
		String completion = ""; 
		
		for(int k = 0; k < chars.length-1; k++){
			if(chars[k] == chars[last]) {
				last--;
			} else {
				startIndexOfCompletion = k;
				last = chars.length-1;
				if(chars[k] == chars[last]) {
					last--;
					startIndexOfCompletion = k-1;
				}
			}
		}
		
		while(startIndexOfCompletion >= 0){
			completion += "" + chars[startIndexOfCompletion];
			startIndexOfCompletion--;
		}
		
		return completion;
	}
}
