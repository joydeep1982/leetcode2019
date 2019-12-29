/**
 * 
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * 
 */
package com.practice.ds.tree;

import com.practice.ds.beans.TreeNode;

public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		BinaryTreeMaximumPathSum obj =  new BinaryTreeMaximumPathSum();
		
		TreeNode _ten = new TreeNode(-10);
		TreeNode nine =  new TreeNode(9);
		TreeNode twenty = new TreeNode(20);
		TreeNode fifteen = new TreeNode(15);
		TreeNode seven = new TreeNode(7);
		
		TreeNode two = new TreeNode(2);
		TreeNode _one = new TreeNode(-1);
		two.left = _one;
		
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		
		node1.left = node2;
		node1.right = node3;
		
//		_ten.left = nine;
//		_ten.right = twenty;
//		twenty.left = fifteen;
//		twenty.right = seven;
		
		int sum = obj.maxPathSum(two);
		System.out.println(sum);
	}
	
	public int maxPathSum(TreeNode node) {
		if (node == null) return  Integer.MIN_VALUE;
		
		int valRight = (node.right != null ? node.right.val : 0);
		int valLeft = (node.left != null ? node.left.val : 0);
		
		int sum = valRight + valLeft + node.val;
		
		sum  = Math.max(sum, Math.max(node.val + valLeft, node.val + valRight));
		sum = Math.max(sum, node.val);
		return Math.max(Math.max(sum, maxPathSum(node.left)), maxPathSum(node.right));
		
    }
	
}
