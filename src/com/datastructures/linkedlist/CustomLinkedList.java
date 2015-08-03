package com.datastructures.linkedlist;

import java.util.ArrayList;
import java.util.List;

import com.datastructures.Node;

public class CustomLinkedList<E> {
	
	private Node<E> head;
	
	public void add(E value) {
		if(head == null){
			head = new Node<E>(value, null);
			return;
		}
		
		Node<E> currentLast = head;
		while(currentLast.getNext() != null) {
			currentLast = currentLast.getNext();
		}
		currentLast.setNext(new Node<E>(value, null));
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
