/**
 * 
 * https://leetcode.com/problems/word-break-ii/
 * 
 */
package com.practice.ds.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {
	
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		WordBreakII obj = new WordBreakII();
		
//		"catsanddog"
//		["cat","cats","and","sand","dog"]
		
//		"pineapplepenapple"
//		["apple","pen","applepen","pine","pineapple"]
		
//		List<String> results = obj.wordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog"));
		List<String> results = obj.wordBreak("pineapplepenapple", Arrays.asList("apple","pen","applepen","pine","pineapple"));
		for (String result : results) {
			System.out.println("result: " + result);
		}
	}
	
	public List<String> wordBreak(String s, List<String> wordDict) {
		Set<String> dict = new HashSet<String>();
		for (String word : wordDict) {
			dict.add(word);
		}
		Set<String> cachedResult = new HashSet<String>();
		return validate(s, dict, new ArrayList<String>(), cachedResult);
		
    }
	
	public List<String> validate(String s, Set<String> dict, List<String> collected, Set<String> cache) {
		List<String> results = new ArrayList<String>();
		System.out.println("called with " + s);
		if (!dict.contains(s) && cache.contains(s)) {
			System.out.println("ignored");
			return Collections.emptyList();
		}
		System.out.println("considered");
		if (s.length() == 0) {
			System.out.println("collected " + String.join(" ", collected));
			return collected;
		}
		for (int i = 0; i < s.length(); i++) {
			String temp = s.substring(0, i + 1);
			if (dict.contains(temp)) {
				System.out.println(temp);
				collected.add(temp);
				List<String> result = validate(s.substring(i + 1), dict, collected, cache);
				if (!result.isEmpty()) {
					System.out.println("adding result");
					results.add(String.join(" ", result));
				}
				collected.remove(temp);
			}
		}
		cache.add(s);
		return results;
	}
	

}
