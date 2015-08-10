package com.algorithms;

import org.junit.Test;

public class BalancedBrackets {
	 
		public void brackets(int n) {
			System.out.println(n);
			recursiveBrackets("", 0, 0, n);
	    }
		
	    private void recursiveBrackets(String output, int open, int close, int numberOfBrackets) {
	        if((open == numberOfBrackets/2) && (close == numberOfBrackets/2)) {
	            System.out.println(output);
	        } else {
	            if(open < numberOfBrackets/2) {
	            	recursiveBrackets(output + "(", open+1, close, numberOfBrackets);
	            }
	            if(close < open) {
	            	recursiveBrackets(output + ")", open, close+1, numberOfBrackets);
	            }
	        }
	    }
	    
	    @Test
	    public void testBrackets () {
	    	brackets(2);
	    	brackets(4);
	    	brackets(6);
	    }
}
