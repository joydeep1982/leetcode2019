package com.practice.ds;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	Map<Integer, Node> cache;

	int count;

	int capacity;

	Node head;

	public LRUCache(int capacity) {
		this.cache = new HashMap<Integer, Node>(capacity);
		this.count = 0;
		this.capacity = capacity;
		head = null;
	}

	public int get(int key) {
		Node retrievedNode = cache.get(key);
		if (retrievedNode == null) {
			return -1;
		}
		getNodeToFront(retrievedNode);
		return retrievedNode.val;
	}

	private void getNodeToFront(Node node) {
		if (node == head) {
			return;
		}
		
		// previous node next point to next node
		node.prev.next = node.next;
		// if next node is not null next node's previous points to previous node
		if (node.next != null) {
			node.next.prev = node.prev;
		}
		node.prev = null;
		head.prev = node;
		node.next = head;
		head = node;
	}

	public void put(int key, int value) {
		
		if (key == 9 && value == 29) {
			System.out.println("my breakpoint");
		}
		
		if (cache.get(key) != null) {
			Node data = cache.get(key);
			if (data != null && data.val != -1) {
				data.val = value;
				getNodeToFront(data);
				return;
			}
		}
		
		count++;
		if (count > capacity) {
			count = capacity;
			Node tail = head;
			while (tail != null && tail.next != null) {
				tail = tail.next;
			}
			cache.put(tail.key, null);
			if (head == tail) {
				head = null;
			}
			else {
				tail.prev.next = null;
			}
		}
		
		Node newData = new Node(key, value);
		if (head != null) {
			head.prev = newData;
			newData.next = head;
		}
		head = newData;
		cache.put(key, newData);
		
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(10);
//		cache.put(1, 1);
//		cache.put(2, 2);
//		System.out.println(cache.get(1));       // returns 1
//		cache.put(3, 3);    // evicts key 2
//		System.out.println(cache.get(2));       // returns -1 (not found)
//		cache.put(4, 4);    // evicts key 1
//		System.out.println(cache.get(1));       // returns -1 (not found)
//		System.out.println(cache.get(3));       // returns 3
//		System.out.println(cache.get(4));       // returns 4
		
//		cache.put(2, 1);
//		cache.put(1, 1);
//		cache.put(2, 3);
//		cache.put(4, 1);
//		System.out.println(cache.get(1)); // returns 1
//		System.out.println(cache.get(2)); // returns -1
		
		/**
		 * 
		 * ["LRUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"]
		   [[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]
		 * 
		 */
		
		String[] commands = new String[] {"put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"};
		int[][] data = new int[][]{{10,13},{3,17},{6,11},{10,5},{9,10},{13},{2,19},{2},{3},{5,25},{8},{9,22},{5,5},{1,30},{11},{9,12},{7},{5},{8},{9},{4,30},{9,3},{9},{10},{10},{6,14},{3,1},{3},{10,11},{8},{2,14},{1},{5},{4},{11,4},{12,24},{5,18},{13},{7,23},{8},{12},{3,27},{2,12},{5},{2,9},{13,4},{8,18},{1,7},{6},{9,29},{8,21},{5},{6,30},{1,12},{10},{4,15},{7,22},{11,26},{8,17},{9,29},{5},{3,4},{11,30},{12},{4,29},{3},{9},{6},{3,4},{1},{10},{3,29},{10,28},{1,20},{11,13},{3},{3,12},{3,8},{10,9},{3,26},{8},{7},{5},{13,17},{2,27},{11,15},{12},{9,19},{2,15},{3,16},{1},{12,17},{9,1},{6,19},{4},{5},{5},{8,1},{11,7},{5,2},{9,28},{1},{2,2},{7,4},{4,22},{7,24},{9,26},{13,28},{11,26}};
		
		for (int i = 0; i < commands.length; i++) {
			String cmd = commands[i];
			if (cmd.equalsIgnoreCase("put")) {
				System.out.println("put " + data[i][0] + " " + data[i][1]);
				cache.put(data[i][0], data[i][1]);
			}
			else if (cmd.equalsIgnoreCase("get"))  {
				System.out.println("put " + data[i][0]);
				cache.get(data[i][0]);
			}
		}
		
		cache.put(10, 13);

//		cache.put(2, 1);
//		cache.put(2, 2);
//		System.out.println(cache.get(2));
//		cache.put(1, 1);
//		cache.put(4, 1);
		//System.out.println(cache.get(2));

	}
}

class Node {
	Integer key;
	Integer val;
	Node prev;
	Node next;
	public Node(int key, int val) {
		this.key = key;
		this.val = val;
	}
}