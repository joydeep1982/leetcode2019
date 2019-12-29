/**
 * 
 * https://leetcode.com/problems/add-two-numbers/submissions/
 * 
 */
package com.practice.ds.list;

import com.practice.ds.beans.ListNode;
import com.practice.ds.miscell.Utils;

public class AddTwoNumbers {

	public static void main(String[] args) {

//		ListNode l1 = new ListNode(9);
//		l1.next = null;
//	
//		ListNode l2 = new ListNode(1);
//		ListNode l3 = new ListNode(9);
//		ListNode l4 = new ListNode(9);
//		ListNode l5 = new ListNode(9);
//		ListNode l6 = new ListNode(9);
//		ListNode l7 = new ListNode(9);
//		ListNode l8 = new ListNode(9);
//		ListNode l9 = new ListNode(9);
//		ListNode l10 = new ListNode(9);
//		ListNode l11 = new ListNode(9);
//		l2.next = l3;
//		l3.next = l4;
//		l4.next = l5;
//		l5.next = l6;
//		l6.next = l7;
//		l7.next = l8;
//		l8.next = l9;
//		l9.next = l10;
//		l10.next = l11;
//		l11.next = null;

		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		l1.next = null;
		l2.next = l3;
		l3.next = null;

		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(6);
		ListNode l6 = new ListNode(4);
		l4.next = null;
		l5.next = l6;
		l6.next = null;

		AddTwoNumbers obj = new AddTwoNumbers();

		Utils.print(obj.sum(l1, l4));
//		ListNode l = new AddTwoNumbers().generateListNode(123);
//		new AddTwoNumbers().print(l);
	}

	public ListNode sum(ListNode l1, ListNode l2) {

		ListNode head = new ListNode(-1), temp, prev = head;
		boolean carry = false;

		while (l1 != null || l2 != null) {

			int num1 = l1 != null ? l1.val : 0;
			int num2 = l2 != null ? l2.val : 0;
			int sum = num1 + num2 + (carry ? 1 : 0);
			carry = sum >= 10;
			int val = sum % 10;

			temp = new ListNode(val);
			temp.next = null;
			prev.next = temp;
			prev = temp;

			if (l1 != null) {
				l1 = l1.next;
			}

			if (l2 != null) {
				l2 = l2.next;
			}
		}

		if (carry) {
			temp = new ListNode(1);
			prev.next = temp;
		}

		return head.next;
//		return generateListNode(generateNum(l1) + generateNum(l2));
	}

//	public ListNode generateListNode(int num) {
//		ListNode head = null;
//		ListNode temp, temp1 = null;
//		
//		do {
//			int n = num % 10;
//			num = num / 10;
//			
//			temp = new ListNode(n);
//			temp.next = null;
//			if (temp1 != null) {
//				temp1.next = temp;
//			}
//			temp1 = temp;
//			
//			if (head == null) {
//				head = temp;
//			}
//			
//		} while(num > 0);
//		return head;
//	}
//	
//	public int generateNum(ListNode list) {
//		if(list == null) {
//			return 0;
//		}
//		return generateNum(list.next) * 10 + list.val;
//	}
//	
//	public int generateNum(ListNode list) {
//		int num = 0;
//		do {
//			num = num * 10 + list.val;
//			list = list.next;
//		} while (list != null);
//		
//		return num;
//	}
}