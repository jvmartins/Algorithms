package com.algorithms;

import java.util.Scanner;

public class Palindrome {
	
	public static void main (String [] args){
		Scanner sc = new Scanner(System.in);
		for(;;) {
			System.out.println("Input string: ");
			String string = sc.next();
		    System.out.println(isPalindrome(string));
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
}
