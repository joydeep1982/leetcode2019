/**
 * 
 * https://leetcode.com/problems/decode-string/
 * 
 */
package com.practice.ds.string;

import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
		DecodeString o = new DecodeString();
//		String result = o.decodeString("3[a2[c]]");
		String result = o.decodeString("100[leetcode]");
		System.out.println("Final result: " + result);
	}

	private String decodeString(String s) {
		System.out.println("Input: " + s);
		Stack<Character> stack = new Stack<Character>();

		int x = -1, y = -1;
		for (int i = 0; i < s.length(); i++) {
			Character ch = s.charAt(i);
			if (ch == '[') {
				x = i;
			} else if (ch == ']') {
				y = i;
				break;
			}
			stack.push(ch);
		}

		if (x == -1 || y == -1) {
			return s;
		}

		String a = "";
		int loop = 0;
		int dig = 0;
		while (!stack.isEmpty()) {
			Character ch = stack.pop();
			if (ch == '[') {
				loop = getNumber(stack);
				dig = Integer.toString(loop).length();
				break;
			}
			a = String.valueOf(ch) + a;
		}

		String g = "";
		for (int i = 0; i < loop; i++) {
			g += a;
		}

		String result = s.substring(0, x - 1 - (dig - 1)) + g + s.substring(y + 1, s.length());
		return decodeString(result);
	}

	private int getNumber(Stack<Character> stack) {
		String a = "";
		int num = 0;
		try {
			while (!stack.isEmpty()) {
				Character ch = stack.peek();
				Integer.parseInt(String.valueOf(ch));
				a = ch + a;
				stack.pop();
			}
		} catch (NumberFormatException nfe) {
			
		} finally {
			num = Integer.parseInt(a);
		}
		System.out.println("returing: " + num);
		return num;
	}

}
