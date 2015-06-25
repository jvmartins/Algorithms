package com.algorithms;

public class IntegerOperations {
	
	public static void main(String[] args) {
		System.out.println(recursivelyPower(10, 3, 10));
		System.out.println(recursivelyPower(2, 3, 2));
		System.out.println(recursivelyPower(2, 2, 2));
		System.out.println(recursivelyPower(2, 10, 2));
		System.out.println(recursivelyPower(8, 2, 8));
	}
	
	public static int recursivelyPower(int originalNumber, int power, int result){
		if(power == 1){
			return result;
		}
		int poweredNumber = originalNumber * result;
		power--;
		return recursivelyPower(originalNumber, power, poweredNumber);
	}
}
