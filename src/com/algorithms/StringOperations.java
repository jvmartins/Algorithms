package com.algorithms;

import java.util.Scanner;

public class StringOperations {
	
	public static void main (String [] args){
		Scanner sc = new Scanner(System.in);
		for(;;) {
			System.out.println("Input string: ");
			String string = sc.next();
		    System.out.println(getSizeLongestSubstringWithDifferentChars(string));
		}
	}
	
	/* Given s string, Find max size of a sub-string, in which no duplicate chars present. 
	 * aaabbbcdebghiaaaa
	 * aaaabbbb
	 * */
	public static int getSizeLongestSubstringWithDifferentChars(String word) {
		char[] chars = word.toCharArray();
		int maxLength = 1;
		String currentString = String.valueOf(chars[0]);
		for (int i = 1; i < chars.length; i++) {
			int charIndexOnCurrentString = currentString.indexOf(chars[i]);
			if(charIndexOnCurrentString == -1){
				currentString += String.valueOf(chars[i]);		
			} else {
				currentString += String.valueOf(chars[i]);
				currentString = currentString.substring(charIndexOnCurrentString+1);
			}
			
			if(currentString.length() > maxLength){
				maxLength = currentString.length();
			}
		}
		return maxLength;
	}
}
