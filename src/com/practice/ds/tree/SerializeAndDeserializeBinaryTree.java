/**
 * 
 * https://leetcode.com/problems/serialize-and-deserialize-bst/
 * 
 */
package com.practice.ds.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.practice.ds.beans.TreeNode;

public class SerializeAndDeserializeBinaryTree {
	
	public static void main(String[] args) {
		SerializeAndDeserializeBinaryTree obj = new SerializeAndDeserializeBinaryTree();
		
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		
		one.left = two;
		one.right = three;
		two.left = four;
		three.right = five;
		
		
		obj.printTree(one, 0);
		String serializedString = obj.serialize(one);
		System.out.println(serializedString);
		
		TreeNode node = obj.deserialize(serializedString);
		obj.printTree(node, 0);
	}
	
	public String serialize(TreeNode root) {
        if(root == null)
            return "X,";
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<String> remaining = new LinkedList<String>();
        remaining.addAll(Arrays.asList(nodes));
        return deserializeHelper(remaining);
    }

	private TreeNode deserializeHelper(Queue<String> remaining) {
		//System.out.println("=> " + i);
		String data = remaining.poll();
		if (data.equalsIgnoreCase("X"))
			return null;
		TreeNode node = new TreeNode(Integer.parseInt(data));
		node.left = deserializeHelper(remaining);
		node.right = deserializeHelper(remaining);
		return node;
	}
	
	private void printTree(TreeNode node, int indent) {
		if (node == null)
			return;
		for (int i = 0; i < indent * 4; i++) {
			System.out.print(" ");
		}
		System.out.println(node.val);
		printTree(node.left, indent + 1);
		printTree(node.right, indent + 1);
	}

}
