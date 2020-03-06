/**
 * 
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * 
 */
package com.practice.ds.list;

public class CopyListWithRandomPointer {

	public static void main(String[] args) {

		Node seven = new Node(7);
		Node thirteen = new Node(13);
		Node eleven = new Node(11);
		Node ten = new Node(10);
		Node one = new Node(1);

		seven.next = thirteen;
		thirteen.next = eleven;
		eleven.next = ten;
		ten.next = one;

		seven.random = null;
		thirteen.random = seven;
		eleven.random = null;
		ten.random = eleven;
		one.random = seven;
		
		Node node = seven;
		while (node != null) {
			System.out.println(node.val + ", " + (node.random == null ? null : node.random.val));
			node = node.next;
		}
		
		System.out.println();
		System.out.println();

		CopyListWithRandomPointer o = new CopyListWithRandomPointer();
		node = o.copyRandomList(seven);
		
		while (node != null) {
			System.out.println(node.val + ", " + (node.random == null ? null : node.random.val));
			node = node.next;
		}
	}

	public Node copyRandomList(Node head) {
		Node ptr = head;
		while (ptr != null) {
			Node newNode = new Node(ptr.val);
			Node temp = ptr.next;
			ptr.next = newNode;
			newNode.next = temp;
			newNode.random = ptr.random;
			ptr = temp;
		}
		
		
		ptr = head;
		while (ptr != null) {
			Node cloneNode = ptr.next;
			Node temp = cloneNode.next;
			cloneNode.random = cloneNode.random == null ? null : cloneNode.random.next;
			ptr = temp;
		}

		ptr = head;
		Node newHead = null;
		while (ptr != null) {
			Node cloneNode = ptr.next;
			Node temp = cloneNode.next;
			if (newHead == null) {
				newHead = cloneNode;
			}
			
			cloneNode.random = cloneNode.random == null ? null : cloneNode.random;
			ptr.next = cloneNode.next == null ? null : cloneNode.next;
			cloneNode.next = ptr.next == null ? null : ptr.next.next;
			ptr = temp;
		}

		return newHead;
	}

}

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}
