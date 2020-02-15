/**
 * 
 * https://leetcode.com/problems/word-break-ii/
 * 
 */
package com.practice.ds.string;

import java.util.ArrayList;
import java.util.List;

public class WordBreakII {
	
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		WordBreakII obj = new WordBreakII();
		
		List<String> wordDict = new ArrayList<String>() {{
			add("apple");
			add("pen");
			add("applepen");
			add("pine");
			add("pineapple");
		}};
		
		List<String> results = obj.wordBreak("pineapplepenapple", wordDict);
		for (String result : results) {
			System.out.println(result);
		}
	}
	
	public List<String> wordBreak(String s, List<String> wordDict) {
		
		int left = 0;
		int right = 0;
		
		List<String> results = new ArrayList<String>();
		while (right < s.length()) {
			
		}
		
        return results;
    }
	

}
