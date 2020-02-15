//package com.practice.ds.graph;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.PriorityQueue;
//
//import com.practice.ds.beans.GraphNode;
//import com.practice.ds.beans.Vertex;
//
//public class Dijkstra {
//
//	public static void main(String[] args) {
//		Dijkstra dijkstra = new Dijkstra();
//
//		GraphNode a = new GraphNode("A");
//		GraphNode b = new GraphNode("B");
//		GraphNode c = new GraphNode("C");
//		GraphNode d = new GraphNode("D");
//		GraphNode e = new GraphNode("E");
//		GraphNode f = new GraphNode("F");
//
//		a.addNeighbour(b, 5).addNeighbour(d, 9).addNeighbour(e, 2);
//		b.addNeighbour(c, 2);
//		c.addNeighbour(d, 3);
//		e.addNeighbour(f, 3);
//		f.addNeighbour(d, 2);
//
//		List<GraphNode> nodes = new ArrayList<GraphNode>();
//		nodes.add(a);
//		nodes.add(b);
//		nodes.add(c);
//		nodes.add(d);
//		nodes.add(e);
//		nodes.add(f);
//
//		dijkstra.shortestPath(nodes, a);
//
//	}
//
//	public void shortestPath(List<GraphNode> nodes, GraphNode source) {
//		Map<GraphNode, GraphNode> introducedBy = new HashMap<GraphNode, GraphNode>();
//		Map<GraphNode, Integer> minDistance = new HashMap<GraphNode, Integer>();
//		Map<GraphNode, Integer> compute = new HashMap<GraphNode, Integer>();
//		PriorityQueue<Vertex> minHeap = new PriorityQueue<Vertex>((a, b) -> a.getWeight() - b.getWeight());
//		
//
//		for (GraphNode node : nodes) {
//			minHeap.offer(node);
//
//		}
//
//	}
//
//	public void computePath() {
//
//	}
//
//}
