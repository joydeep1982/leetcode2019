/**
 * 
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * 
 */
package com.practice.ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.practice.ds.beans.TreeNode;

public class BinaryTreeRightSideView {
	
	public static void main(String[] args) {
		BinaryTreeRightSideView obj = new BinaryTreeRightSideView();
		
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		
		one.left = two;
		one.right = three;
		two.right = five;
		three.right = four;
		
		List<Integer> result = obj.rightSideView(one);
		result.forEach(System.out::println);
	}

	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result =  new ArrayList<Integer>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            int length = q.size();
            System.out.println("length: " + length);
            for (int i = 0; i < length ; i++) {
                TreeNode node = q.poll();
                if (node.right != null) q.offer(node.right);
                if (node.left != null) q.offer(node.left);
                if (i == 0) {
                	System.out.println("Adding " + node.val);
                    result.add(node.val);
                }
                else {
                	System.out.println("Skipping: " + node.val);
                }
            }
        }
        return result;
    }
}
