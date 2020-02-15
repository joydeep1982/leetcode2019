/**
 * 
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * 
 */
package com.practice.ds;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class EvaluateReversePolishNotation {
	
	public static void main(String[] args) {
		EvaluateReversePolishNotation obj = new EvaluateReversePolishNotation();
		//int result = obj.evalRPN(new String[] {"2", "1", "+", "3", "*"});
		int result = obj.evalRPN(new String[] {"4", "13", "5", "/", "+"});
		System.out.println("Result: " + result);
	}

	public int evalRPN(String[] tokens) {
		Map<String, BiFunction<Integer, Integer, Integer>> operators = new HashMap<String, BiFunction<Integer, Integer, Integer>>();
		operators.put("+", (a, b) -> a + b);
		operators.put("-", (a, b) -> a - b);
		operators.put("/", (a, b) -> a / b);
		operators.put("*", (a, b) -> a * b);

		Stack<Integer> stack = new Stack<Integer>();

		for (String token : tokens) {
			if (operators.containsKey(token)) {
				Integer a = stack.pop();
				Integer b = stack.pop();
				stack.push(operators.get(token).apply(b, a));
			} else {
				stack.push(Integer.parseInt(token));
			}
		}

		return stack.peek();
	}

}
