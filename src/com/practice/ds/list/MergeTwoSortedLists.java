/**
 * 
2 * https://leetcode.com/problems/merge-two-sorted-lists/
 * 
 */
package com.practice.ds.list;

import com.practice.ds.beans.ListNode;

public class MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode head = null;
        ListNode prev = null;
        
        while (l1 != null || l2 != null) {
            
            ListNode temp = null;
            
            if (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    temp = new ListNode(l2.val);
                    l2 = l2.next;
                } else {
                    temp = new ListNode(l1.val);
                    l1 = l1.next;
                }
            }
            else if (l2 != null){
                temp = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l2 == null) {
                temp = new ListNode(l1.val);
                l1 = l1.next;
            }
            
            if (head == null) {
                head = temp;
            }
            else {
                prev.next = temp;
            }
            prev = temp;
        }
        
        return head;
    }
}
