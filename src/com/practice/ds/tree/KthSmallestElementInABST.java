/**
 * 
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 
 */
package com.practice.ds.tree;

import java.util.Stack;

import com.practice.ds.beans.TreeNode;

public class KthSmallestElementInABST {

	public static void main(String[] args) {
		
		TreeNode five = new TreeNode(5);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		TreeNode two = new TreeNode(2);
		TreeNode four = new TreeNode(4);
		TreeNode one = new TreeNode(1);
		
		five.left = three;
		five.right = six;
		three.left = two;
		three.right = four;
		two.left = one;
		
		KthSmallestElementInABST obj = new KthSmallestElementInABST();
		int num = obj.kthSmallest(five, 6);
		System.out.println(num);
	}
	
	public int kthSmallest(TreeNode root, int k) {
		if ( k <= 0) return -1;
		return find(root, k, new Stack<Integer>());
	}
	
	public int find(TreeNode root, int k, Stack<Integer> stack) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		int ret = find(root.left, k, stack);
		if (ret < Integer.MAX_VALUE) {
			return ret;
		}
		stack.add(root.val);
		System.out.println("Stack size " + stack.size());
		if (stack.size() == k) {
			System.out.println("Item found");
			return Math.min(ret, stack.pop());
		} else {
			return Math.min(ret, find(root.right, k, stack));
		}
    }
	
}
