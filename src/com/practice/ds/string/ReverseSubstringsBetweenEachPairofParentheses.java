/**
 * 
 * https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 * 
 */
package com.practice.ds.string;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairofParentheses {

	public static void main(String[] args) {
		ReverseSubstringsBetweenEachPairofParentheses obj = new ReverseSubstringsBetweenEachPairofParentheses();
		System.out.println(obj.reverseParentheses("(abcd)"));
		System.out.println(obj.reverseParentheses("(u(love)i)"));
		System.out.println(obj.reverseParentheses("(ed(et(oc))el)"));
		System.out.println(obj.reverseParentheses("a(bcdefghijkl(mno)p)q"));
	}

	public String reverseParentheses(String s) {
		String result = "";
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			Character ch = s.charAt(i);
			if (ch == ')') {
				String temp = "";
				while (!stack.isEmpty()) {
					Character ch1 = stack.pop();
					if (ch1 == '(') {
						//result = reverse(result);
						break;
					}
					temp += ch1;
				}
				for (int j = 0; j < temp.length(); j++) {
					stack.push(temp.charAt(j));
				}
			} else {
				stack.push(ch);
			}
		}
		
		while (!stack.isEmpty()) {
			result = stack.pop() + result;
		}

		return result;
	}
}
