/**
 * 
 * https://leetcode.com/problems/balanced-binary-tree/
 * 
 */
package com.practice.ds.tree;

import com.practice.ds.beans.TreeNode;
import com.practice.ds.miscell.Utils;

public class BalancedBinaryTree {
	
	public static void main(String[] args) {
		BalancedBinaryTree bTree = new BalancedBinaryTree();
		TreeNode root = Utils.buildTree(new Integer[] {3,9,20,null,null,15,7}, 0);
		boolean b = bTree.isBalanced(root);
		System.out.println(b);
	}
	
	public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    
    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }   
        
        int left = height(node.left);
        int right = height(node.right);
        
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        
        return 1 + Math.max(left, right);
    }
}
