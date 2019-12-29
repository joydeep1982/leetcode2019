/**
 * 
 * https://leetcode.com/problems/longest-common-prefix/
 * 
 */
package com.practice.ds.array;

public class LongestCommonPrefix {
	
	public static void main(String[] args) {
		LongestCommonPrefix obj = new LongestCommonPrefix();
		String prefix = obj.longestCommonPrefix(new String[] {"aaflower","saflow","flight"});
		System.out.println("prefix: " + prefix);
	}
	
	public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = getPrefix(strs[i], prefix);
        }
        return prefix;
    }
    
    private String getPrefix(String str, String prefix) {
        int len = Math.min(str.length(), prefix.length());
        int lastMatch = 0;
        for (int i = 0; i < len; i++) {
            if (prefix.charAt(i) == str.charAt(i)) {
                lastMatch = i + 1;
            } else {
                break;
            }
        }
        return prefix.substring(0, lastMatch);
    }

}
