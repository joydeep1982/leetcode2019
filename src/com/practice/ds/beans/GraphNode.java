package com.practice.ds.beans;

import java.util.HashSet;
import java.util.Set;

public class GraphNode {
	
	private String text;
	
	private Set<GraphNode> neighbours;
	
	private Set<Vertex> _neighbours;
	
	public GraphNode(String text) {
		// TODO Auto-generated constructor stub
		this.text = text;
		this.neighbours = new HashSet<GraphNode>();
		this._neighbours = new HashSet<Vertex>();
	}
	
	public GraphNode addNeighbour(GraphNode node) {
		this.neighbours.add(node);
		return this;
	}
	
	public GraphNode addNeighbour(GraphNode node, Integer weight) {
		this._neighbours.add(new Vertex(this, node, weight));
		return this;
	}
	
	public GraphNode addNeighbour(Vertex v) {
		this._neighbours.add(v);
		return this;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Set<GraphNode> getNeighbours() {
		return neighbours;
	}
	
	public Set<Vertex> getWeightedNeighbours() {
		return _neighbours;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.text;
	}
}
