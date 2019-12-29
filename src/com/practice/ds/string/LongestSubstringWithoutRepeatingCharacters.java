package com.practice.ds.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
		int longest = obj.lengthOfLongestSubstring("xabcacbbb");
		System.out.println(longest);
	}

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		if (s.length() == 1)
			return 1;

		Set<Character> set = new HashSet<Character>();
		int max = 0;

		int a_ptr = 0;
		int b_ptr = 0;
		while (b_ptr < s.length()) {
			if (!set.contains(s.charAt(b_ptr))) {
				set.add(s.charAt(b_ptr));
				b_ptr++;
				max = Math.max(max, set.size());
			} else {
				set.remove(s.charAt(a_ptr));
				a_ptr++;
			}
		}

		return max;
	}

//	public int lengthOfLongestSubstring(String s) {
//		if (s == null || s.length() == 0) return 0;
//        int[] dp = new int[s.length()];
//        int max = 1;
//        dp[0] = 1;
//        Set<Character> set = new HashSet<Character>();
//        set.add(s.charAt(0));
//        for (int i = 1; i < s.length(); i++) {
//        	Character ch = s.charAt(i);
//        	
//        	if (set.contains(ch)) {
//        		int counter = 1;
//        		for (int j = i - 1; j >= 0; j--) {
//        			if (ch == s.charAt(j)) {
//        				break;
//        			}
//        			counter++;
//        		}
//        		dp[i] = counter;
//        	} else {
//        		dp[i] = dp[i - 1] + 1; 
//        	}
//        	
//        	if (dp[i] > max) {
//        		max = dp[i];
//        	}
//        	
//        	set.add(ch);
//        }
//        
//        for (int i = 0; i < dp.length; i++) {
//        	System.out.print(dp[i]);
//        }
//        
//        System.out.println();
//        
//        return max;
//    }

}
