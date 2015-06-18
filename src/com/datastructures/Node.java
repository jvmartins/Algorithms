package com.datastructures;

public class Node<E> {
	
	private Node<E> next;
	private Node<E> previous;
	private E value;
	
	public Node(Node<E> another){
		this.next = new Node<E>(another.next);
		this.previous = new Node<E>(another.previous);
		this.value = another.value;
	}
	
	public Node(E value, Node<E> next){
		this.next = next;
		this.value = value;
	}
	
	public Node(E value, Node<E> previous, Node<E> next){
		this.next = next;
		this.previous = previous;
		this.value = value;
	}
	
	public Node<E> getNext() {
		return next;
	}
	
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
	public E getValue() {
		return value;
	}
	
	public Node<E> getPrevious() {
		return previous;
	}
	
	public void setPrevious(Node<E> previous) {
		this.previous = previous;
	}
}
