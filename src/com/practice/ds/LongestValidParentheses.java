/**
 * 
 * https://leetcode.com/problems/longest-valid-parentheses/
 * 
 */
package com.practice.ds;

import java.util.Stack;

public class LongestValidParentheses {
	
	public static void main(String[] args) {
		LongestValidParentheses o = new LongestValidParentheses();
		int max = o.longestValidParentheses(")()())");
		System.out.println(max);
	}
	
	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == ')') {
				if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
					stack.pop();
				}
				else {
					stack.push(i);
				}
			}
			else {
				stack.add(i);
			}
		}
		
		if (stack.isEmpty()) {
			return s.length();
		}
		
		int max = 0;
		int right = s.length() - 1;
		int idx = 0;
		while (!stack.isEmpty()) {
			idx = stack.pop();
			System.out.println("index: " + idx);
			max = Math.max(max, right - idx);
			right = idx - 1;
		}
		
		max = Math.max(max, idx);
		
		return max;
	}
}