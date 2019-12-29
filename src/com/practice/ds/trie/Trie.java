package com.practice.ds.trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {
	
	private Node root = new Node();
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.build(Arrays.asList("hello", "hi", "hell", "how", "heman"));
		
		System.out.println(trie.isPresent("hello"));
		System.out.println(trie.isPresent("hell"));
		System.out.println(trie.isPresent("helen"));
		System.out.println(trie.isPresent("hel"));
	}
	
	public boolean isPresent(String word) {
		System.out.println("searching word " + word);
		return search(root, word, 0);
	}
	
	private boolean search(Node node, String word, int index) {
		if (index >= word.length()) {
			return false;
		}
		Map<Character, Node> nodeMap = node.getNodeMap();
		Character ch = word.charAt(index);
		Node n = nodeMap.get(ch);
		if (n != null) {
			if (word.length() == index + 1) {
				return n.isEnd();
			}
			return search(n, word, index + 1);
		}
		else {
			return false;
		}
	}
	
	public void build(List<String> words) {
		words.forEach(word -> {
			addWord(root, word, 0); print(root);	
		});
	}
	
	private void addWord(Node node, String word, int index) {
		if (index >= word.length()) {
			return;
		}
		Map<Character, Node> nodeMap = node.getNodeMap();
		Character ch = word.charAt(index);
		Node n = nodeMap.get(ch);
		if (n != null)  {
			if (word.length() == index + 1) {
				n.setEnd(true);
			}
			addWord(n, word, index + 1);
		} else {
			Node newNode = new Node();
			newNode.setData(ch);
			newNode.setEnd(index == word.length() - 1);
			nodeMap.put(ch, newNode);
			System.out.println(ch + " is end " + newNode.isEnd());
			addWord(newNode, word, index + 1);
		}
	}
	
	private void print(Node n) {
	}
}


class Node {
	private Character data;
	private Map<Character,Node> nodeMap;
	private boolean end = false;
	public Node() {
		nodeMap =  new HashMap<Character, Node>();
	}
	public Node(Character data) {
		this.data = data;
		nodeMap =  new HashMap<Character, Node>();
	}
	public boolean isEnd() {
		return end;
	}
	public void setEnd(boolean end) {
		this.end = end;
	}
	public Character getData() {
		return data;
	}
	public void setData(Character data) {
		this.data = data;
	}
	public Map<Character, Node> getNodeMap() {
		return nodeMap;
	}
	public void setNodeMap(Map<Character, Node> nodeMap) {
		this.nodeMap = nodeMap;
	}
}