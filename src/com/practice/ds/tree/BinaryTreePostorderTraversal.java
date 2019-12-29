/**
 * 
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * 
 */
package com.practice.ds.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.practice.ds.beans.TreeNode;

public class BinaryTreePostorderTraversal {
	
	public static void main(String[] args) {
		
		BinaryTreePostorderTraversal obj = new BinaryTreePostorderTraversal();
		
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		TreeNode eight = new TreeNode(8);
		
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		five.left = six;
		three.right = seven;
		seven.right = eight;
		
		obj.postorderTraversal(one).forEach(System.out::println);
	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
		if (root == null) return new ArrayList<Integer>();
		List<Integer> items = new ArrayList<Integer>();
		
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		
		stack1.add(root);
		while (!stack1.isEmpty()) {
			TreeNode current = stack1.pop();
			if (current.left != null)
				stack1.add(current.left);
			if (current.right != null)
				stack1.add(current.right);
			stack2.add(current);
		}
		
		while (!stack2.isEmpty())
			items.add(stack2.pop().val);
		
		return items;
	}
}
