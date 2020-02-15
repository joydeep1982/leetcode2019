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
		if (head == null || head.next == null || head.next.next == null) return head;
        ListNode eHead = null;
        ListNode eTail = null;
        
        ListNode ptr = head.next;
        ListNode prev = head;
        
        int count = 1;
        ListNode lastOddPtr = null;
        while (ptr != null) {
            count++;
            if (count % 2 == 0) {
                // when we enter this loop
                // ptr is on an even node
                // prev is on an odd node
                if (eHead == null) {
                    eHead = ptr;
                    eTail = ptr;
                }
                else {
                    eTail.next = ptr;
                    eTail = ptr;
                }
                prev.next = ptr.next;    
            }
            else {
            	lastOddPtr = ptr;
            }
            
            //eTail.next = null;
            
            // advance pointers
            prev = ptr;
            if (ptr.next == null && lastOddPtr != null) {
            	eTail.next = null;
            	lastOddPtr.next  = eHead;
            	break;
            }
            ptr = ptr.next;
        }
        
        return head;
	}
}
