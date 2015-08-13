package com.algorithms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RotateLinkedList {
	
	public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }
        
        ListNode fastNext = head;
        int numberOfElements = 1;
        for (int i = 0; i < k; i++) {
            if(fastNext.next == null){
                continue;
            }
            numberOfElements++;
            fastNext = fastNext.next;
        }
        
        if(numberOfElements == k){
        	return head;
        } else if(numberOfElements < k) {
        	return rotateRight(head, k % numberOfElements);
        }
        
        ListNode next = head;
        while (fastNext.next != null) {
            fastNext = fastNext.next;
            next = next.next;
        }
        
        fastNext.next = head;
        
        if(next.next != null){
            fastNext = next.next;
        }
        
        next.next = null;
        
        return fastNext;
    }
    
    class ListNode {
    	int val;
    	ListNode next;
    	ListNode (int x) {
    		val = x;
    	}
    }
	
    @Test
    public void testRotateLinkedList(){
    	ListNode head = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	head.next = n2;
    	
    	ListNode nh1 = rotateRight(head, 2);
    	assertEquals(nh1.val, 1);
    	
    	ListNode nh2 = rotateRight(head, 2000000);
    	assertEquals(nh2.val, 1);
    }
	    
}
