/**
 * 
 * https://leetcode.com/problems/odd-even-linked-list/
 * 
 */
package com.practice.ds.list;

import com.practice.ds.beans.ListNode;

public class OddEvenLinkedList {
	
	public static void main(String[] args) {
		OddEvenLinkedList obj = new OddEvenLinkedList();
		
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		ListNode six = new ListNode(6);
		ListNode seven = new ListNode(7);
		ListNode eight = new ListNode(8);
		ListNode nine = new ListNode(9);
		ListNode ten = new ListNode(10);
		
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		six.next = seven;
		seven.next = eight;
		eight.next = nine;
		nine.next = ten;
		ten.next =  null;
		
		obj.print(one);
		
		ListNode result = obj.oddEvenList(one);
		obj.print(result);
	}
	
	public void print(ListNode node) {
		System.out.println();
		while(node != null) {
			System.out.print(node.val + " => ");
			node = node.next;
		}
	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode odd = head;
		ListNode prev_odd = head;
		int counter = 0;
		ListNode prev = null;

		while (odd.next != null) {
			prev = odd;
			odd = odd.next;
			counter++;

			if (counter % 2 == 0) {
				if(counter == 10) {
					System.out.println(counter);
				}
				prev.next = odd.next;
				odd.next = prev;
				prev_odd.next = odd;

				ListNode temp = odd;
				odd = prev;
				prev = temp;
			}
		}
		
		return head;
	}
}
