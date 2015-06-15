package com.algorithms;

import java.util.Scanner;

public class RunLength {
	
	public static void main (String [] args){
		Scanner sc = new Scanner(System.in);
		for(;;) {
			System.out.println("Input string: ");
			String string = sc.next();
		    System.out.println(getStringAsRunLength(string));
		}
	}
	
	/* Get string in run length */
	public static String getStringAsRunLength (String word) {
		char[] chars = word.toCharArray();
		char previousChar = chars[0];
		String runLengthString = String.valueOf(previousChar);
		int charRepetition = 1;
		
		for (int i = 1; i < chars.length; i++) {
			if(previousChar == chars[i]){
				charRepetition++;
			} else {
				if(charRepetition >= 2){
					runLengthString += charRepetition;
				}
				charRepetition = 1;
				previousChar = chars[i];
				
				runLengthString += String.valueOf(previousChar);
			}
		}
		runLengthString += charRepetition;
		return runLengthString;
	}
}
