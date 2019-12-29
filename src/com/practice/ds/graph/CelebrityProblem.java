package com.practice.ds.graph;

import java.util.HashSet;
import java.util.Set;

/*
 * The Celebrity Problem	
 * https://www.geeksforgeeks.org/the-celebrity-problem/
*/
public class CelebrityProblem {

	public static void main(String[] args) {

	}

	public void init() {
		Node x = new Node("X");

		Node a = new Node("A", x);
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		Node f = new Node("F");
		Node g = new Node("G");
		
		a.addLink(b).addLink(c);
		d.addLink(a).addLink(e).addLink(f);
		b.addLink(a).addLink(f);
		g.addLink(b).addLink(c);
		e.addLink(a);
		
		
		// node x is the celebrity node, all nodes knows x but x knows nobody
		
	}

}

class Node {

	private String data;

	private Set<Node> links;

	public Node(String data) {
		this.data = data;
		this.links = new HashSet<Node>();
	}
	
	public Node(String data, Node node) {
		this.data = data;
		this.links = new HashSet<Node>();
		this.addLink(node);
	}

	public Node(String data, Set<Node> links) {
		this.data = data;
		this.links = new HashSet<Node>();
	}

	public Node addLink(Node node) {
		this.links.add(node);
		return this;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Set<Node> getLinks() {
		return links;
	}

	public void setLinks(Set<Node> links) {
		this.links = links;
	}

}