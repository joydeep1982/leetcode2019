package com.practice.ds.list;

import java.util.PriorityQueue;

import com.practice.ds.beans.ListNode;
import com.practice.ds.miscell.Utils;

public class MergeKSortedSet {

	public static void main(String[] args) {
		ListNode[] lists = new ListNode[3];

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = null;

		ListNode l4 = new ListNode(1);
		ListNode l5 = new ListNode(3);
		ListNode l6 = new ListNode(4);
		l4.next = l5;
		l5.next = l6;
		l6.next = null;

		ListNode l7 = new ListNode(2);
		ListNode l8 = new ListNode(6);
		l7.next = l8;
		l8.next = null;

		lists[0] = l1;
		lists[1] = l4;
		lists[2] = l7;

		MergeKSortedSet obj = new MergeKSortedSet();
		ListNode head = obj.mergeKListsUsingPriorityQueue(lists);
		Utils.print(head);
	}
	
	public ListNode mergeKListsUsingPriorityQueue(ListNode[] lists) {
		ListNode result = new ListNode(-1), currNode = result;
		PriorityQueue<ListNode> heap = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
		for(ListNode node : lists) {
			if(node != null) {
				heap.add(node);
			}
		}
		
		while(!heap.isEmpty()) {
			ListNode minNode = heap.remove();
			if(minNode.next != null) {
				heap.add(minNode.next);
			}
			currNode.next = minNode;
			currNode = currNode.next;
		}
		return result.next;
	}

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode head = new ListNode(-1);
		Integer val = getMin(lists);
		ListNode node, prev = head;
		while (val != null) {
			node = new ListNode(val);
			node.next = null;
			prev.next = node;
			prev = node;
			val = getMin(lists);
		}

		return head.next;
	}

	private Integer getMin(ListNode[] lists) {
		Integer min = null;
		int indexOfMin = -1;
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] == null) {
				continue;
			}
			if (min == null || lists[i].val < min) {
				min = lists[i].val;
				indexOfMin = i;
			}
		}
		if (indexOfMin < 0) {
			return null;
		}
		lists[indexOfMin] = lists[indexOfMin].next;
		return min;
	}

}
