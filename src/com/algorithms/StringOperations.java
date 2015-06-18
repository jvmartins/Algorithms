package com.algorithms;

import java.util.Scanner;

public class StringOperations {
	
	public static void main (String [] args){
		Scanner sc = new Scanner(System.in);
		for(;;) {
			System.out.println("Input string: ");
			String string = sc.nextLine();
		    // System.out.println(getSizeLongestSubstringWithDifferentChars(string));
			// System.out.println(reverseString(string));
			// System.out.println(reverseStringInJava(string));
			System.out.println(countOccurrencies(string, '1'));
		}
	}
	
	/* Reverse a string */
	public static String reverseString(String str) {
	    int length = str.length();
	    StringBuffer sb = new StringBuffer(length);
	    for(int i = length-1; i >= 0; i--){
	        sb.append(str.charAt(i));
	    }
	    return sb.toString();
	} 
	
	/* Reverse a string with Java abstraction StringBuffer */
	public static String reverseStringInJava(String string) {
		return new StringBuffer(string).reverse().toString();
	}
	
	
	/* Count all ones (or any character occurrence) in binary string */
	public static int countOccurrencies(String string, char toFind) {
		char [] chars = string.toCharArray();
		int count = 0;
		for (char c : chars){
			if(c == toFind) {
				count++;
			}
		}
		return count;
	}

	public static String convertStringToBinary(String string) {
		byte [] bites = string.getBytes();
		StringBuffer sb = new StringBuffer();
		for(byte b : bites) {
			sb.append(Integer.toBinaryString(b));
		}
		return sb.toString();
	}

	/* Given s string, Find max size of a sub-string, in which no duplicate chars present. 
	 * aaabbbcdebghiaaaa
	 * aaaabbbb
	 * aaddaaaaaaabcbbbbbbbb
	 * */
	public static int getSizeLongestSubstringWithDifferentChars(String word) {
		char[] chars = word.toCharArray();
		int maxLength = 1;
		String currentString = String.valueOf(chars[0]);
		for (int i = 1; i < chars.length; i++) {
			int charIndexOnCurrentString = currentString.indexOf(chars[i]);
			currentString += String.valueOf(chars[i]);
			if(charIndexOnCurrentString > -1){
				currentString = currentString.substring(charIndexOnCurrentString+1);
			}
			if(currentString.length() > maxLength){
				maxLength = currentString.length();
			}
		}
		return maxLength;
	}
}
