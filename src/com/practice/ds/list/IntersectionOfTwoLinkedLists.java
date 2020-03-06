package com.practice.ds.list;

import com.practice.ds.beans.ListNode;

public class IntersectionOfTwoLinkedLists {

	public static void main(String[] args) {
		IntersectionOfTwoLinkedLists o = new IntersectionOfTwoLinkedLists();
		
		ListNode nintyseven = new ListNode(97);
		ListNode nintyeight = new ListNode(98);
		ListNode nintynine = new ListNode(99);
		ListNode hundred = new ListNode(100);
		nintyseven.next = nintyeight;
		nintyeight.next = nintynine;
		nintynine.next = hundred;
		
		ListNode one = new ListNode(1);
//		ListNode two = new ListNode(2);
//		ListNode three = new ListNode(3);
//		ListNode four = new ListNode(4);
//		ListNode five = new ListNode(5);
		one.next = nintyseven;
//		two.next = three;
//		three.next = four;
//		four.next = five;
//		five.next = nintynine;
		
		ListNode eleven = new ListNode(11);
		ListNode twelve = new ListNode(12);
//		ListNode thirteen = new ListNode(13);
		eleven.next = twelve;
		twelve.next = nintyseven;	
//		twelve.next = thirteen;
//		twelve.next = nintynine;
		
		ListNode meetingPoint = o.getIntersectionNode(one,  eleven);
		System.out.println(meetingPoint == null ? "null" : meetingPoint.val);
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		ListNode ptrA = headA;
		ListNode ptrB = headB;
		
		boolean flagA = false;
		boolean flagB = false;

		while (ptrA != ptrB && ptrA != null && ptrB != null) {
			System.out.println(ptrA.val + ", " + ptrB.val);
			
			
			ptrA = ptrA.next;
			ptrB = ptrB.next;

			if (ptrA == null && !flagA) {
				ptrA = headB;
				flagA = true;	
			}
			if (ptrB == null && !flagB) {
				ptrB = headA;
				flagB = true;
			}
			
			if (ptrA == ptrB) {
				return ptrA;
			}
		}

		return null;
	}

}
