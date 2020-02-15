/**
 * 
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * 
 */
package com.practice.ds.tree;

import com.practice.ds.beans.TreeNode;
import com.practice.ds.miscell.Utils;

public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		BinaryTreeMaximumPathSum obj = new BinaryTreeMaximumPathSum();

		TreeNode root = Utils.buildTree(new Integer[] {5,4,8,11,null,13,4,7,2,null,null,null,1}, 0);

		int sum = obj.maxPathSum(root);
		System.out.println(sum);
	}

	public int maxPathSum(TreeNode node) {
		if (node == null)
			return Integer.MIN_VALUE;

		int leftval = maxPathSum(node.left);

		int rightval = maxPathSum(node.right);

		int allsum = node.val + (node.left == null ? 0 : leftval) + (node.right == null ? 0 : rightval);
		leftval = node.left == null ? Integer.MIN_VALUE : Math.max(leftval, node.left.val + node.val);
		rightval = node.right == null ? Integer.MIN_VALUE : Math.max(rightval, node.right.val + node.val);
		
		int ret = Math.max(Math.max(Math.max(node.val, leftval), rightval), allsum);
		
		System.out.println("for node " + node.val);
		System.out.println("all: " + allsum);
		System.out.println("left: " + leftval);
		System.out.println("right: " + rightval);
		System.out.println("choosing: " + ret);
		System.out.println();
		System.out.println();

		return ret;
	}

//	public int maxPathSum(TreeNode node) {
//		if (node == null) return  Integer.MIN_VALUE;
//		
//		int valRight = (node.right != null ? node.right.val : 0);
//		int valLeft = (node.left != null ? node.left.val : 0);
//		
//		int sum = valRight + valLeft + node.val;
//		
//		sum  = Math.max(sum, Math.max(node.val + valLeft, node.val + valRight));
//		sum = Math.max(sum, node.val);
//		return Math.max(Math.max(sum, maxPathSum(node.left)), maxPathSum(node.right));
//		
//    }

}
