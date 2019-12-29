package com.practice.ds.tree;

public class TreeDepth {
	
	public static void main(String[] args) {
		Node root = new Node("root");
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		Node f = new Node("f");
		Node g = new Node("g");
		
		Node x = new Node("x");
		Node y = new Node("y");
		Node z = new Node("z");
		
		Node t1 = new Node("t1");
		Node t2 = new Node("t2");
		Node t3 = new Node("t3");
		Node t4 = new Node("t4");
		Node t5 = new Node("t5");
		
		root.setLeft(a).setRight(x);
		x.setLeft(y).setRight(z);
		
		a.setLeft(b).setRight(c);
		b.setLeft(d).setRight(e);
		c.setLeft(f).setRight(g);
		
		z.setLeft(t1);
		t1.setLeft(t2);
		t2.setLeft(t3);
		t3.setLeft(t4);
		t4.setLeft(t5);
		
		
		System.out.println(new TreeDepth().findHeight(root));
	}

	public int findHeight(Node node) {
		return height(node, 0);
	}
	
	private int height(Node n, int count) {
		if (n == null) {
			return count;
		}
		
		int left = height(n.getLeft(), count + 1);
		int right = height(n.getRight(), count + 1);
		
		return Math.max(left, right);
	}
}

class Node {
	private String data;
	private Node left;
	private Node right;
	
	public Node(String data) {
		this.data = data;
	}
	
	public String getData() {
		return data;
	}
	public Node setData(String data) {
		this.data = data;
		return this;
	}
	public Node getLeft() {
		return left;
	}
	public Node setLeft(Node left) {
		this.left = left;
		return this;
	}
	public Node getRight() {
		return right;
	}
	public Node setRight(Node right) {
		this.right = right;
		return this;
	}
}
