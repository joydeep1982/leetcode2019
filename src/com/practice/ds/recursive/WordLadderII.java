/**
 * 
 * 
 * https://leetcode.com/problems/word-ladder-ii/
 * 
 */
package com.practice.ds.recursive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordLadderII {
	
	int max = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		
		WordLadderII o = new WordLadderII();
		List<List<String>> results = o.findLadders("hit", "cog", wordList);
		
		for (List<String> list : results) {
			for (String s : list) {
				System.out.print(s + "->");
			}
			System.out.println();
		}
	}

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> results = new ArrayList<List<String>>();
		
		Map<String, List<String>> lookup = new HashMap<String, List<String>>();
		for (String word : wordList) {
			for (int i = 0; i < word.length(); i++) {
				String transformedWord = word.substring(0, i) + "*" + word.substring(i + 1);
				List<String> associatedWords = lookup.getOrDefault(transformedWord, new ArrayList<String>());
				associatedWords.add(word);
				lookup.put(transformedWord, associatedWords);
			}
		}
		
		dfs(beginWord, endWord, lookup, new ArrayList<String>(), results, 0);		
		
		return results;
	}

	public void dfs(String word, String endWord, Map<String, List<String>> lookup, List<String> intermediateResult, List<List<String>> results, int level) {
		if (level > max) {
			return;
		}
		if (word.equals(endWord)) {
			if (level < max) {
				results.clear();
				max = level;
			}
			List<String> newlist = new ArrayList<String>();
			for (String s : intermediateResult) {
				newlist.add(s);
			}
			newlist.add(endWord);
			results.add(newlist);
			return;
		}
		if (intermediateResult.contains(word)) {
			return;
		}
		
		intermediateResult.add(word);
		
		for (int i = 0; i < word.length(); i++) {
			String lookupWord = word.substring(0, i) + "*" + word.substring(i + 1);
			if (lookup.containsKey(lookupWord)) {
				List<String> wordList = lookup.get(lookupWord);
				for (String w : wordList) {
					//intermediateResult.add(w);
					dfs(w, endWord, lookup, intermediateResult, results, level + 1);
					//intermediateResult.remove(w);
				}
			}
		}
		
		intermediateResult.remove(word);
	}
}
