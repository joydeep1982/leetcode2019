/**
 * 
 * https://leetcode.com/problems/reorganize-string/
 * 
 */
package com.practice.ds.string;

public class ReorganizeString {
	
	public static void main(String[] args) {
		ReorganizeString obj = new ReorganizeString();
		String result = obj.reorganizeString("eqpspvbpppwpgyppppe");
		System.out.println("Result: " + result);
	}

	public String reorganizeString(String S) {
        int[] count = new int[26];
        
        for (int i = 0; i < S.length(); i++) {
        	count[S.charAt(i) - 'a']++;
        }
        
        return recurse(count, -1, "", S.length());
        
    }

	private String recurse(int[] count, int lastUsedIndex, String result, int size) {
		
		if(size == result.length()) {
			return result;
		}
		
		for (int i = 0;  i < 26; i++) {
			if (i== lastUsedIndex) continue;
			if(count[i] == 0) continue;
			count[i]--;
			String res = recurse(count, i, result + ((char)(i + 'a')), size);
			if (!res.isEmpty()) {
				return res;
			}
			count[i]++;
		}
		
		return "";
	}
	
	
}
