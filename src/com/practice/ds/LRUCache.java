package com.practice.ds;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	
	Map<Integer, Node> cache;
	
	int counter;
	
	int capacity;
	
	Node head;
	
	public LRUCache(int capacity) {
		this.cache = new HashMap<Integer, Node>(capacity);
		this.counter = 0;
		this.capacity = capacity;
		head = null;
	}

	public int get(int key) {
		Node currNode = cache.get(key);
		if (currNode == null) {
			return -1;
		}
		if (currNode.prev != null) {
			currNode.prev.next = currNode.next;
		}
		if (capacity != 1) {
			currNode.prev = null;
			currNode.next = head;
			head.prev = currNode;
			head = currNode;
		}
		return currNode.val;
	}

	public void put(int key, int value) {
		Node data = this.cache.get(key);
		if (data != null) {
			data.val = value;
		} else {
			counter++;
			data = new Node();
			data.key = key;
			data.val = value;
			data.next = head;
			data.prev = null;
			if (head != null) {
				head.prev = data;
			}
			head = data;	
		}
		
		
		this.cache.put(key, data);
		if (counter > capacity) {
			Node temp = head;
			while (temp.next != null) {
				temp =  temp.next;
			}
			if (temp.prev != null)  {
				temp.prev.next = null;
			}
			this.cache.remove(temp.key);
			counter--;
		}
	}
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
//		cache.put(1, 1);
//		cache.put(2, 2);
//		System.out.println(cache.get(1));       // returns 1
//		cache.put(3, 3);    // evicts key 2
//		System.out.println(cache.get(2));       // returns -1 (not found)
//		cache.put(4, 4);    // evicts key 1
//		System.out.println(cache.get(1));       // returns -1 (not found)
//		System.out.println(cache.get(3));       // returns 3
//		System.out.println(cache.get(4));       // returns 4
		
		cache.put(2, 1);
		cache.put(2, 2);
		System.out.println(cache.get(2));
		cache.put(1, 1);
		cache.put(4, 1);
		System.out.println(cache.get(2));
		
	}
}

class Node {
	Integer key;
	Integer val;
	Node prev;
	Node next;
}