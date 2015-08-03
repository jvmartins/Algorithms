package com.datastructures.linkedlist;

import java.util.ArrayList;
import java.util.List;

import com.datastructures.Node;

public class CustomDoublyLinkedList<E> {
	
	private Node<E> head;
	
	public void add(E value) {
		if(head == null){
			head = new Node<E>(value, null, null);
			return;
		}
		
		Node<E> currentLast = head;
		while(currentLast.getNext() != null) {
			currentLast = currentLast.getNext();
		}
		currentLast.setNext(new Node<E>(value, currentLast, null));
	}
	
	public CustomDoublyLinkedList<E> reverse() {
		if(head == null){
			return null;
		}
		
		Node<E> current = head;
		
		Node<E> next = null;
		Node<E> previous = null;
		
		while(current.getNext() != null){
			
			next = current.getNext();
			previous = current.getPrevious();
					
			current.setPrevious(next);
			current.setNext(previous);
			
			current = next;
		}
		
		previous = current.getPrevious();
		current.setNext(previous);
		current.setPrevious(null);
		
		head = current;
		
		return this;
	}
	
	/**
	 * @param index means how many indexes before last (0). E.g. second last -> 1
	 * @return
	 */
	public E getFromLast(int index) {
		if(head == null){
			return null;
		}
		
		List<Node<E>> list = new ArrayList<Node<E>>();
		
		Node<E> currentLast = head;
		int numberOfElements = 1;
		
		while(currentLast.getNext() != null){
			list.add(currentLast);
			numberOfElements++;
			currentLast = currentLast.getNext();
		}
		
		list.add(currentLast);
		
		return list.get(numberOfElements - index - 1).getValue();
	}
	
	@Override
	public String toString() {
		if(head == null){
			return "";
		}
		
		Node<E> currentLast = head;
		StringBuffer sb = new StringBuffer();
		
		String separator = "";
		while(currentLast.getNext() != null){
			sb.append(separator + currentLast.getValue());
			separator = ", ";
			currentLast = currentLast.getNext();
		}
		
		sb.append(separator + currentLast.getValue());
		
		return sb.toString();
	}

}
