/**
 * 
 * https://leetcode.com/problems/generate-parentheses/
 * 
 */
package com.practice.ds.recursive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		GenerateParentheses gp = new GenerateParentheses();
		List<String> results = gp.generateParenthesis(3);
		results.forEach(System.out::println);
	}

	public List<String> generateParenthesis(int n) {
		if (n <= 0) 
			return Collections.emptyList();
		List<String> results = new ArrayList<String>();
		generate(n, n, "", results);
		return results;
	}

	public void generate(int openRemaining, int closeRemaining, String result, List<String> results) {
		if (openRemaining == 0 && closeRemaining == 0) {
			results.add(result);
			return;
		}
		boolean isCloseAllowed = closeRemaining > openRemaining;
		if (openRemaining > 0) {
			generate(openRemaining - 1, closeRemaining, result + "(", results);
		}
		if (isCloseAllowed && closeRemaining > 0) {
			generate(openRemaining, closeRemaining - 1, result + ")", results);
		}
	}
}
