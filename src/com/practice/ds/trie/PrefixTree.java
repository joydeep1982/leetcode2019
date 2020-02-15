/**
 * 
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * 
 */
package com.practice.ds.trie;

import java.util.HashMap;
import java.util.Map;

public class PrefixTree {
	
	public static void main(String[] args) {
		PrefixTree pTree = new PrefixTree();
		pTree.insert("apple");
		System.out.println(pTree.search("apple"));
	}

	Data root;

    /** Initialize your data structure here. */
    public PrefixTree() {
        root = new Data();
        root.character = null;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Data ele = root;
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if (ele.neighbours.containsKey(ch)) {
                ele = ele.neighbours.get(ch);
                ele.isEndOfWord = ele.isEndOfWord ? true : word.length() - 1 == i;
                continue;
            }
            else {
                Data newData = new Data();
                newData.character = ch;
                newData.isEndOfWord = word.length() - 1 == i;	
                ele.neighbours.put(ch, newData);
                ele = newData;
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Data ele = root;
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if (ele.neighbours.containsKey(ch)) {
                ele = ele.neighbours.get(ch); 
                if (word.length() - 1 == i) {
                    return ele.isEndOfWord;
                }
            }
            else {
                return false;
            }
        }
        return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Data ele = root;
        for (int i = 0; i < prefix.length(); i++) {
            Character ch = prefix.charAt(i);
            if (ele.neighbours.containsKey(ch)) {
                ele = ele.neighbours.get(ch); 
                if (prefix.length() - 1 == i) {
                    return true;
                }
            }
            else {
                return false;
            }
        }
        return true;
    }
}

class Data {
    Character character;
    Map<Character, Data> neighbours;
    boolean isEndOfWord;
    public Data() {
        neighbours = new HashMap<Character, Data>();
    }
}
