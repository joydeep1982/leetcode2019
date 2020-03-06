/**
 * 
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * 
 */
package com.practice.ds.tree;

import com.practice.ds.beans.ListNode;
import com.practice.ds.beans.TreeNode;

public class ConvertSortedListToBinarySearchTree {
	
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		
		ConvertSortedListToBinarySearchTree o = new ConvertSortedListToBinarySearchTree();
		TreeNode root = o.sortedListToBST(one);
		System.out.println(root);
	}
	
	public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head);
    }
    
    public TreeNode buildTree(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode head = node;
        if (head.next == null) {
        	return new TreeNode(node.val);
        }
        ListNode previousToMid = getPreviousNodeToMid(node);
        if (previousToMid.next == null) {
            return null;
        }
        ListNode mid = previousToMid.next;
        previousToMid.next = null;
        ListNode start = mid.next;
        mid.next = null;
        
        TreeNode newNode = new TreeNode(mid.val);
        newNode.left = buildTree(head);
        newNode.right = buildTree(start);
        return newNode;
    }
    
    public ListNode getPreviousNodeToMid(ListNode node) {
        if (node == null) 
            return null;
        ListNode prev = null;
        ListNode slow = node;
        ListNode fast = node;
        int count = 0;
        while (fast.next != null) {
            fast = fast.next;
            count++;
            if (count % 2 == 0) {
            	prev = slow;
                slow = slow.next;
            }
        }
        return prev == null ? node : prev;
    }

}
