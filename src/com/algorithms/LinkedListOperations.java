package com.algorithms;

import java.util.Iterator;
import java.util.LinkedList;

import com.datastructures.linkedlist.CustomDoublyLinkedList;
import com.datastructures.linkedlist.CustomLinkedList;


public class LinkedListOperations {
	
	public static void main (String [] args){
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("First");
		linkedList.add("Second");
		linkedList.add("Third Last");
		linkedList.add("Second Last");
		linkedList.add("Last");
		
		//System.out.println(secondLastOfLinkedListInJava(linkedList));
		//System.out.println(reverseLinkedListInJava(linkedList));
		
		CustomLinkedList<String> amznLinkedList = new CustomLinkedList<String>();
		amznLinkedList.add("First");
		amznLinkedList.add("Second");
		amznLinkedList.add("Third Last");
		amznLinkedList.add("Second Last");
		amznLinkedList.add("Real Second Last");
		amznLinkedList.add("Last");
		
		//System.out.println(amznLinkedList);
		//System.out.println(amznLinkedList.getFromLast(1));
		//System.out.println(amznLinkedList.getFromLast(0));
		
		CustomDoublyLinkedList<String> amznDblyLinkedList = new CustomDoublyLinkedList<String>();
		amznDblyLinkedList.add("DB First");
		amznDblyLinkedList.add("DB Second");
		amznDblyLinkedList.add("DB Third Last");
		amznDblyLinkedList.add("DB Second Last");
		amznDblyLinkedList.add("DB Real Second Last");
		amznDblyLinkedList.add("DB Last");
		
		System.out.println(amznDblyLinkedList.reverse());
	}
	
	/* Using Java LinkedList to find second last element */
	public static String secondLastOfLinkedListInJava(LinkedList<String> linkedList) {
	    LinkedList<String> cloned = (LinkedList<String>) linkedList.clone();
	    cloned.pollLast();
	    return cloned.pollLast();
	}
	
	/* Using Java LinkedList to revert Linked List */
	public static LinkedList<String> reverseLinkedListInJava(LinkedList<String> linkedList) {
		LinkedList<String> reverted = new LinkedList<String>();
		Iterator<String> it = linkedList.descendingIterator();
		while(it.hasNext()){
			reverted.add((String) it.next());
		}
		return reverted;
	}
	
	boolean hasLoop(Node first) {

	    if(first == null) // list does not exist..so no loop either.
	        return false;

	    Node slow, fast; // create two references.

	    slow = fast = first; // make both refer to the start of the list.

	    while(true) {

	        slow = slow.next;          // 1 hop.

	        if(fast.next != null)
	            fast = fast.next.next; // 2 hops.
	        else
	            return false;          // next node null => no loop.

	        if(slow == null || fast == null) // if either hits null..no loop.
	            return false;

	        if(slow == fast) // if the two ever meet...we must have a loop.
	            return true;
	    }
	}
}
