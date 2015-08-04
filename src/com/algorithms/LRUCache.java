package com.algorithms;

import java.util.HashMap;

public class LRUCache {
    
    HashMap<Integer, Node> cache = new HashMap<Integer, Node>();
    
    Node start;
    Node end;
    
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(this.cache.size() == 0){
            return -1;
        }
        
        Node least = this.cache.get(key);
        if(least == null) {
            return -1;
        }
        
        setToHead(least);
        
        return least.getValue();
    }

	private void setToHead(Node least) {
		if(this.cache.size() > 1) {
			Node nextNode = least.getNext();
			Node prevNode = least.getPrev();
			
			if(this.start.equals(least)){
	            this.start = nextNode;
	            this.start.setPrev(null);
	        }
			
			if(!this.end.equals(least)) {
				if(prevNode != null){
					prevNode.setNext(nextNode);
				}
				if(nextNode != null){
					nextNode.setPrev(prevNode);
				}
				least.setPrev(end);
	            end.setNext(least);
			}
        }
        
        least.setNext(null);
        this.end = least;
	}
    
    public void set(int key, int value) {
        if(cache.size() >= capacity && !cache.containsKey(key)) {
            this.remove();
        }
        
        Node newNode = this.cache.get(key);
        if(newNode == null) {
        	newNode = new Node(key, value);
        } else {
        	newNode.setValue(value);
        	setToHead(newNode);
        	return;
        }
        
        if(cache.size() == 0) {
            this.start = newNode;
            this.end = newNode;
        } else if (!cache.containsKey(key)){
            this.end.setNext(newNode);
            newNode.setPrev(this.end);
            this.end = newNode;
        }
        
        cache.put(key, newNode);
    }
    
    private void remove() {
        Node nextStart = this.start.getNext();
        cache.remove(this.start.getKey());
        if(nextStart != null) {
            nextStart.setPrev(null);
            this.start = nextStart;    
        } else {
            this.start = null;
        }
    }
}

class Node {
    
    int key;
    int value;
    
    Node next;
    Node prev;
    
    public Node (int key, int value) {
        this.key = key;
        this.value = value;
    }
    
    public Node getNext() {
        return this.next;
    }
    
    public Node getPrev() {
        return this.prev;
    }
    
    public void setNext(Node next) {
        this.next = next;
    }
    
    public void setPrev(Node prev) {
        this.prev = prev;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public void setValue(int value) {
		this.value = value;
	}
    
    public int getKey() {
        return this.key;
    }
    
}