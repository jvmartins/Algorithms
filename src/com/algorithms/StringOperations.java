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
			// System.out.println(countOccurrencies(string, '1'));
			// System.out.println(getNumberAsText(Integer.valueOf(string)));
			// System.out.println(revertOrderWords(string));
			
			// String string2 = sc.nextLine();
			// System.out.println(getCommonContiguousIntersection(string, string2));
		}
	}
	
	public static String revertOrderWords(String str){
		String [] arrWords = str.split("\\s");
		String revertedWords = "";
		String separator = "";
		for (int i = arrWords.length-1; i >= 0; i--) {
			revertedWords += separator + arrWords[i];
			separator = " ";
		}
		return revertedWords;
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
	
	static String [] uni = {
			"","one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
			"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
	static String [] dec = {
			"twenty","thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	static String [] mi = {
			"hundred", "thousand", "million"};
	
	
	
	public static String getNumberAsText(int number){
		
		String numberStr = String.valueOf(number);
		int length = numberStr.length();
		if(length <= 3){
			return getHundredsAsText(numberStr);
		} else {
			int digits = (int) Math.ceil(((double)length)/3) - 1;
			String leftPart = numberStr.substring(0, length - (digits * 3));
			int rightPart = Integer.valueOf(numberStr.substring(length - (digits * 3))); 
			String mill = mi[digits];
			return getHundredsAsText(leftPart) + "-" + mill + "-" + getNumberAsText(rightPart);
		}
		
	}
	
	public static String getHundredsAsText(String numberStr) {
		if(numberStr.length() == 3){
			int hundred = Integer.valueOf(""+numberStr.charAt(0));
			String h = uni[hundred];
			return h + "-" + mi[0] + "-" + getDecimalAsText(numberStr.substring(1));
		}
		return getDecimalAsText(numberStr);
	}

	private static String getDecimalAsText(String substring) {
		int decimal = Integer.valueOf(substring);
		if(decimal < 20){
			return uni[decimal];
		}
		int decimalChar = Integer.valueOf(substring.substring(0, 1));
		int unitChar = Integer.valueOf(substring.substring(1));
		
		return dec[decimalChar-2] + "-" + uni[unitChar];
	}
	
	
	private static String getCommonContiguousIntersection(String list1, String list2) {
		String listUsed = "";
		String listCompared = "";
		if(list1.length() < list2.length()) {
			listUsed = list1;
			listCompared = list2;
		} else {
			listUsed = list2;
			listCompared = list1;
		}
		
		for(int size = listUsed.length(); size > 1; size--){
			for(int i = 0; i <= listUsed.length()-size; i++){
				String substr = "";
				if(size+i == listUsed.length()){
					substr = listUsed.substring(i);
				} else {
					substr = listUsed.substring(i, size+i);
				}
				if(listCompared.contains(substr)){
					return substr;
				}
			}
		}
		return null;
	}
}
