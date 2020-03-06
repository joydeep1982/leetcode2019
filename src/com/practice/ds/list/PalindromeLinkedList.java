/**
 * 
 * https://leetcode.com/problems/palindrome-linked-list/
 * 
 */
package com.practice.ds.list;

import com.practice.ds.beans.ListNode;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode _two = new ListNode(3);
		ListNode __two = new ListNode(2);
		ListNode _one = new ListNode(1);

//		ListNode junk = new ListNode(2312);

		one.next = two;
		two.next = _two;
		_two.next = __two;
		__two.next = _one;
//		_one.next = junk;

		PalindromeLinkedList o = new PalindromeLinkedList();
		boolean b = o.isPalindrome(one);
		System.out.println(b);
	}
	
	public boolean isPalindrome(ListNode head) {
		return isPalindrome(head, head) == null;
	}

	public ListNode isPalindrome(ListNode head, ListNode node) {
		ListNode n1 = head;
		if (node.next != null) {
			n1 = isPalindrome(head, node.next);
		}
		
		if (validate(n1, node)) {
			return n1.next;
		}
		return new ListNode(Integer.MAX_VALUE);
	}
	
	public boolean validate(ListNode node1, ListNode node2) {
		if (node1 == null && node2 == null) {
			return true;
		}
		else if (node1 == null || node2 == null) {
			return false;
		}
		System.out.println(node1.val + ", " + node2.val);
		return node1.val == node2.val;
	}

//	public ListNode validate(ListNode head, ListNode node) {
//		if (node == null) {
//			return head;
//		}
//
//		ListNode n1 = validate(head, node.next);
//		if (n1 == null) {
//			return null;
//		}
//		System.out.println(node.val + " " + n1.val);
//		if (node.val != n1.val) {
//			return null;
//		}
//		
//		return n1.next;
//	}
}
