package com.practice.ds.beans;

public class Vertex {
	
	private GraphNode source;
	
	private GraphNode destination;
	
	private Integer weight;
	
	public Vertex(GraphNode source, GraphNode destination, Integer weight) {
		// TODO Auto-generated constructor stub
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	public GraphNode getSource() {
		return source;
	}

	public void setSource(GraphNode source) {
		this.source = source;
	}

	public GraphNode getDestination() {
		return destination;
	}

	public void setDestination(GraphNode destination) {
		this.destination = destination;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	
}
