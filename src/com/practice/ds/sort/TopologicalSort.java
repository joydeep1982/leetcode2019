package com.practice.ds.sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import com.practice.ds.beans.GraphNode;

public class TopologicalSort {

	public static void main(String[] args) {
		TopologicalSort ts = new TopologicalSort();

		GraphNode a = new GraphNode("A");
		GraphNode b = new GraphNode("B");
		GraphNode c = new GraphNode("C");
		GraphNode d = new GraphNode("D");
		GraphNode e = new GraphNode("E");
		GraphNode f = new GraphNode("F");
		GraphNode g = new GraphNode("G");
		GraphNode h = new GraphNode("H");

		a.addNeighbour(c);
		b.addNeighbour(c).addNeighbour(d);
		c.addNeighbour(e);
		d.addNeighbour(f);
		e.addNeighbour(h).addNeighbour(f);
		f.addNeighbour(g);

		List<GraphNode> nodes = new ArrayList<GraphNode>();
		nodes.add(a);
		nodes.add(b);
		nodes.add(c);
		nodes.add(d);
		nodes.add(e);
		nodes.add(f);
		nodes.add(g);
		nodes.add(h);

		List<GraphNode> sorted = ts.sort(nodes);
		for (GraphNode graphNode : sorted) {
			System.out.println(graphNode);
		}
	}

	public List<GraphNode> sort(List<GraphNode> nodes) {
		Stack<GraphNode> stack = new Stack<GraphNode>();
		Set<GraphNode> visited = new HashSet<GraphNode>();
		for (GraphNode node : nodes) {
			if (!visited.contains(node)) {
				tsort(node, visited, stack);
			}
		}
		List<GraphNode> sorted = new ArrayList<GraphNode>();
		while (!stack.isEmpty()) {
			sorted.add(stack.pop());
		}

		return sorted;
	}

	public void tsort(GraphNode node, Set<GraphNode> visited, Stack<GraphNode> stack) {
		if (visited.contains(node))
			return;
		visited.add(node);
		Set<GraphNode> neighbours = node.getNeighbours();
		for (GraphNode neighbour : neighbours) {
			tsort(neighbour, visited, stack);
		}
		stack.push(node);
	}

}
