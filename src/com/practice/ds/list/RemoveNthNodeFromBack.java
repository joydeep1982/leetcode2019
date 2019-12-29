/**
 * 
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 */
package com.practice.ds.list;

import com.practice.ds.beans.ListNode;
import com.practice.ds.miscell.Utils;

public class RemoveNthNodeFromBack {
	
	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = null;
		
		RemoveNthNodeFromBack obj = new RemoveNthNodeFromBack();
		obj.removeNthFromEnd(l1, 2);
		Utils.print(l1);
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode ptr = head, pos = head, prev = null;
		int counter = 1;
		while (ptr.next != null) {
			
			if (counter >= n) {
				prev = pos;
				pos = pos.next;
			}
			
			counter++;
			ptr = ptr.next;
		}
		
		//first element
		if (pos == head) {
			head = pos.next;
		}
		
		//last element
		else if (pos.next == null) {
			prev.next = null;
		}
		
		//somewhere in between
		else {
			prev.next = pos.next;
		}
		
		return head;
    }
}