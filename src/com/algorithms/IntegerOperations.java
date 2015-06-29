package com.algorithms;

public class IntegerOperations {
	
	public static void main(String[] args) {
		//System.out.println(recursivelyPower(10, 3, 10));
		//System.out.println(recursivelyPower(2, 3, 2));
		//System.out.println(recursivelyPower(2, 2, 2));
		//System.out.println(recursivelyPower(2, 10, 2));
		//System.out.println(recursivelyPower(8, 2, 8));
		
		/*
		System.out.println(printRomanNumerals(800));
		System.out.println(printRomanNumerals(1201));
		System.out.println(printRomanNumerals(7821));
		System.out.println(printRomanNumerals(6));
		System.out.println(printRomanNumerals(141));
		System.out.println(printRomanNumerals(52));
		System.out.println();
		System.out.println(printRomanNumeralsFromEnum(800));
		System.out.println(printRomanNumeralsFromEnum(1201));
		System.out.println(printRomanNumeralsFromEnum(7821));
		System.out.println(printRomanNumeralsFromEnum(6));
		System.out.println(printRomanNumeralsFromEnum(141));
		System.out.println(printRomanNumeralsFromEnum(52));
		*/
		
	}
	
	public static int recursivelyPower(int originalNumber, int power, int result){
		if(power == 1){
			return result;
		}
		int poweredNumber = originalNumber * result;
		power--;
		return recursivelyPower(originalNumber, power, poweredNumber);
	}
	
	
	static String [] romanNumerals = {"I","V","X","L","C","D","M"};
	
	public static String printRomanNumerals(int num) {
		String romanConverted = "";
		if( num/1000 > 0 ){
			int thousands = num/1000;
			romanConverted += getNumeralForIndex(thousands, 6);
			num -= thousands*1000;
		}
		
		if( num/100 > 0 ){
			int hundreds = num/100;
			romanConverted += getNumeralForIndex(hundreds, 4);
			num -= hundreds*100;
		}
		
		if( num/10 > 0 ){
			int decs = num/10;
			romanConverted += getNumeralForIndex(decs, 2);
			num -= decs*10;
		}
		
		romanConverted += getNumeralForIndex(num, 0);
		
		return romanConverted;
	}
	
	private static String getNumeralForIndex(int partialNum, int index) {
		String romanNumeral = "";
		if(index == 6){
			romanNumeral += repeatString(romanNumerals[index], partialNum);
		} else {
			if (partialNum <= 3){
				romanNumeral += repeatString(romanNumerals[index], partialNum); 
			} else if(partialNum == 4){
				romanNumeral += romanNumerals[index] + romanNumerals[index+1];
			} else if(partialNum > 4 && partialNum < 9){
				romanNumeral += romanNumerals[index+1] + repeatString(romanNumerals[index], partialNum-5);
			} else if(partialNum == 9){
				romanNumeral += romanNumerals[index] + romanNumerals[index+2];
			}
		}
		return romanNumeral;
	}
	
	private static String repeatString (String str, int times){
		String repeated = "";
		for(int i = 1; i <= times; i++){
			repeated += str;
		}
		return repeated;
	}
	
	
	public static String printRomanNumeralsFromEnum(int num){
		RomanNumerals [] numerals = RomanNumerals.values();
		String romanNumber = "";
		for (int i = numerals.length-1; i >=0 ; i--) {
			while(num >= numerals[i].value){
				romanNumber += numerals[i];
				num -= numerals[i].value;
			}
		}
		
		return romanNumber;
		
	}
	
	enum RomanNumerals {
		I(1),IV(4),V(5),IX(9),X(10),XL(40),L(50),XC(90),C(100),CD(400),D(500),CM(900),M(1000);
		int value;
		
		private RomanNumerals(int value) {
			this.value = value;
		}
	}
	
	int a;
	
	public static int[] consecutiveSequenceLargestSum(int [] array){
		
		
		return new int[1];
	}
}
