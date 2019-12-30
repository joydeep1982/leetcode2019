/**
 * 
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 
 */
package com.practice.ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.practice.ds.beans.TreeNode;

public class BinaryTreeLevelOrderTraversal {
	
	public static void main(String[] args) {
		
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three =  new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		
		one.left = two;
		one.right = three;
		two.left = four;
		four.right = five;
		
		BinaryTreeLevelOrderTraversal obj = new BinaryTreeLevelOrderTraversal();
		obj.levelOrder(one);
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        List<Integer> level = null;
        while (!q.isEmpty()) {
            int levelSize = q.size();
            level = new ArrayList<Integer>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);    
                }
            }
            
            levels.add(level);
        }
        
        return levels;
    }
	
	private boolean isValid(TreeNode root, Integer lower, Integer upper) {
        if (root == null) return true;
        
        int val = root.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;
        
        if (! isValid(root.right, val, upper)) return false;
        if (! isValid(root.left, lower, val)) return false;
        return true;
    }
}
