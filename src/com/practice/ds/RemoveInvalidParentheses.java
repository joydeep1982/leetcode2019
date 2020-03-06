/**
 * 
 * https://leetcode.com/problems/remove-invalid-parentheses/
 * 
 */
package com.practice.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveInvalidParentheses {
	
	public static void main(String[] args) {
		RemoveInvalidParentheses o = new RemoveInvalidParentheses();
		o.removeInvalidParentheses("()())()").forEach(System.out::println);
	}

	public List<String> removeInvalidParentheses(String s) {
        List<String> results = new ArrayList<String>();
 		Stack<Integer> stack = new Stack<Integer>();

// 		for (int i = 0; i < s.length(); i++) {
// 			char ch = s.charAt(i);
// 			if (ch == ')') {
// 				if (stack.isEmpty()) {
// 					stack.add(i);
// 				}
// 				else if (s.charAt(stack.peek()) == '(') {
// 					stack.pop();
// 				}
// 			}
// 			else if (ch == '(') {
// 				stack.add(i);
// 			}
// 		}
//
// 		String result = "";
// 		int index = 0;
// 		while (!stack.isEmpty()) {
// 			System.out.println("first " + index + ", " + stack.peek() + " " + s.substring(index, stack.peek()));
// 			result += s.substring(index, stack.peek());
// 			index = stack.pop();
// 		}
//        result += s.substring(index + 1, s.length());
// 		results.add(result);

 		for (int i = s.length() - 1; i >= 0; i--) {
 			char ch = s.charAt(i);
 			if (ch == '(') {
 				if (stack.isEmpty()) {
 					stack.add(i);
 				}
 				else if (s.charAt(stack.peek()) == ')') {
 					stack.pop();
 				}
 			}
 			else if (ch == ')') {
 				stack.add(i);
 			}
 		}

 		String result = "";
 		int index = s.length();
 		while (!stack.isEmpty()) {
 			//System.out.println("second " + stack.peek() + ", " + index + " " + s.substring(stack.peek(), index));
 			result = s.substring(stack.peek(), index);
 			String front = s.substring(0, stack.peek());
 			for (int i = 0; i < front.length(); i++) {
 				if (front.charAt(i) == ')') {
 					result = front.substring(0, i) + front.substring(i + 1) + result;
 					results.add(result);
 				}
 					
 			}
 			index = stack.pop();
 		}
 		results.add(result);


 		return results;   
    }
}
