package com.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LRUCacheTest {
	
	@Test
	public void testCache() {
		LRUCache cache = new LRUCache(2);
		
		// Input: 2,[set(2,1),set(1,1),set(2,3),set(4,1),get(1),get(2)]
		// Expected: [-1,3]
		
		cache.set(2,1);
		cache.set(1,1);
		cache.set(2,3);
		cache.set(4,1);
		
		int value = cache.get(1);
		assertEquals(value, -1);
		
		value = cache.get(2);
		assertEquals(value, 3);
	}
	
}

