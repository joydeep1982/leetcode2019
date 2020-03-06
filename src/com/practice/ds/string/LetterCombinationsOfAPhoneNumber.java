/**
 * 
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 */
package com.practice.ds.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber o = new LetterCombinationsOfAPhoneNumber();
		List<String> results = o.letterCombinations("9731824411");
		results.forEach(System.out::println);
	}

	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0)
			return Collections.emptyList();
		List<String> results = new ArrayList<String>();
		
		Map<Character, List<Character>> mapping = new HashMap<Character, List<Character>>();
		mapping.put('1', Collections.emptyList());
		mapping.put('2', Arrays.asList('a', 'b', 'c'));
		mapping.put('3', Arrays.asList('d', 'e', 'f'));
		mapping.put('4', Arrays.asList('g', 'h', 'i'));
		mapping.put('5', Arrays.asList('j', 'k', 'l'));
		mapping.put('6', Arrays.asList('m', 'n', 'o'));
		mapping.put('7', Arrays.asList('p', 'q', 'r', 's'));
		mapping.put('8', Arrays.asList('t', 'u', 'v'));
		mapping.put('9', Arrays.asList('w', 'x', 'y', 'z'));
		mapping.put('0', Arrays.asList(' '));
		
		generateCombination(digits, mapping, results, "", 0);
		
		return results;
	}

	public void generateCombination(String number, Map<Character, List<Character>> mapping, List<String> results, String result, int pos) {
		if (pos == number.length()) {
			results.add(result);
			return;
		}
		Character ch = number.charAt(pos);
		if (ch == '1') {
			generateCombination(number, mapping, results, result, pos + 1);
		}
		List<Character> alphabets = mapping.get(ch);
		for (Character a : alphabets) {
			generateCombination(number, mapping, results, result + a, pos + 1);
		}
	}
}
