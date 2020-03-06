/**
 * 
 * https://leetcode.com/problems/word-break/
 * 
 */
package com.practice.ds.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
//		["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
		long start = System.currentTimeMillis();
		boolean isPossible = wb.wordBreak(s, Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa",
				"aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));
		System.out.println(isPossible);
		System.out.println("Time taken: " + (System.currentTimeMillis() - start) + " mills");
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> dict = new HashSet<String>();
		for (String word : wordDict) {
			dict.add(word);
		}
		Map<String, Boolean> cachedResult = new HashMap<String, Boolean>();
		return validate(s, dict, cachedResult);
	}

	public boolean validate(String s, Set<String> dict, Map<String, Boolean> cache) {
		if (cache.containsKey(s)) {
			System.out.println("returning from cache");
			return cache.get(s);
		}
		System.out.println("called with " + s);
		if (s.length() == 0) {
			System.out.println("returning true");
			return true;
		}
		boolean result = false;
		for (int i = 0; i < s.length(); i++) {
			String temp = s.substring(0, i + 1);
			System.out.println("Word formed " + temp);
			if (dict.contains(temp)) {
				result = result || validate(s.substring(i + 1), dict, cache);
				if (result) {
					return true;
				}
			}
		}
		cache.put(s, result);
		return result;
	}

}
