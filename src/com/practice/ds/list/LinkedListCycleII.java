/**
 * 
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * 
 */
package com.practice.ds.list;

import com.practice.ds.beans.ListNode;

public class LinkedListCycleII {

	public static void main(String[] args) {
		LinkedListCycleII obj = new LinkedListCycleII();

		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = one;
		
		ListNode loopStart = obj.detectCycle(one);
		System.out.println(loopStart.val);
		
	}

	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return head;
		ListNode p1 = head;
		ListNode p2 = head;

		while (p2 != null && p1 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			if (p1 == p2) {
				break;
			}
		}

		if (p2 == null || p2.next == null) {
			return null;
		}

		p1 = head;

		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p1;
	}
}
