package com.algorithms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinimumSumSubArray {
	
	/* Given an array of n positive integers and a positive integer s, 
	 * find the minimal length of a subarray of which the sum ≥ s. 
	 * If there isn't one, return 0 instead.

	For example, given the array [2,3,1,2,4,3] and s = 7,
	the subarray [4,3] has the minimal length under the problem constraint. */
	
	public int minSubArrayLen(int s, int[] nums) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		if(nums[0] >= s) {
			return 1;
		}
		
		int minSum = Integer.MAX_VALUE;
		
		int begin = 0;
		int end = 1;
		
		int currentSum = nums[0];
		
		while (begin < nums.length) {
			if(currentSum >= s) {
				if((end - begin) < minSum) {
					minSum = end - begin;
				}
				
				currentSum -= nums[begin];
				begin++;
			} else {
				if(end >= nums.length) {
					break;
				}
				currentSum += nums[end];
				end++;
			}
		}
		
		if(minSum == Integer.MAX_VALUE) {
			return 0;
		}
		return minSum;
    }
	
	@Test
	public void dummyTest(){
		int [] nums = {2,3,1,2,4,3};
		int minSubArrayLen = minSubArrayLen(7, nums);
		
		assertEquals(minSubArrayLen, 2);
	}
}
