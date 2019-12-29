/**
 * 
 * https://leetcode.com/problems/reverse-linked-list/
 * 
 */
package com.practice.ds.list;

import com.practice.ds.beans.ListNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ReverseLinkedList obj = new ReverseLinkedList();
		
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = null;
		
		ListNode newHead = obj.reverseList(one);
		obj.print(newHead);
	}
	
	public void print(ListNode n) {
		System.out.println();
		while (n != null ) {
			System.out.print(n.val);
			n = n.next;
		}
	}
	
	public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode h = head;
        
        while (p2 != null) {
        	
        	ListNode temp = p2.next;
        	
        	p1.next = p2.next;
        	p2.next = h;
        	h = p2;
        	
        	p2 = temp;
        	
        }
		return h;
    }
}
