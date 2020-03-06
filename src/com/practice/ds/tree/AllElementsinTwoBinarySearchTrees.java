/**
 * 
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 * 
 */
package com.practice.ds.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import com.practice.ds.beans.TreeNode;

public class AllElementsinTwoBinarySearchTrees {

	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> result = new ArrayList<Integer>();
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		preorder(root1, pq);
		preorder(root2, pq);
		
		while (!pq.isEmpty()) {
			result.add(pq.poll());
		}
		
		return result;	
	}
	
	public void preorder(TreeNode node, PriorityQueue<Integer> pq) {
		if (node == null) {
			return;
		}
		preorder(node.left, pq);
		pq.add(node.val);
		preorder(node.right, pq);
	}
}
